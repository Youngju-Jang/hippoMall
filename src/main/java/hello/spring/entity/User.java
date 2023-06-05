package hello.spring.entity;

import hello.spring.dto.AuthInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class User {
     private int userId;
     private String name;
     private String password;
}
