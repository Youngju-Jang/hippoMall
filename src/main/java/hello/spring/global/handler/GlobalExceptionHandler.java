package hello.spring.global.handler;

import hello.spring.global.RestApiException;
import hello.spring.global.dto.ErrorResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
     @ExceptionHandler
     public ResponseEntity<Object> RestApiExHandle(RestApiException e){
          log.error("[exceptionHandle] ex {}", e.getErrorResult());
          return new ResponseEntity<>(new ErrorResponseDto(e.getErrorResult()), e.getErrorResult().getCode());
     }
}
