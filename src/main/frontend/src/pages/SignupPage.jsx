import React from "react";
import axios from 'axios';
import { useState } from 'react';
import { useNavigate } from "react-router-dom";

const SIGNUP = '/user/signup';

const LoginbaseURL = axios.create({
  baseURL: 'http://localhost:8080/',
  headers: {
    'Access-Control-Allow-Origin': '*',
  },
});

const SignupForm = () => {
    const navigate = useNavigate();
    const [state, setState] = useState({
        name: '',
        password: '',
      });
    const { name, password } = state;
    const [passwordCheck, setPasswordCheck] = useState('');

    const onChangeInput = (e) => {
        const { name, value } = e.target;
        setState({ ...state, [name]: value });
    };

    const onChangePassCheck = (e) => {
      setPasswordCheck(e.target.value);
    }

    const postSignup = async (userInfo) => {
      try {
        await LoginbaseURL.post(SIGNUP, userInfo);
        navigate('/');
      } catch (err) {
        if(err.response.status === 400){
          alert("이미 존재하는 아이디입니다.");
        };
        return;
      }
    };
  
    const handleClickSignup = () => {
        if(!(name && password && passwordCheck)){
          alert("name : " + name + " | " + password + " | " + passwordCheck);
          alert("빈칸을 채워주세요");
          return;
        }
        if (password !== passwordCheck) {
          alert("비밀번호가 다릅니다");
          return;
        }
        postSignup({name, password});
      };
    return (
      <div id="loginWrapper">
            <div className="loginForm">
                  <fieldset>
                        <legend>관리자 시스템 로그인</legend>
                        <dl>
                            {/* <dt><img src="/resources/img/common/th_id.gif" alt="아이디"/></dt> */}
                            <dd>
                              <input 
                              type="text" 
                              name="name" 
                              className="text" 
                              id="name" 
                              onChange={onChangeInput}
                              value={name}
                              />
                            </dd>
                            {/* <dt><img src="/resources/img/common/th_pw.gif" alt="비밀번호"/></dt> */}
                            <dd>
                              <input 
                              type="password" 
                              name="password" 
                              className="text" 
                              id="password" 
                              onChange={onChangeInput}
                              value={password}
                              />
                            </dd>
                            <dd>
                              <input 
                              type="password" 
                              name="passwordCheck" 
                              className="text" 
                              id="passwordCheck" 
                              placeholder="비밀번호 확인"
                              value={passwordCheck}
                              onChange={onChangePassCheck}
                              />
                            </dd>
                        </dl>
                        <div className="btn">
                            <button onClick={handleClickSignup}>가입하기</button>
                            <button type="button"><a href="/">로그인</a></button>
                        </div>
                  </fieldset>
            </div>
      </div>
    );
};

export default SignupForm;