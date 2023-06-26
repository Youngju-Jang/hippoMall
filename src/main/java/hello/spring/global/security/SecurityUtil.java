package hello.spring.global.security;

import hello.spring.entity.User;
import hello.spring.global.RestApiException;
import hello.spring.global.dto.ErrorResult;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


@Slf4j
@NoArgsConstructor
public class SecurityUtil {
     public static User getCurrentUser() {
          //실험용
          if(SecurityContextHolder.getContext()==null){
               log.info(">>>>>>>>>>>SecurityContextHolder.getContext() : {}", SecurityContextHolder.getContext());
          }
          final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
          if (authentication == null) {
               throw new RestApiException(ErrorResult.NOT_FOUND_AUTHORIZATION_IN_SECURITY_CONTEXT);
          }
          
          if (authentication.getPrincipal() instanceof UserDetails) {
               UserDetailsImpl springSecurityUser = (UserDetailsImpl) authentication.getPrincipal();
               return springSecurityUser.getUser();
          }else {
//               throw new RestApiException(Code.NOT_FOUND_AUTHORIZATION_IN_SECURITY_CONTEXT);
               return null;
          }
     }
}
