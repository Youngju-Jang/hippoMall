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
                                               HttpServletRequest request
          , HttpServletResponse response) {
          String name = user.getName();
          String password = user.getPassword();
          //쿠키 가능한가?
          Cookie cookie = new Cookie("name", name);
          cookie.setMaxAge((checker != null) ? 500 : 0);
          response.addCookie(cookie);
          System.out.println("name:" + name+ " , password: " + password);
          return new ResponseEntity<>(userService.loginByNameAndPassword(name, password), HttpStatus.OK);
     }
}
