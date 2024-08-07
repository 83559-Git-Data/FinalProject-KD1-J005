import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import Navbar from "../../components/Navbar";
import "../Common.css";
import "../Headers/Home";
import Sidebar from "../../components/Slidebar/Sidebar";
import facultyData from "../../Dummy/facultyDetails.json";

function Faculty() {
  const [faculties, setFaculties] = useState(facultyData);
  const [isSidebarOpen, setIsSidebarOpen] = useState(true);

  const toggleSidebar = () => {
    setIsSidebarOpen(!isSidebarOpen);
  };
  const navigate = useNavigate();

  const onDelete = (index) => {
    // Delete a faculty
    faculties.splice(index, 1);
    setFaculties([...faculties]);
  };

  const onDetails = (index) => {
    navigate("/faculty-details");
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
        <div className="col-2"></div>
        <div className="col-10">
          <div className="login-box shadow p-4 mt-4">
            <h2 className="page-header">Faculty</h2>
            <Link to="/addFaculty" className="btn btn-primary">
              Add Faculty
            </Link>
            {faculties.length === 0 && (
              <h3 className="mt-5" style={{ textAlign: "center" }}>
                There are no faculties at the moment. Please use the Add Faculty
                button to add one.
              </h3>
            )}

            {faculties.length > 0 && (
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
                    {faculties.map((faculty, index) => (
                      <tr key={index}>
                        <td>{index + 1}</td>
                        <td>{faculty.firstName}</td>
                        <td>{faculty.lastName}</td>
                        <td>{faculty.course}</td>
                        <td>{faculty.module}</td>
                        <td>{`${faculty.schedule.startDate} to ${faculty.schedule.endDate}`}</td>
                        <td>{faculty.mobileNumber}</td>
                        <td>
                          <button
                            onClick={() => onDelete(index)}
                            className="btn btn-danger bt-sm me-2">
                            Delete
                          </button>
                          <button
                            onClick={() => onDetails(index)}
                            className="btn btn-primary bt-sm">
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

export default Faculty;
