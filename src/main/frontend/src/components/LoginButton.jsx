import React from 'react';

export default function LoginButton({ loginInputField, onClickLogin }) {
  const { name, password } = loginInputField;
  return (
          <button type="button" onClick={() => onClickLogin({ name, password })}>
          로그인
          </button>
      );
}