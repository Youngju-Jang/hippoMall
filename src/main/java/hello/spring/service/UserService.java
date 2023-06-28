package hello.spring.service;

import hello.spring.dto.SignupRequestDto;
import hello.spring.entity.UserRoleEnum;
import hello.spring.global.RestApiException;
import hello.spring.data.UserRepository;
import hello.spring.dto.AuthInfo;
import hello.spring.global.dto.ErrorResult;
import hello.spring.entity.User;
import hello.spring.global.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
     private final UserRepository userMapper;
     private final PasswordEncoder passwordEncoder;
     private final JwtUtil jwtUtil;
     
     public AuthInfo loginByNameAndPassword(String name, String password,HttpServletResponse response) {
          
          // 존재하지 않는 유저일경우
          if (!isExist(name)) {
               throw new RestApiException(ErrorResult.NO_USER);
          }
          User existUser = selectByName(name);
          // 비밀번호가 안맞을때
          if (!passwordEncoder.matches(password,existUser.getPassword())){
               throw new RestApiException(ErrorResult.WRONG_PASSWORD);
          }
          response.addHeader(JwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(existUser.getName()));
          
//           리액트랑 연동시 서버 세션에 저장이 가능한가 ??
//          request.getSession().setAttribute(SessionConst.LOGIN_USER, existUser);
          return new AuthInfo(existUser.getUserId(), existUser.getName());
     }
     @Transactional // 회원가입
     public Long signup(SignupRequestDto signupRequestDto) {
          if(isExist(signupRequestDto.getName())){ // 중복된 유저명인가
               throw new RestApiException(ErrorResult.DUPLICATED_NAME);
          }
          String name = signupRequestDto.getName();
          String password = passwordEncoder.encode(signupRequestDto.getPassword());
          UserRoleEnum role = signupRequestDto.getRole();

          userMapper.signupByUser(new User(name, password,role)); // 회원가입
          
          // 회원가입한 유저 id return
          return (long)userMapper.findByUsername(name).get().getUserId();
     }
     public boolean isExist(String name) {
          return userMapper.isExist(name);
     }
     
     public User selectByName(String name) {
          return userMapper.findByUsername(name).orElse(null);
     }
     
}
