import logo from "./logo.svg";
import "./App.css";
import Login from "./screens/Login";
import Home from "./screens/Home";
import Student from "./screens/Student";
import { Route, Routes } from "react-router-dom";
import Register from "./screens/Register";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import AddCourse from "./screens/AddCourse";
import AddFaculty from "./screens/AddFaculty";
import AboutUs from "./screens/AboutUs";
import ScheduleFaculty from "./screens/ScheduleFaculty";
import FacultyDetails from "./screens/FactultyDetails";
import StudentDetails from "./screens/StudentsDetails";

function App() {
  return (
    <div className="container-fluid">
      <Routes>
        <Route path="" element={<Login />} />
        <Route path="login" element={<Login />} />
        <Route path="register" element={<Register />} />
        <Route path="home" element={<Home />} />
        <Route path="student" element={<Student />} />
        <Route path="addCourse" element={<AddCourse />} />
        <Route path="addFaculty" element={<AddFaculty />} />
        <Route path="aboutus" element={<AboutUs />} />
        <Route path="schedulefaculty" element={<ScheduleFaculty />} />
        <Route path="faculty-details" element={<FacultyDetails />} />
        <Route path="student-details" element={<StudentDetails />} />
      </Routes>
      <ToastContainer />
    </div>
  );
}

export default App;
