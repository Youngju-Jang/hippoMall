import React from "react";

export default function LoginButton({ loginInputField, onClickLogin }) {
  const { name, password } = loginInputField;
  return (
    <dt>
      <img
        onClick={() => onClickLogin({ name, password })}
        id="btnSubmit"
        src={process.env.PUBLIC_URL + `/img/button/btn_login.gif`}
        alt="LOGIN"
        title="LOGIN"
      />
    </dt>
    // <button type="button" onClick={() => onClickLogin({ name, password })}>
    // 로그인
    // </button>
  );
}
