package hello.spring.dto;

import hello.spring.global.dto.Result;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
@Getter
@ToString
@Builder
@RequiredArgsConstructor
public class ResponseDto {
     private final Boolean success;
     private final Integer statusCode;
     private final String statusMsg;
     
     public static ResponseDto of(Boolean success, Result code) {
          return new ResponseDto(success, code.getCode().value(), code.getMessage());
     }
}
