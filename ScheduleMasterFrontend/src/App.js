import logo from './logo.svg';
import './App.css';
import Login from './screens/Login';
import Home from './screens/Home';
import Student from './screens/Student';
import { Route, Routes } from 'react-router-dom';
import Register from './screens/Register';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function App() {
  return (
    <div className='container-fluid'>
    <Routes>
      <Route path='' element={<Login/>}/>
      <Route path='login' element={<Login/>}/>
      <Route path="register" element={<Register/>}/>
      <Route path="home" element={<Home/>}/>
      <Route path="student" element={<Student/>}/>
      {/* <Route path="student-details" element={<Home/>}/>
      <Route path="course" element={<Home/>}/>
      <Route path="course-details" element={<Home/>}/> */}
      
    </Routes>
    <ToastContainer />

    </div>
    // <div>
    //   <AddCourse/>
    // </div>
  );
}

export default App;
