import { Link } from "react-router-dom";
import "./Navbar.css"; // Import the custom CSS file
import logo from "../assets/images/schedulemaster.webp";

function Navbar({ toggleSidebar }) {
  return (
    <nav className="navbar navbar-expand-lg navbar-light bg-white shadow-sm">
      <div className="container-fluid">
        <a className="navbar-brand" href="#" onClick={toggleSidebar}>
          <img src={logo} alt="Logo" className="navbar-logo" />
          Schedule Master
        </a>

        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
          onClick={toggleSidebar}>
          ☰
        </button>
        <div className="collapse navbar-collapse" id="navbarSupportedContent">
          <ul className="navbar-nav me-auto mb-2 mb-lg-0">
            <li className="nav-item">
              <Link to="/home" className="nav-link">
                Home
              </Link>
            </li>
            <li className="nav-item">
              <Link to="/student" className="nav-link">
                Student
              </Link>
            </li>

            <li className="nav-item">
              <Link to="/aboutus" className="nav-link">
                About Us
              </Link>
            </li>
            <li className="nav-item">
              <Link to="/login" className="nav-link">
                Logout
              </Link>
            </li>
          </ul>
          <div className="d-flex align-items-center">
            <img
              src="/path-to-your-profile-pic.png"
              alt="Profile"
              className="profile-pic"
            />
            <button className="btn btn-outline-secondary ms-2">Profile</button>
          </div>
        </div>
      </div>
    </nav>
  );
}

export default Navbar;
