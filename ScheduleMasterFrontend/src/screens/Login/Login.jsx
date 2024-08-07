import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import { login } from "../../services/admin";
import "../Common.css";

function Login() {
  const [username, setEmail] = useState("");
  const [password, setPassword] = useState("");

  // get navigation hook
  const navigate = useNavigate();
  const onLogin = async () => {
    debugger;
    if (username.length == 0) {
      toast.error("Please enter email");
    } else if (password.length == 0) {
      toast.error("Please enter password");
    } else {
      try {
        const result = await login(username, password);
        if (result["status"] == 201) {
          navigate("/home");
        } else {
          toast.error(result["error"]);
        }
      } catch (error) {
        toast.error("Something went wrong on Login");
      }
    }
  };

  return (
    <div className="login-container">
      <div className="row">
        <div className="col"></div>
        <div className="col ">
          <div className="login-box shadow p-4">
            <h2 style={{ alignContent: "center" }}>Login</h2>
            <div className="form">
              <div className="mb-3">
                <label htmlFor="">Email</label>
                <input
                  onChange={(e) => {
                    setEmail(e.target.value);
                  }}
                  type="email"
                  className="form-control"
                  placeholder="Enter your email"
                />
              </div>
              <div className="mb-3">
                <label htmlFor="">Password</label>
                <input
                  onChange={(e) => {
                    setPassword(e.target.value);
                  }}
                  type="password"
                  className="form-control"
                  placeholder="Enter your Password"
                />
              </div>
              <div className="mb-3">
                <div>
                  Don't have account ? <Link to="/register">Register here</Link>
                </div>
                <button onClick={onLogin} className="btn btn-success mt-2">
                  Login
                </button>
              </div>
            </div>
          </div>
        </div>
        <div className="col"></div>
      </div>
    </div>
  );
}

export default Login;
