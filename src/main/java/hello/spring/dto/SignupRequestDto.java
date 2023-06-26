package hello.spring.dto;

import hello.spring.entity.UserRoleEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SignupRequestDto {
     private String name;
     private String password;
     private UserRoleEnum role= UserRoleEnum.USER;
}
