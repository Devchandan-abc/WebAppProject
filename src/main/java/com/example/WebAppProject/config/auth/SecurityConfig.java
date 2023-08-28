package com.example.WebAppProject.config.auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends  WebSecurityConfigurerAdapter{
	 @Autowired
private CustomUserDetailsService service1;
	 @Autowired
	   private JwtFilter jwtFilter;
//takinng the argument as AuthenticationManagerBuilder object
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService( service1);
	        //.passwordEncoder(passwordEncoder());
	    }
	    //this is for encoding the password 
	    @Bean
	    public PasswordEncoder passwordEncoder(){
	        return NoOpPasswordEncoder.getInstance();
	    	//return new BCryptPasswordEncoder();
	    }
//creating bean with name authentication manager
	    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	    @Override
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable().//save from outside attack
	        authorizeRequests().
	       antMatchers("/authenticate","/save")//dont generate security for this request
	               . permitAll().
	                anyRequest().
	                authenticated()
	                .and().exceptionHandling().and().sessionManagement()
	                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	        
	        //It follows stateless authentication mechanismall the user input will not be saved in server memory and cookies 
	        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	    }
}
	   


/* we dont want to give username and password in each request .we dont need to pass the username and password in each request
 * Jwt token contains input in encrypted format which is username  and password 
 * */
 