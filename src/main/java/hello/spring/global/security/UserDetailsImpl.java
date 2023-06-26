package hello.spring.global.security;

import hello.spring.entity.User;
import hello.spring.entity.UserRoleEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@RequiredArgsConstructor
@Getter
public class UserDetailsImpl implements UserDetails {
     
     //인증이 완료된 사용자 추가
     private final User user; // 인증완료된 User 객체
     private final String username; // 인증완료된 User의 ID
     private final String password; // 인증완료된 User의 PWD
     private final UserRoleEnum role;
     @Override
     public Collection<? extends GrantedAuthority> getAuthorities() {
          UserRoleEnum role = user.getRole();
//          String authority = role.getAuthority();
          String authority = "ROLE_" + role;
          
          SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(authority);
          Collection<GrantedAuthority> authorities = new ArrayList<>();
          authorities.add(simpleGrantedAuthority);
          
          return authorities;
     }
     
     @Override
     public String getPassword() {
          return null;
     }
     
     @Override
     public String getUsername() {
          return null;
     }
     
     @Override
     public boolean isAccountNonExpired() {
          return false;
     }
     
     @Override
     public boolean isAccountNonLocked() {
          return false;
     }
     
     @Override
     public boolean isCredentialsNonExpired() {
          return false;
     }
     
     @Override
     public boolean isEnabled() {
          return false;
     }
}
