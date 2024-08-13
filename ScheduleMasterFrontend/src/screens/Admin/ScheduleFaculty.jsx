import React, { useState, useEffect } from "react";
import Navbar from "../../components/Navbar";
import { toast } from "react-toastify";
import Sidebar from "../../components/Slidebar/Sidebar";
import {
  getCourses,
  getModulesByCourse,
  getFaculty,
  scheduleFaculty,
} from "../../services/admin";
import "../Common.css";

function ScheduleFaculty() {
  debugger;
  const [courses, setCourses] = useState([]);
  const [modules, setModules] = useState([]);
  const [faculties, setFaculties] = useState([]);

  const [selectedCourse, setSelectedCourse] = useState("");
  const [selectedModule, setSelectedModule] = useState("");
  const [selectedFaculty, setSelectedFaculty] = useState("");
  const [startDate, setStartDate] = useState("");
  const [endDate, setEndDate] = useState("");
  const [startTime, setStartTime] = useState("");
  const [endTime, setEndTime] = useState("");
  const [isSidebarOpen, setIsSidebarOpen] = useState(true);

  const handleCourseChange = (event) => {
    const courseId = event.target.value;
    console.log("Anupam vaishy jhasfudyeaof" + courseId);
    setSelectedCourse(courseId);
    setSelectedModule("");
    setSelectedFaculty("");
    fetchModules(courseId);
  };

  const handleModuleChange = (event) => {
    const moduleId = event.target.value;
    console.log("Anupam vaishy 33333333333333333" + moduleId);
    setSelectedModule(moduleId);
    setSelectedFaculty("");
    fetchFaculties(moduleId);
  };

  const handleFacultyChange = (event) => {
    setSelectedFaculty(event.target.value);
  };

  useEffect(() => {
    fetchCourses();
  }, []);

  const fetchCourses = async () => {
    debugger;
    try {
      const response = await getCourses();
      console.log("Fetched courses:", response.data); // Log response data for debugging
      setCourses(response.data);
    } catch (error) {
      console.error("Error fetching courses:", error);
    }
  };

  const fetchModules = async (courseId) => {
    debugger;
    try {
      const response = await getModulesByCourse(courseId);
      console.log("Fetched modules:", response.data); // Log response data for debugging
      setModules(response.data);
    } catch (error) {
      console.error("Error fetching modules:", error);
      setModules([]); // Fallback to an empty array to prevent `undefined` issues
    }
  };

  const fetchFaculties = async () => {
    debugger;
    try {
      const response = await getFaculty();
      console.log("Fetched Faculties:", response.data); // Log response data for debugging
      setFaculties(response.data);
    } catch (error) {
      console.error("Error fetching faculties:", error);
      setFaculties([]); // Fallback to an empty array to prevent `undefined` issues
    }
  };

  const toggleSidebar = () => {
    setIsSidebarOpen(!isSidebarOpen);
  };

  const onSave = async () => {
    if (!selectedCourse) {
      toast.error("Please select Course Name");
    } else if (!selectedModule) {
      toast.error("Please select Module Name");
    } else if (!selectedFaculty) {
      toast.error("Please select Faculty Name");
    } else if (!startDate) {
      toast.error("Please enter valid Start Date");
    } else if (!endDate) {
      toast.error("Please enter valid End Date");
    } else if (!startTime) {
      toast.error("Please enter valid Start Time");
    } else if (!endTime) {
      toast.error("Please enter valid End Time");
    } else {
      debugger;
      console.log("selectedCourse" + selectedCourse);
      console.log("selectedModule" + selectedModule);
      console.log("selectedFaculty" + selectedFaculty);
      const result = await scheduleFaculty(
        selectedCourse,
        selectedModule,
        selectedFaculty,
        startDate,
        endDate,
        startTime,
        endTime
      );
      console.log("Results is this " + result);
      if (result["status"] === 201) {
        toast.success("Faculty scheduled successfully");
      } else {
        toast.error("Failed to schedule faculty");
      }
    }
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
                {courses.map((course) => (
                  <option key={course.id} value={course.id}>
                    {course.courseName}
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
                {modules.map((module) => (
                  <option key={module.id} value={module.id}>
                    {module.name}
                  </option>
                ))}
              </select>
            </div>

            <div className="mb-3">
              <label>Faculty: </label>
              <select
                value={selectedFaculty}
                onChange={handleFacultyChange}
                disabled={!selectedModule}
                className="form-control">
                <option value="">Select Faculty</option>
                {faculties.map((faculty) => (
                  <option key={faculty.id} value={faculty.id}>
                    {faculty.userId.firstName} {faculty.userId.lastName}
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

            <div className="row">
              <div className="col">
                <input
                  onChange={(e) => setStartTime(e.target.value)}
                  type="time"
                  className="form-control m-2"
                  placeholder="Start Time"
                />
              </div>
              <div className="col">
                <input
                  onChange={(e) => setEndTime(e.target.value)}
                  type="time"
                  className="form-control m-2"
                  placeholder="End Time"
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
