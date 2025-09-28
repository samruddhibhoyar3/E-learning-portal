package portal.elearning.UserService.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // modern way to disable CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/register").permitAll() // public endpoints
                        .anyRequest().authenticated()                       // secure others
                );

        return http.build();
    }
}
