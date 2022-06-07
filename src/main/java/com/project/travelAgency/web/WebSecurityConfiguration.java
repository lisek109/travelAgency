package com.project.travelAgency.web;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

   // public WebSecurityConfiguration(@Qualifier("userService") final UserService userService) {
   //     this.userDetailsService = userService;
   // }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers(HttpMethod.GET, "/main/**")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();



                //csrf().disable();
       // http.sessionManagement().sessionCreationPolicy(STATELESS);
       // http.httpBasic()
                //.and()
                //.authorizeRequests().antMatchers(HttpMethod.GET, "/user/**").authenticated()
                //.antMatchers("/user/**")
                //.permitAll()

                .antMatchers("/user/**").permitAll()
                .and()
                .formLogin().permitAll()

                ;
    }

  //  @Override
  //  protected UserDetailsService userDetailsService() {
  //      return userDetailsService;
  //  }

}
