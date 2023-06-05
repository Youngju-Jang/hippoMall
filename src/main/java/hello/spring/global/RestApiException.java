package hello.spring.global;

import hello.spring.global.dto.ErrorResult;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RestApiException extends RuntimeException{
     private final ErrorResult errorResult;
     
     public RestApiException(ErrorResult errorResult){
          super(errorResult.getMessage());
          this.errorResult = errorResult;
     }
     
     public String getErrorMessage() {
          return errorResult.getMessage();
     }
     
     public HttpStatus getErrorCode() {
          return errorResult.getCode();
     }
}
