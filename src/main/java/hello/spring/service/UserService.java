package hello.spring.service;

import hello.spring.global.RestApiException;
import hello.spring.data.UserMapper;
import hello.spring.dto.AuthInfo;
import hello.spring.global.dto.ErrorResult;
import hello.spring.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
     private final UserMapper userMapper;
     
     public AuthInfo loginByNameAndPassword(String name, String password){
          // 존재하지 않는 유저일경우
          if (!isExist(name)) {
               throw new RestApiException(ErrorResult.NO_USER);
          }
          User existUser = selectByName(name);
          
          // 비밀번호가 안맞을때
          if (!existUser.getPassword().equals(password)) {
               throw new RestApiException(ErrorResult.WRONG_PASSWORD);
          }
          
          // 리액트랑 연동시 서버 세션에 저장이 가능한가 ??
//          request.getSession().setAttribute(SessionConst.LOGIN_USER, existUser);
          return new AuthInfo(existUser.getUserId(), existUser.getName());
     }
     
     public boolean isExist(String name) {
          return userMapper.isExist(name);
     }
     
     public User selectByName(String name) {
          return userMapper.selectByName(name);
     }
}
