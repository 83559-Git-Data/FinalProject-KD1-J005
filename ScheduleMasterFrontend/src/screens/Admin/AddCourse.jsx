import { useState } from "react";
import "../Common.css";
import "../Headers/Home";
import { toast } from "react-toastify";
import Navbar from "../../components/Navbar";
import Sidebar from "../../components/Slidebar/Sidebar";
import { registerCourse } from "../../services/admin";
function AddCourse() {
  const [courseName, setCourseName] = useState("");
  const [capacity, setCapacity] = useState("");
  const [description, setDescription] = useState("");

  const [fee, setFee] = useState("");

  const [startDate, setStartDate] = useState("");
  const [endDate, setEndDate] = useState("");
  const [isSidebarOpen, setIsSidebarOpen] = useState(true);

  const toggleSidebar = () => {
    setIsSidebarOpen(!isSidebarOpen);
  };

  const onSave = async () => {
    if (courseName.length == 0) {
      toast.error("Please enter valid Course Name");
    } else if (capacity.length == 0) {
      toast.error("Please enter Capacity");
    } else if (description.length == 0) {
      toast.error("Please enter valid Description");
    } else if (fee.length == 0) {
      toast.error("Please enter Fee");
    } else if (startDate.length == 0) {
      toast.error("Please enter valid start date");
    } else if (endDate.length == 0) {
      toast.error("Please enter valid End date");
    } else {
      debugger;
      try {
        const result = await registerCourse(
          courseName,
          fee,
          description,
          startDate,
          endDate,
          capacity
        );
        if (result["status"] == 201) {
          toast.success("Course Successfully Added");
        } else {
          toast.error(result["error"]);
        }
      } catch (error) {
        toast.error("Problem Occuring for Adding a new Course");
      }
    }
  };
  const onCancel = () => {
    setCourseName("");
    setCapacity("");
    setDescription("");
    setFee("");
    setStartDate("");
    setEndDate("");
    toast.info("Form cleared");
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
                value={courseName}
                onChange={(e) => setCourseName(e.target.value)}
                type="text"
                className="form-control m-2"
                placeholder="Course Name"
              />

              <textarea
                value={description}
                onChange={(e) => setDescription(e.target.value)}
                type="text"
                className="form-control m-2"
                placeholder="Description"
              />
            </div>
            <div className="col">
              <input
                value={fee}
                onChange={(e) => setFee(e.target.value)}
                type="number"
                className="form-control m-2"
                placeholder="Fees"
              />
              <input
                value={capacity}
                onChange={(e) => setCapacity(e.target.value)}
                type="number"
                className="form-control m-2"
                placeholder="Capacity"
              />
            </div>
          </div>
          <div className="row">
            <div className="col">
              <input
                value={startDate}
                onChange={(e) => setStartDate(e.target.value)}
                type="date"
                className="form-control m-2"
                placeholder="Start Date"
              />
            </div>
            <div className="col">
              <input
                value={endDate}
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
                onClick={onCancel}
                className="btn btn-danger"
                style={{ marginRight: "1rem" }}>
                Cancel
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
