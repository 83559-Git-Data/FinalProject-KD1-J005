import React, { useState } from "react";
import dummyData from "../../Dummy/scheduleFaculty.json";
import Navbar from "../../components/Navbar";
import "../Common.css";
import "../Headers/Home";
import Sidebar from "../../components/Slidebar/Sidebar";

function ScheduleFaculty() {
  const [selectedCourse, setSelectedCourse] = useState("");
  const [selectedModule, setSelectedModule] = useState("");
  const [selectedFaculty, setSelectedFaculty] = useState("");
  const [startDate, setStartDate] = useState("");
  const [endDate, setEndDate] = useState("");
  const [isSidebarOpen, setIsSidebarOpen] = useState(true);

  const toggleSidebar = () => {
    setIsSidebarOpen(!isSidebarOpen);
  };
  const onSave = () => {
    if (selectedCourse.length == 0) {
      alert("Please select Course Name");
    } else if (selectedModule.length == 0) {
      alert("Please select  Module Name");
    } else if (selectedFaculty.length == 0) {
      alert("Please select Faculty Name");
    } else if (startDate.length == 0) {
      alert("Please enter valid start date");
    } else if (endDate.length == 0) {
      alert("Please enter valid End date");
    }
  };

  const handleCourseChange = (event) => {
    setSelectedCourse(event.target.value);
    setSelectedModule("");
    setSelectedFaculty("");
  };

  const handleModuleChange = (event) => {
    setSelectedModule(event.target.value);
    setSelectedFaculty("");
  };

  const handleFacultyChange = (event) => {
    setSelectedFaculty(event.target.value);
  };

  const getModules = () => {
    if (!selectedCourse) return [];
    const course = dummyData.find((course) => course.Course === selectedCourse);
    return course ? course.modules : [];
  };

  const getFaculties = () => {
    if (!selectedCourse) return [];
    const course = dummyData.find((course) => course.Course === selectedCourse);
    return course ? course.faculties : [];
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

      <div className="row">
        <div className="col"></div>
        <div className="col">
          <div className="login-box shadow p-4">
            <h2 className="page-header aligns-items-center">
              Faculty Scheduler
            </h2>
            <div className="form">
              <div className="mb-3"></div>
              <label>Course: </label>
              <select
                value={selectedCourse}
                onChange={handleCourseChange}
                className="form-control">
                <option value="">Select Course</option>
                {dummyData.map((course, index) => (
                  <option key={index} value={course.Course}>
                    {course.Course}
                  </option>
                ))}
              </select>
            </div>

            <div className="mb-3">
              <label>Module: </label>
              <select
                value={selectedModule}
                onChange={handleModuleChange}
                disabled={!selectedCourse}
                className="form-control">
                <option value="">Select Module</option>
                {getModules().map((module, index) => (
                  <option key={index} value={module}>
                    {module}
                  </option>
                ))}
              </select>
            </div>

            <div className="mb-3">
              <label>Faculty: </label>
              <select
                value={selectedFaculty}
                onChange={handleFacultyChange}
                disabled={!selectedCourse}
                className="form-control">
                <option value="">Select Faculty</option>
                {getFaculties().map((faculty, index) => (
                  <option key={index} value={faculty}>
                    {faculty}
                  </option>
                ))}
              </select>
            </div>
            <div className="row">
              <div className="col">
                <input
                  onChange={(e) => setStartDate(e.target.value)}
                  type="date"
                  className="form-control m-2"
                  placeholder="Start Date"
                />
              </div>
              <div className="col">
                <input
                  onChange={(e) => setEndDate(e.target.value)}
                  type="date"
                  className="form-control m-2"
                  placeholder="End Date"
                />
              </div>
            </div>
            <button onClick={onSave} className="btn btn-success mt-2">
              Schedule
            </button>
          </div>
        </div>
        <div className="col"></div>
      </div>
    </div>
  );
}

export default ScheduleFaculty;
