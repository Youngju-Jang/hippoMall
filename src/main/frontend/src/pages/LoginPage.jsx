import React from "react";
import axios from 'axios';
import { useState } from 'react';
import { useNavigate } from "react-router-dom";

import LoginButton from '../components/LoginButton';

const LOGIN = '/user/login';

const LoginbaseURL = axios.create({
  baseURL: 'http://localhost:8080/',
  headers: {
    'Access-Control-Allow-Origin': '*',
  },
});

const LoginForm = () => {
    const navigate = useNavigate();
    const [state, setState] = useState({
        name: '',
        password: '',
      });
    const { name, password } = state;
    const onChangeInput = (e) => {
        const { name, value } = e.target;
        setState({ ...state, [name]: value });
    };

    // const mutateLogin = useMutation({
    //     mutationFn: PostLogin,
    //   });
    const postLogin = async (userInfo) => {
      try {
        await LoginbaseURL.post(LOGIN, userInfo);
        console.log('name: ' + userInfo.name + ', password: ' + userInfo.password);
        // saveItem('month', '');
        navigate('/main');
      } catch (err) {
        navigate('/');
      }
    };
  

    const handleClickLogin = ({ name, password }) => {
        name && password
          // ? mutateLogin.mutate({ name, password })
          ? postLogin({name, password})
          : alert('이메일과 비밀번호를 확인해주세요.');
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
                        </dl>
                        <div className="btn">
                            <LoginButton loginInputField={state} onClickLogin={handleClickLogin} />
                              {/* <img id="btnSubmit" src="/resources/img/button/btn_login.gif" alt="LOGIN" title="LOGIN"/> */}
                        </div>

                        <div className="saveId"><input type="checkbox" id="checker" name="checker"/>
                              {/* <img src="/resources/img/common/save_id.gif" alt="아이디 저장"/> */}
                              <button type="button"><a href="/signup">회원가입</a></button>
                        </div>
                  </fieldset>
            </div>
      </div>
    );
};

export default LoginForm;