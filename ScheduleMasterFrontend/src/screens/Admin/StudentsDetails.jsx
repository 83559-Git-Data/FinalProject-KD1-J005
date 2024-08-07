import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import Navbar from "../../components/Navbar";
import "../Common.css";
import "../../screens/Headers/Home.css";
import Sidebar from "../../components/Slidebar/Sidebar";
import studentData from "../../Dummy/studentDetails.json";

function Student() {
  const [students, setStudents] = useState(studentData);
  const [isSidebarOpen, setIsSidebarOpen] = useState(true);

  const toggleSidebar = () => {
    setIsSidebarOpen(!isSidebarOpen);
  };

  const navigate = useNavigate();

  const onDelete = (index) => {
    // Delete a student
    students.splice(index, 1);
    setStudents([...students]);
  };

  const onDetails = (index) => {
    navigate("/student-details");
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

      <div className="row ">
        <div className="col-2"></div>
        <div className="col-10">
          <div className="login-box shadow p-4 mt-4 ">
            <h2 className="page-header">Students</h2>

            {students.length === 0 && (
              <h3 className="mt-5" style={{ textAlign: "center" }}>
                There are no students at the moment. Please use the Add Student
                button to add one.
              </h3>
            )}

            {students.length > 0 && (
              <div className="table-container">
                <table className="table table-striped mt-5">
                  <thead>
                    <tr>
                      <th>S.No</th>
                      <th>First Name</th>
                      <th>Last Name</th>
                      <th>Course</th>
                      <th>Module</th>
                      <th>Schedule</th>
                      <th>Mobile Number</th>
                      <th>Actions</th>
                    </tr>
                  </thead>
                  <tbody>
                    {students.map((student, index) => (
                      <tr key={index}>
                        <td>{index + 1}</td>
                        <td>{student.firstName}</td>
                        <td>{student.lastName}</td>
                        <td>{student.course}</td>
                        <td>{student.module}</td>
                        <td>{`${student.enrollment.moduleStartDate} to ${student.enrollment.moduleEndDate}`}</td>
                        <td>{student.mobileNumber}</td>
                        <td>
                          <button
                            onClick={() => onDelete(index)}
                            className="btn btn-danger btn-sm me-2">
                            Delete
                          </button>
                          <button
                            onClick={() => onDetails(index)}
                            className="btn btn-primary btn-sm">
                            Details
                          </button>
                        </td>
                      </tr>
                    ))}
                  </tbody>
                </table>
              </div>
            )}
          </div>
        </div>
      </div>
    </div>
  );
}

export default Student;
