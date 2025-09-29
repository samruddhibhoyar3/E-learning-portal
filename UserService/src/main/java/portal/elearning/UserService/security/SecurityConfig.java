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
                        .requestMatchers("/register","/login","/getAllUsers").permitAll() // public endpoints
                        .anyRequest().authenticated()                       // secure others
                ).formLogin(form -> form.disable()) // disable Spring Security default login form
                .httpBasic(httpBasic -> httpBasic.disable());
        // disable basic auth if not needed;

        return http.build();
    }
}
//when we add spring-security dependency im pom.xml it automatically blocks all the http request except/error
// thus we need to create the security config file