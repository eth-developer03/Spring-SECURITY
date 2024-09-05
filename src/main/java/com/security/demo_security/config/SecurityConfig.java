package com.security.demo_security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //new config file to refer
@EnableWebSecurity // no default flow
public class SecurityConfig {
    
@Autowired
private UserDetailsService userDetailsService;

    @Bean //security filter chain
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(customizer->customizer.disable());
        http.authorizeHttpRequests(request->request.anyRequest().authenticated());
        // http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults()); // for seeing via postman and entering application.process credentials

        http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // for stateless session (for each new reource or request it will asf for login so we commented formlogin above code)
        return http.build();
    }



    // used for accessing password from db
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }




    // used only if we want hard coded pass and user
    // @Bean  // spring security can take bean from ioc container
    // public UserDetailsService userDetailsService() {

    //    UserDetails user1=User.withDefaultPasswordEncoder()
    //    .username("kartikeya")
    //    .password("2")
    //    .roles("USER")
    //    .build(); // by build we built this object 




    //    UserDetails user2=User.withDefaultPasswordEncoder()
    //    .username("pandey")
    //    .password("6")
    //    .roles("ADMIN")
    //    .build();

    //    return new InMemoryUserDetailsManager(user1,user2);

    // }



}
