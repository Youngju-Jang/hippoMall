package hello.spring.controller;

import hello.spring.entity.User;
import hello.spring.global.security.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloWorldController {
     
     @GetMapping("/api/hello")
     public String test() {
          User user = SecurityUtil.getCurrentUser();
          log.info("user : {}", user);
          return "Hello, world!";
     }
}