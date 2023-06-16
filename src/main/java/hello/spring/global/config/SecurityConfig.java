package hello.spring.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // 스프링 Security 지원을 가능하게 함
public class SecurityConfig {
     @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
          // cors 설정
          http.cors();
          // CSRF 설정
          http.csrf().disable();
          
          http
               .authorizeHttpRequests((requests) -> requests
                    .antMatchers("/user/**").permitAll()
                    .anyRequest().authenticated()
               )
               .formLogin((form) -> form
                    .loginPage("/user/login")
                    .permitAll()
               )
               .logout(LogoutConfigurer::permitAll);
          
          return http.build();
     }
     
     @Bean // 비밀번호 암호화 기능 등록
     public PasswordEncoder passwordEncoder() {
          return PasswordEncoderFactories.createDelegatingPasswordEncoder();
     }
     
//     @Bean
//     public UserDetailsService userDetailsService() {
//          PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//          UserDetails user = User.withUsername("user")
//               .password(encoder.encode("password"))
//               .roles("USER")
//               .build();
//
//          return new InMemoryUserDetailsManager(user);
//     }
}

