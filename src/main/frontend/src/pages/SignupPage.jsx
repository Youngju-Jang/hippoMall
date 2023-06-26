import React from "react";
import axios from "axios";
import { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import useTitle from "../util/useTitle.js";
import LoginButton from "../components/LoginButton";

const SIGNUP = "/user/signup";

const LoginbaseURL = axios.create({
  baseURL: "http://localhost:8080/",
  headers: {
    "Access-Control-Allow-Origin": "*",
  },
});

const SignupForm = () => {
  useTitle("SIGNUP");

  const navigate = useNavigate();
  const [state, setState] = useState({
    name: "",
    password: "",
  });
  const { name, password } = state;
  const [passwordCheck, setPasswordCheck] = useState("");

  const onChangeInput = (e) => {
    const { name, value } = e.target;
    setState({ ...state, [name]: value });
  };

  const onChangePassCheck = (e) => {
    setPasswordCheck(e.target.value);
  };

  const postSignup = (userInfo) => {
    LoginbaseURL.post(SIGNUP, userInfo)
      .then((response) => console.log(response))
      .then((response) => {
        navigate("/");
      })
      .catch((err) => {
        console.log(err);
        if (err?.response?.status === 400) {
          alert("이미 존재하는 아이디입니다.");
        }
      });
    return;
  };

  const handleClickSignup = () => {
    if (!(name && password && passwordCheck)) {
      alert("빈칸을 채워주세요");
      return;
    }
    if (password !== passwordCheck) {
      alert("비밀번호가 다릅니다");
      return;
    }
    postSignup({ name, password });
  };

  const backToLogin = () => {
    navigate("/");
  };
  return (
    <div id="loginWrapper">
      <div className="loginForm">
        <fieldset>
          <legend>관리자 시스템 로그인</legend>
          <dl>
            <dt>
              <img src={process.env.PUBLIC_URL + `/img/common/th_id.gif`} alt="아이디" />
            </dt>
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
            <dt>
              <img src={process.env.PUBLIC_URL + `/img/common/th_pw.gif`} alt="비밀번호" />
            </dt>
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
            <div className="btn">
              <button type="button" onClick={backToLogin}>
                로그인
              </button>
            </div>
          </div>
        </fieldset>
      </div>
    </div>
  );
};

export default SignupForm;
