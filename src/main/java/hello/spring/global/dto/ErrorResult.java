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
     DUPLICATED_NAME("중복된 이름 입니다.", HttpStatus.BAD_REQUEST);
     
     private final String message;
     private final HttpStatus code;
}
