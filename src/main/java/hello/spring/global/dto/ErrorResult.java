package hello.spring.global.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorResult implements Result {
     INTERNAL_SERVER_ERROR("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR),
     WRONG_PASSWORD("비밀번호를 다시 입력해주세요", HttpStatus.BAD_REQUEST),
     NO_USER("존재하지 않는 유저입니다.", HttpStatus.BAD_REQUEST),
     DUPLICATED_NAME("중복된 이름 입니다.", HttpStatus.BAD_REQUEST),
     INVALID_TOKEN("토큰이 유효하지 않습니다.", HttpStatus.UNAUTHORIZED),
     NOT_FOUND_AUTHORIZATION_IN_SECURITY_CONTEXT("Security Context에 인증 정보가 없습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
     
     private final String message;
     private final HttpStatus code;
}
