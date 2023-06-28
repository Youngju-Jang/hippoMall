package hello.spring.global.security;

import hello.spring.entity.User;
import hello.spring.data.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
     
     private final UserRepository repository;
     
     // 인증이 필요한 UserDetails객체를 반환함
     @Override
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          Optional<User> user = repository.findByUsername(username);
          
          UserBuilder builder = null; // 인증할 사용자를 만들 때 사용
          if (user.isPresent()) {
               User currentUser = user.get();
               builder = org.springframework.security.core.userdetails.User.withUsername(username);
               builder.password(currentUser.getPassword());
               builder.roles(currentUser.getRole().name());
          } else {
               throw new UsernameNotFoundException("User not found.");
          }
          return builder.build();
     }
}
