package com.finches.finchesservice.security.config;

import com.finches.finchesservice.controllers.LoginControllerImpl;
import com.finches.finchesservice.controllers.UserDetailsControllerImpl;
import com.finches.finchesservice.security.filters.AuthenticationFilter;
import com.finches.finchesservice.security.others.JwtAuthenticationEntryPoint;
import com.finches.finchesservice.services.business.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final String LOGIN = linkTo(methodOn(LoginControllerImpl.class).loginUser(null)).toUri().toString();
    private final String USER = linkTo(methodOn(UserDetailsControllerImpl.class).save(null)).toUri().toString();
    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Autowired
    private UserDetailsServiceImpl jwtUserDetailsService;
    @Autowired
    private AuthenticationFilter jwtRequestFilter;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers(LOGIN).permitAll()
                .antMatchers(HttpMethod.POST, USER).permitAll().anyRequest().authenticated()
                .and().exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

}
