import React from "react";
import axios from "axios";
import { useState, useEffect } from "react";
import { useNavigate, Link } from "react-router-dom";
import useTitle from "../util/useTitle.js";

// import { PostLogin } from '../services/api';

import LoginButton from "../components/LoginButton";

const LOGIN = "/user/login";

const LoginbaseURL = axios.create({
  baseURL: "http://localhost:8080/",
  headers: {
    "Access-Control-Allow-Origin": "*",
  },
});

const LoginForm = () => {
  useTitle("Login");

  const navigate = useNavigate();
  const [checker, setChecker] = useState(false);
  const [state, setState] = useState({
    name: "",
    password: "",
  });
  const { name, password } = state;
  const onChangeInput = (e) => {
    const { name, value } = e.target;
    setState({ ...state, [name]: value });
  };

  useEffect(() => {
    const storedName = localStorage.getItem("name");
    const storedChecker = localStorage.getItem("checker");

    if (storedChecker === "true") {
      setState({ ...state, name: storedName || "" });
      setChecker(true);
    }
  }, []);

  const postLogin = async (userInfo) => {
    try {
      const response = await LoginbaseURL.post(LOGIN, userInfo);
      // 쿠키 이름을 "name"으로 설정하고, 1시간 동안 유지되도록 설정
      document.cookie = `name=${response.data.name}; max-age=3600`;
      document.cookie = `userId=${response.data.userId}; max-age=3600`;

      // 아이디저장여부 확인하여 저장
      if (checker) {
        localStorage.setItem("name", response.data.name);
        localStorage.setItem("checker", checker);
      } else {
        localStorage.removeItem("name");
        localStorage.removeItem("checker");
      }
      navigate("/main");
    } catch (err) {
      navigate("/");
    }
  };

  const handleClickLogin = ({ name, password }) => {
    name && password ? postLogin({ name, password }) : alert("이메일과 비밀번호를 확인해주세요.");
  };

  const onCheckerClick = (e) => {
    setChecker(e.target.checked);
  };
  return (
    <div id="loginWrapper">
      <div className="loginForm">
        <fieldset>
          <legend>관리자 시스템 로그인</legend>
          <dl>
            {/* <img src={process.env.PUBLIC_URL + `assets/emotion${emotion}.png`} /> */}
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
          </dl>
          <div className="btn">
            <LoginButton loginInputField={state} onClickLogin={handleClickLogin} />
          </div>

          <div className="saveId">
            <input
              type="checkbox"
              id="checker"
              name="checker"
              checked={checker}
              onClick={onCheckerClick}
            />
            <img src={process.env.PUBLIC_URL + `/img/common/save_id.gif`} alt="아이디 저장" />

            <button type="button">
              <Link to="/signup">회원가입</Link>
            </button>
          </div>
        </fieldset>
      </div>
    </div>
  );
};

export default LoginForm;
