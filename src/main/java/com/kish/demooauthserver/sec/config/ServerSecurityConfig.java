package com.kish.demooauthserver.sec.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

@Configuration
public class ServerSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Value("${resource.id:spring-boot-application}")
    private String resourceId;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username,password, enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, authority from authorities where username=?");


//        auth.inMemoryAuthentication()
//                .withUser("john").password("123").roles("USER");
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean()
            throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll();
    }

    @Override

    public void configure(ResourceServerSecurityConfigurer resources) {

        resources.resourceId(resourceId);

    }

//    @Override
//
//    public void configure(HttpSecurity http) throws Exception {
//
//        http.requestMatcher(new OAuthRequestedMatcher())
//
//                .authorizeRequests()
//
//                .antMatchers(HttpMethod.OPTIONS).permitAll()
//
//                .anyRequest().authenticated();
//
//    }


    private static class OAuthRequestedMatcher implements RequestMatcher {

        public boolean matches(HttpServletRequest request) {

            String auth = request.getHeader("Authorization");

            // Determine if the client request contained an OAuth Authorization

            boolean haveOauth2Token = (auth != null) && auth.startsWith("Bearer");

            boolean haveAccessToken = request.getParameter("access_token")!=null;

            return haveOauth2Token || haveAccessToken;

        }

    }
}
