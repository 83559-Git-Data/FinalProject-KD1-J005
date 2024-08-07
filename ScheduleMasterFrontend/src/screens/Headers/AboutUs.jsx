import React from "react";
import Navbar from "../../components/Navbar";
import "../Common.css";

function AboutUs() {
  return (
    <div className="home-container">
      <Navbar />

      <div className="login-box shadow p-4">
        <div className="col dotted rounded course-header ">
          <h2 className="page-header">About Us</h2>
          <p>
            Welcome to our Schedule Management System! We are dedicated to
            helping you efficiently organize and manage your time. Our platform
            offers a range of features designed to make scheduling and planning
            easier and more effective.
          </p>
          <p>
            Our team is composed of experienced professionals who are passionate
            about creating intuitive and user-friendly tools. We strive to
            continuously improve our system based on user feedback and the
            latest technological advancements.
          </p>
          <p>
            Thank you for choosing us. We are committed to providing you with
            the best scheduling experience possible. If you have any questions
            or need assistance, please feel free to contact us.
          </p>
        </div>
      </div>
    </div>
  );
}

export default AboutUs;
