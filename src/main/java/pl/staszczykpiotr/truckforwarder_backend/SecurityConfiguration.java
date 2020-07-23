package pl.staszczykpiotr.truckforwarder_backend;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {




    @Override
    protected void configure(HttpSecurity httpSecurity)
            throws Exception {
        httpSecurity.csrf().disable();


        httpSecurity.authorizeRequests()
                .antMatchers("/principal")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("http://localhost:8080/principal").usernameParameter("username").passwordParameter("password");



        httpSecurity.headers()
                .frameOptions()
                .sameOrigin();
    }


    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder builder, MyUserDetailService myUserDetailService) throws Exception {
//        builder.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("select username,password,enabled from users where username = ?")
//                .authoritiesByUsernameQuery("select username,authority from authorities where username = ?")
//
//        ;
        builder.userDetailsService(myUserDetailService)
                .passwordEncoder(passwordEncoder());


    }

        @Bean
        public PasswordEncoder passwordEncoder () {
            return new BCryptPasswordEncoder();
        }


    }



