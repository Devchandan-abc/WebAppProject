package com.example.WebAppProject.config.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

//here we write logic to validate token and generate token

@Component
public class JwtUtil {
	 private String secret = "javatechie";

	    public String extractUsername(String token) {
	        return extractClaim(token, Claims::getSubject);
	    }

	    public Date extractExpiration(String token) {
	        return extractClaim(token, Claims::getExpiration);
	    }

	    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
	        final Claims claims = extractAllClaims(token);
	        return claimsResolver.apply(claims);
	    }
	    private Claims extractAllClaims(String token) {
	        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	    }
	    //seeing the tken is expired or not

	    private Boolean isTokenExpired(String token) {
	        return extractExpiration(token).before(new Date());
	    }
//based on username will generate the token
	    //we are creating the empty map
	    //based on username we create token
	    public String generateToken(String username) {
	        Map<String, Object> claims = new HashMap<>();
	        return createToken(claims, username);
	    }

	    private String createToken(Map<String, Object> claims, String subject) {

	        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
	                .setExpiration(new Date(System.currentTimeMillis() + 1*60 * 1000 ))
	                //10 second expiry time
	                //10*60*60
	                //setting the expiry date and expiry of token
	                //signWith--the algorith we are using 
	                .signWith(SignatureAlgorithm.HS256, secret).compact();
}
//validating the token token will be generated in encrypted format from it will extract username and pwd
	    

	    public Boolean validateToken(String token, UserDetails userDetails) {
	        final String username = extractUsername(token);
	        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	    }

}

