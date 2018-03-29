/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkhomenko.security;

import static com.parkhomenko.security.JWTAuthenticationFilter.SIGN_UP_URL;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 *
 * @author dmytro
 */
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    public static final String USERNAME_PARAMETER = "login";
    public static final String LOGIN_URL = "/customers/login";
    
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    public WebSecurity(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder, RestAuthenticationEntryPoint restAuthenticationEntryPoint) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
    }
  

    /**
     * A method where we can define which resources are public and which are 
     * secured. In our case, we set the SIGN_UP_URL endpoint as being public 
     * and everything else as being secured. We also configure 
     * CORS (Cross-Origin Resource Sharing) support through http.cors() and we 
     * add a custom security filter in the Spring Security filter chain.
     * 
     * @param http
     * @throws Exception 
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        final JWTAuthenticationFilter jwtAuthenticationFilter = 
                new JWTAuthenticationFilter(authenticationManager());
        jwtAuthenticationFilter.setUsernameParameter(USERNAME_PARAMETER);
        jwtAuthenticationFilter
                .setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(LOGIN_URL, "POST"));
        
        http.cors()
                .and()
                .csrf().disable()
                .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll()
                .antMatchers(HttpMethod.POST, LOGIN_URL).permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(jwtAuthenticationFilter)
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                // this disables session creation on Spring Security
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    /**
     * A method where we defined a custom implementation of UserDetailsService
     * to load user-specific data in the security framework. We have also used 
     * this method to set the encrypt method used by our application 
     * (BCryptPasswordEncoder).
     * 
     * @param auth
     * @throws Exception 
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    /**
     * A method where we can allow/restrict our CORS support. In our case we 
     * left it wide open by permitting requests from any source (/**)
     * 
     * @return 
     */
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
}
