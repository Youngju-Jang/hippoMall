package hello.spring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class User {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(nullable = false, updatable = false)
     private int userId;
     
     @Column(nullable = false, unique = true)
     private String name;
     
     @Column(nullable = false)
     private String password;
     
     @Column(nullable = false)
     private UserRoleEnum role = UserRoleEnum.USER;
     public User(String name, String password, UserRoleEnum role){
          this.name = name;
          this.password = password;
          this.role = role;
     }
}
