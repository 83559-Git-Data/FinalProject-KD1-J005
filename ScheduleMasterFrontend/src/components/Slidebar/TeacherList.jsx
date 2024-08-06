import React from "react";
import "../Slidebar/TeacherList.css";
import Images from "../../assets/images/Professorz.png";

const teachers = [
  {
    image: Images,
    name: "Prof. Nilesh Ghule         ",
    duration: "  20 hours lesson",
    cost: "15000",
  },
  {
    image: Images,
    name: "Prof. Amit Kulkarni      ",
    duration: "18 hours lesson",
    cost: "20000",
  },
  {
    image: Images,
    name: "Prof. Sammer Dehadri",
    duration: "15 hours lesson",
    cost: "12000",
  },
];
const TeacherList = () => {
  return (
    <div className="teacher--list">
      <div className="list--header">
        <h3>Teachers</h3>
        <select>
          <option vlaue="english">English</option>
          <option vlaue="hindi">Hindi</option>
        </select>
      </div>
      <div className="list--container">
        {teachers.map((teacher) => (
          <div className="list">
            <div className="teacher--detail">
              <img src={teachers.image} alt={teachers.name} />
              <h2 style={{ width: "400px" }}>{teacher.name}</h2>
            </div>
            <span style={{ width: "200px" }}>{teacher.duration}</span>
            <span>{teacher.cost}</span>
            <span className="teacher--todo">:</span>
          </div>
        ))}
      </div>
    </div>
  );
};

export default TeacherList;
