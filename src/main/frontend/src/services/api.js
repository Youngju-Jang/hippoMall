import axios from "axios";
import { loadItem, saveItem } from "./storage";
import { Link, useNavigate } from "react-router-dom";

const LOGIN = "/user/login";

const baseURL = axios.create({
  baseURL: "http://localhost:8080",
  headers: {
    "Access-Control-Allow-Origin": "*",
    Authorization: `${loadItem("isLogin")}`,
  },
});

const LoginbaseURL = axios.create({
  baseURL: "http://localhost:8080",
  headers: {
    "Access-Control-Allow-Origin": "*",
  },
});

export const postLogin = (userInfo, checker, navigate) => {
  LoginbaseURL.post(LOGIN, userInfo)
    .then((response) => {
      // 쿠키 이름을 "name"으로 설정하고, 1시간 동안 유지되도록 설정
      document.cookie = `name=${response.data.name}; max-age=3600`;
      document.cookie = `userId=${response.data.userId}; max-age=3600`;

      localStorage.setItem("isLogin", response?.headers?.authorization);

      // 아이디저장여부 확인하여 저장
      if (checker) {
        localStorage.setItem("name", response.data.name);
        localStorage.setItem("checker", checker);
      } else {
        localStorage.removeItem("name");
        localStorage.removeItem("checker");
      }
      navigate("/main");
    })
    .catch((err) => {
      console.log(err);
      if (err?.response?.status === 400) {
        alert(`${err?.response?.data?.statusMsg}`);
      }
      navigate("/");
    });
};

export const getMain = () => {
  baseURL.get("/api/hello").then((res) => {
    console.log(res);
  });
};
