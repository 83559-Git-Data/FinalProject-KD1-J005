import React from 'react'
import ContentHeader from './ContentHeaded';
import Card from './Card'
import './Content.css';
import TeacherList from './TeacherList';
const Content = () => {
    return(
        <div className='content'>
            <ContentHeader/>
            <Card/>
            <TeacherList/>
        </div>
    )
}

export default Content;