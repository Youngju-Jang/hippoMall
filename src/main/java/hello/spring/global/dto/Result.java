package hello.spring.global.dto;

import org.springframework.http.HttpStatus;

public interface Result {
     HttpStatus getCode();
     String getMessage();
}
