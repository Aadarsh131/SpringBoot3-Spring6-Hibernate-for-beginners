package com.challengeFifteenDays.RestCRUDapisWithJPABasicProject.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    /*
    // DEFAULT JDBC database/table schema support (no need of configs)
    //adding support to jdbc to manager users from the DEFAULT database schema, if we want our own table names, then we have to configure it
    //NOTE: no need to restart app in case of password changes in db, spring security will query db for each login
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }
    */



    //CUSTOM JDBC table schema (but needs configs to know the username and roles)
    @Bean
    public UserDetailsManager userDetailsManager (DataSource dataSource){
        JdbcUserDetailsManager a = new JdbcUserDetailsManager(dataSource);

        //define query to retrieve a user by username
        a.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");//? would be filled by the user in the login form

        //retrieve authorities/role based on the username
        a.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");

        return a;
    }




    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
            http.authorizeHttpRequests(configurer->
                    configurer
                    .requestMatchers(HttpMethod.GET,"api/employees").hasRole("EMPLOYEE").requestMatchers(HttpMethod.GET,"api/employees/**").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.PUT,"api/employees").hasRole("MANAGER").requestMatchers(HttpMethod.POST,"api/employees").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.DELETE,"api/employees/**").hasRole("ADMIN"));

            //use basic http auth
            http.httpBasic();

            //disbale CSRF, not required in stateless rest apis (used mostly in html forms)
            http.csrf().disable();

            return http.build();

    }



/*
    //Hardcoded users, we can also user JDBC to get users from the db
    @Bean
    //there are different types of authentication and authorization mechanism:
    //In-memory,JDBC, LDAP, custom/pluggable, and many more
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails aadarsh = User.builder()
                .username("aadarsh")
                .password("{noop}9419")
                //password storage algorithms
                //noop(no operation) - for plain text password
                //bcrypt- for Bcrypt password hashing (one way I think)
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        UserDetails atul = User.builder()
                .username("atul")
                .password("{noop}atul")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails suraj = User.builder()
                .username("suraj")
                .password("{noop}suraj")
                .roles("EMPLOYEE")
                .build();

        return new InMemoryUserDetailsManager(aadarsh,atul,suraj);
    }
*/
}
