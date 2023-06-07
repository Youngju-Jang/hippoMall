import axios from 'axios';
import { useNavigate } from "react-router-dom";

// import { loadItem, saveItem } from './storage';

const LOGIN = '/users/login';

const LoginbaseURL = axios.create({
    baseURL: 'http://localhost:8080',
    headers: {
      'Access-Control-Allow-Origin': '*',
    },
  });

  export const PostLogin = async (userInfo) => {
    const navigate = useNavigate();

    try {
      await LoginbaseURL.post(LOGIN, userInfo);
      console.log('name: ' + userInfo.name + ', password: ' + userInfo.password);
      // saveItem('month', '');
      navigate('/main');
    } catch (err) {
      navigate('/');
    }
  };