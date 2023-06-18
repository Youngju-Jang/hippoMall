package hello.spring.global.dto;

import hello.spring.dto.ResponseDto;

public class ErrorResponseDto extends ResponseDto {
     public ErrorResponseDto(ErrorResult errorResult) {
          super(false, errorResult.getCode().value(), errorResult.getMessage());
     }
     public static ErrorResponseDto of(ErrorResult errorCode) {
          return new ErrorResponseDto(errorCode);
     }
}
