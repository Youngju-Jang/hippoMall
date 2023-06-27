import React from "react";
import { useNavigate, Link } from "react-router-dom";

const Button = ({ children, href, onClick }) => {
  const navigate = useNavigate();

  return (
    <span className="button">
      {onClick !== null && typeof onClick === "function" && (
        <Link to={href} onClick={onClick}>
          {children}
        </Link>
      )}
      {typeof onClick !== "function" && <Link to={href}>{children}</Link>}
    </span>
  );
};

Button.defaultProps = {
  onClick: null,
  href: "",
};
export default Button;
