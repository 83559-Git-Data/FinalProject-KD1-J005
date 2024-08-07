import { useState } from "react";
import "./Common.css";
import "../screens/Home.css";
import Navbar from "../components/Navbar";
import Sidebar from "../components/Slidebar/Sidebar";
function AddCourse() {
  const [name, setName] = useState("");
  const [facultyName, setFacultyName] = useState("");
  const [description, setDescription] = useState("");
  const [course_id, setCourseId] = useState("");
  const [fee, setFee] = useState("");
  const [faculty_id, setFacultyId] = useState("");
  const [startDate, setStartDate] = useState("");
  const [endDate, setEndDate] = useState("");
  const [isSidebarOpen, setIsSidebarOpen] = useState(true);

  const toggleSidebar = () => {
    setIsSidebarOpen(!isSidebarOpen);
  };

  const onSave = () => {
    if (name.length == 0) {
      alert("Please enter valid Course Name");
    } else if (facultyName.length == 0) {
      console.log(name);
      alert("Please enter valid Faculty Name");
    } else if (description.length == 0) {
      alert("Please enter valid Description");
    } else if (course_id.length == 0) {
      alert("Please enter valid Course Id");
    } else if (fee.length == 0) {
      alert("Please enter valid Faculty Name");
    } else if (faculty_id.length == 0) {
      alert("Please enter valid Faculty Id");
    } else if (startDate.length == 0) {
      alert("Please enter valid start date");
    } else if (endDate.length == 0) {
      alert("Please enter valid End date");
    }
  };

  return (
    <div className="home-container  ">
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

      <div className="row">
        <div className="col-3"></div>
        <div className="col dotted rounded course-header aligns-items-center login-box shadow p-4">
          <h2 className="page-header aligns-items-center">Add Course</h2>
          <div className="row">
            <div className="col">
              <input
                onChange={(e) => setName(e.target.value)}
                type="text"
                className="form-control m-2"
                placeholder="Course Name"
              />
              <input
                onChange={(e) => setFacultyName(e.target.value)}
                type="text"
                className="form-control m-2"
                placeholder="Faculty Name"
              />
              <textarea
                onChange={(e) => setDescription(e.target.value)}
                type="text"
                className="form-control m-2"
                placeholder="Description"
              />
            </div>
            <div className="col">
              <input
                onChange={(e) => setCourseId(e.target.value)}
                type="text"
                className="form-control m-2"
                placeholder="Course Id"
              />
              <input
                onChange={(e) => setFee(e.target.value)}
                type="text"
                className="form-control m-2"
                placeholder="Fees"
              />
              <input
                onChange={(e) => setFacultyId(e.target.value)}
                type="text"
                className="form-control m-2"
                placeholder="Faculty Id"
              />
            </div>
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
              <button
                onClick={onSave}
                className="btn btn-success "
                style={{ marginRight: "1rem" }}>
                Save
              </button>
              <button
                className="btn btn-danger"
                style={{ marginRight: "1rem" }}>
                Cancel
              </button>
              <button
                className="btn btn-primary "
                style={{ marginRight: "1rem" }}>
                Edit
              </button>
            </div>
          </div>
        </div>
        <div className="col-3"></div>
      </div>
    </div>
  );
}

export default AddCourse;
