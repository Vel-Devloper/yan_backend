package com.sevael.yanmar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

//import jakarta.servlet.http.HttpServletRequest;
//import java.util.Arrays;
import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        .csrf(csrf -> csrf.disable()) // disables CsSRF
        .cors(Customizer.withDefaults()) // Modern way to enable CORS
        .authorizeHttpRequests(auth -> auth
            .anyRequest().permitAll() // allows all requests
        );
        return http.build();
    }
  
 // Dynamically resolve allowed origin at runtime
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        return (HttpServletRequest request) -> {
//            String origin = request.getHeader("Origin");
//
//            List<String> allowedOrigins = List.of(
//                "http://localhost:3000",
//                "https://yanmar.sevael.com",
//                "https://127.0.0.1:3000",
//                "https://127.0.0.1:5173",
//                "https://135.13.39.201",
//                "https://192.168.146.77"
//            );
//
//            CorsConfiguration config = new CorsConfiguration();
//            if (origin != null && allowedOrigins.contains(origin)) {
//                config.setAllowedOrigins(List.of(origin)); // Only allow known origins
//            }
//
//            config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//            config.setAllowedHeaders(List.of("*"));
//            config.setAllowCredentials(true);
//
//            return config;
//        };
//    }
//    
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOriginPatterns(List.of("*")); // use allowedOriginPatterns instead of allowedOrigins
        config.setAllowedMethods(List.of("*"));
        config.setAllowedHeaders(List.of("*"));
        config.setAllowCredentials(false); // required if using "*"

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}