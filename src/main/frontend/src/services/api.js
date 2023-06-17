import axios from 'axios';
import { useNavigate } from "react-router-dom";

const LOGIN = '/user/login';


const LoginbaseURL = axios.create({
    baseURL: 'http://localhost:8080',
    headers: {
      'Access-Control-Allow-Origin': '*',
    },
  });

// export const postLogin = async (userInfo) => {
//   const navigate = useNavigate();

//   try {
//     await LoginbaseURL.post(LOGIN, userInfo);
//     console.log('name: ' + userInfo.name + ', password: ' + userInfo.password);
//     // saveItem('month', '');
//     navigate('/main');
//   } catch (err) {
//     navigate('/');
//   }
// };

// export const PostLogin = async (userInfo, checker) => {
//   const navigate = useNavigate();

//   try {
//     const response = await LoginbaseURL.post(LOGIN, userInfo);
//     // 쿠키 이름을 "name"으로 설정하고, 1시간 동안 유지되도록 설정
//     document.cookie = `name=${response.data.name}; max-age=3600`; 
//     document.cookie = `userId=${response.data.userId}; max-age=3600`; 

//     // 아이디저장여부 확인하여 저장
//     if(checker){
//       localStorage.setItem('name', response.data.name);
//       localStorage.setItem('checker', checker);
//     } else {
//       localStorage.removeItem('name');
//       localStorage.removeItem('checker');
//     }
//     navigate('/main');
//     // location.assign('/main');
//   } catch (err) {
//     navigate('/');
//     // location.assign('/');
//   }
// };