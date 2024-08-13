import { useState } from "react";
import "../Common.css";
import "../Headers/Home";
import { toast } from "react-toastify";
import Navbar from "../../components/Navbar";
import Sidebar from "../../components/Slidebar/Sidebar";
import { registerModule } from "../../services/admin";

function AddModule() {
  const [name, setName] = useState("");
  const [hours, setHours] = useState("");

  const [isSidebarOpen, setIsSidebarOpen] = useState(true);

  const toggleSidebar = () => {
    setIsSidebarOpen(!isSidebarOpen);
  };

  const onSave = async () => {
    if (name.length == 0) {
      toast.error("Please enter module  Name");
    } else if (hours.length == 0) {
      toast.error("Please enter module hours");
    } else {
      debugger;
      try {
        debugger;
        const result = await registerModule(name, hours);
        if (result["status"] == 201) {
          toast.success("Module Successfully Added");
        } else {
          toast.error(result["error"]);
        }
      } catch (error) {
        toast.error("Problem Occuring for Adding a new Moude");
      }
    }
  };
  const onCancel = () => {
    setName("");
    setHours("");
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
          <h2 className="page-header aligns-items-center">Add Module</h2>
          <div className="row">
            <div className="col">
              <input
                value={name}
                onChange={(e) => setName(e.target.value)}
                type="text"
                className="form-control m-2"
                placeholder="Module Name"
              />

              <textarea
                value={hours}
                onChange={(e) => setHours(e.target.value)}
                type="number"
                className="form-control m-2"
                placeholder="Module duration in Hours"
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

export default AddModule;
