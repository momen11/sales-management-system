package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
//password is "fun123"
@Configuration
public class DemoSecurityConfig {
    //add support for JDBC ... no more hardcoded users
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager=new JdbcUserDetailsManager(dataSource);
        //define query to retrieve user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");

        //define query to retrieve authentication/role by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");
        return jdbcUserDetailsManager;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer->
                configurer
                        .requestMatchers(HttpMethod.GET,"/api/client").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/client/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/client").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/client").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/client/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET,"/api/product").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/product/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/product").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/product").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/product/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET,"/api/sales").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/sales/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/sales").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/sales").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/sales/**").hasRole("ADMIN")


                        .requestMatchers(HttpMethod.GET,"/api/saller").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/saller/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/saller").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/saller").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/saller/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET,"/api/transaction").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/transaction/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/transaction").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/transaction").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/transaction/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET,"/api/report").hasRole("MANAGER")

        );
//use Http Basic authentication
        http.httpBasic(Customizer.withDefaults());

        //disable Cross Site Request Forgery (CSRF)
        //IN GENERAL , not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
        http.csrf(csrf->csrf.disable());
        return http.build();
    }


    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

return new InMemoryUserDetailsManager(john,mary,susan);

    }
*/
}