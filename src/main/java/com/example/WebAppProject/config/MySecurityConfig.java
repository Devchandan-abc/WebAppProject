//package com.example.WebAppProject.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
/*
@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()//inmemory authenticatication 
        //stored in temporary memory or inmemory somewhere
            .withUser("dev")  // Replace with your desired username
            .password(this.passwordEncoder().encode("root1")) // Replace with your desired password
            //password will be encooded
       .roles("USER");
        //saved indb with encrypted format and stored in db
	
}
   /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()//for post request if requestred is non browser//it is an attck which spring security saves us
            .authorizeRequests()//authorize the request
           // .antMatchers("/images").authenticated() // Secure the POST API endpoint
            .anyRequest().authenticated().and().httpBasic();//it is basic auth
        //any request should be authenticated and it is basic auth-it will not open form
        //authenticatication mechanism is basic auth not form based
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/save", "/image")
            .hasRole("USER") // Secure the /save and /image POST endpoints
            .anyRequest().permitAll() // Allow other requests without authentication
            .and().httpBasic();
    }

    //password encoder-will encode the password
    //It effectively means that passwords are stored in plain text without any encryption/hashoing
    //password should not be stored in plain text it should be stored secure format
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
    
    
    
    //creating the bean and can be used used anywhere
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
*/