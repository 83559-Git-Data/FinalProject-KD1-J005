import React from "react";
import ContentHeader from "../Slidebar/ContentHeaded";
import Card from "../Slidebar/Card";
import "../Slidebar/Content.css";
import TeacherList from "../Slidebar/TeacherList";
const Content = () => {
  return (
    <div className="content">
      <ContentHeader />
      <Card />
      <TeacherList />
    </div>
  );
};

export default Content;
