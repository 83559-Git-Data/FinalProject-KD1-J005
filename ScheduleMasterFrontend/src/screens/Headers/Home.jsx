import React, { useState } from "react";
import Navbar from "../../components/Navbar";
import "../Common.css";
import "../../screens/Headers/Home.css";
import Sidebar from "../../components/Slidebar/Sidebar";

function Home() {
  const [isSidebarOpen, setIsSidebarOpen] = useState(true);

  const toggleSidebar = () => {
    setIsSidebarOpen(!isSidebarOpen);
  };

  return (
    <div className="home-container">
      <Navbar toggleSidebar={toggleSidebar} />
      <div
        className={`sidebar ${
          isSidebarOpen ? "open dashboard-box" : "dashboard-box"
        }`}>
        <Sidebar />
      </div>
      <div
        className="dashboard"
        style={{ marginLeft: isSidebarOpen ? "250px" : "0" }}></div>
    </div>
  );
}

export default Home;
