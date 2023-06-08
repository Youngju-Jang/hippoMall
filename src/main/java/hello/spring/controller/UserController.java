package hello.spring.controller;

import hello.spring.dto.AuthInfo;
import hello.spring.entity.User;
import hello.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
     private final UserService userService;
     
     @PostMapping ("/login")
     public ResponseEntity<AuthInfo> postLogin(@RequestBody User user,
                                               @RequestParam (value = "checker", required = false) String checker,
                                               HttpServletResponse response,
                                               HttpServletRequest request) {
          String name = user.getName();
          String password = user.getPassword();
          
          return new ResponseEntity<>(userService.loginByNameAndPassword(name, password, request), HttpStatus.OK);
     }
     
     
     @PostMapping("/signup")
     public ResponseEntity<Long> signup(@RequestBody User user){
          return new ResponseEntity<>(userService.signup(user), HttpStatus.OK);
     }
}
