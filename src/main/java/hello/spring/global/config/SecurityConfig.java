package hello.spring.global.config;

import hello.spring.global.security.JwtAuthFilter;
import hello.spring.global.security.JwtUtil;
import hello.spring.global.security.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity // 스프링 Security 지원을 가능하게 함
@RequiredArgsConstructor
public class SecurityConfig {
     
     private final JwtUtil jwtUtil;
     private final UserDetailsServiceImpl userDetailsService;
     
     @Bean // 인증 및 권한 부여 규칙을 설정
     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
          // cors 설정
          http.cors();
          // CSRF 설정
          http.csrf().disable();
          http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
          
//          http.authorizeHttpRequests()
          http.authorizeRequests()
               .antMatchers("/user/**").permitAll()
               .anyRequest().authenticated()
               .and().addFilterBefore(new JwtAuthFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class);
          ;
//               .and()
//                    .formLogin()
//                    .loginPage("/user/login")
//                    .defaultSuccessUrl("/")
//               .and()
//                    .logout()
//                    .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
//                    .logoutSuccessUrl("/")
//                    .invalidateHttpSession(true)
//               .anyRequest().authenticated()
//          ;
          
          return http.build();
     }
     
     @Bean // 비밀번호 암호화 기능 등록
     public PasswordEncoder passwordEncoder() {
//          return PasswordEncoderFactories.createDelegatingPasswordEncoder();
          return new BCryptPasswordEncoder();
     }
     
     @Bean
     AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
          return authenticationConfiguration.getAuthenticationManager();
     }
}

