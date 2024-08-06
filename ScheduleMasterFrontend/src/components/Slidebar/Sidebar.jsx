import React from "react";
import {
  BiBookAlt,
  BiSolidReport,
  BiStats,
  BiHelpCircle,
  BiBookContent,
  BiPen,
  BiTable,
} from "react-icons/bi";
import { Link } from "react-router-dom";
import "../Slidebar/Sidebar.css";

const Sidebar = () => {
  return (
    <div className="dashboard-box  " style={{ width: "10%", marginTop: "3rm" }}>
      <div className="menu">
        <div className="menu--list">
          {" "}
          {/* Fixed the typo here */}
          <Link to="/addFaculty" className="nav-link item">
            <BiPen className="icon" />
            Add New Faculty
          </Link>
          <Link to="/addCourse" className="nav-link item">
            <BiBookContent className="icon" />
            Add New Course
          </Link>
          <Link to="/student-details" className="nav-link item">
            <BiSolidReport className="icon" />
            View Student Details
          </Link>
          <Link to="/faculty-details" className="nav-link item">
            <BiStats className="icon" />
            View Faculty Details
          </Link>
          <Link to="/schedulefaculty" className="nav-link item">
            <BiTable className="icon" />
            Confirm Schedule
          </Link>
        </div>
      </div>
    </div>
  );
};

export default Sidebar;
