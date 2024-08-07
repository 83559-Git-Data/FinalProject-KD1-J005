import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import { register } from "../../services/admin";
import "../Common.css";

function Register() {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [userName, setUserName] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [role, setRole] = useState("");

  const navigate = useNavigate(); // dynamic navigation

  const onRegister = async () => {
    if (firstName.length === 0) {
      toast.error("Please enter first name");
    } else if (lastName.length === 0) {
      toast.error("Please enter last name");
    } else if (userName.length === 0) {
      toast.error("Please enter userName");
    } else if (password.length === 0) {
      toast.error("Please enter password");
    } else if (confirmPassword.length === 0) {
      toast.error("Please enter confirmPassword");
    } else if (password !== confirmPassword) {
      toast.error("Password does not match");
    } else if (role.length === 0) {
      toast.error("Please select a role");
    } else {
      debugger;
      try {
        const result = await register(
          firstName,
          lastName,
          userName,
          password,
          role
        );

        if (result["status"] == 201) {
          toast.success("Registration Successfull");
          navigate("/login");
        } else {
          toast.error("Registration Unsuccessfull ");
        }
      } catch (error) {
        toast.error("Something went wrong on Registration");
      }
    }
  };

  return (
    <div className="registration-container">
      <div className="row">
        <div className="col"></div>
        <div className="col">
          <div className="login-box shadow p-4">
            <h2>Register</h2>
            <div className="form">
              <div className="mb-3">
                <label htmlFor="">First Name</label>
                <input
                  onChange={(e) => setFirstName(e.target.value)}
                  type="text"
                  className="form-control"
                  placeholder="Enter your first name"
                />
              </div>
              <div className="mb-3">
                <label htmlFor="">Last Name</label>
                <input
                  onChange={(e) => setLastName(e.target.value)}
                  type="text"
                  className="form-control"
                  placeholder="Enter your last name"
                />
              </div>
              <div className="mb-3">
                <label htmlFor="">Email</label>
                <input
                  onChange={(e) => setUserName(e.target.value)}
                  type="text"
                  className="form-control"
                  placeholder="Enter your email"
                />
              </div>
              <div className="mb-3">
                <label htmlFor="">Password</label>
                <input
                  onChange={(e) => setPassword(e.target.value)}
                  type="password"
                  className="form-control"
                  placeholder="Enter your password"
                />
              </div>
              <div className="mb-3">
                <label htmlFor="">Confirm Password</label>
                <input
                  onChange={(e) => setConfirmPassword(e.target.value)}
                  type="password"
                  className="form-control"
                  placeholder="Confirm your password"
                />
              </div>
              <div className="mb-3">
                <label htmlFor="role ">Role</label>
                <select
                  onChange={(e) => setRole(e.target.value)}
                  className="form-control"
                  id="role">
                  <option value="">Select Role</option>
                  <option value="STUDENT">Student</option>
                  <option value="FACULTY">Faculty</option>
                  <option value="ADMIN">Admin</option>
                </select>
              </div>
              <div className="mb-3">
                <div>
                  Already have an account? <Link to="/login">Login Here</Link>
                </div>
                <button onClick={onRegister} className="btn btn-success mt-2">
                  Register
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

export default Register;
