package hello.spring.global.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessResult implements Result{
     OK("OK", HttpStatus.OK);
     
     private final String message;
     private final HttpStatus code;
}
