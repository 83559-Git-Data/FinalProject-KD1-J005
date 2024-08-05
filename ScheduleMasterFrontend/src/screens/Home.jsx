import React from 'react';
import Content from '../components/Content';
import Profile from '../components/Profile';
import Sidebar from '../components/Sidebar';
import './Home.css';

function Home() {
    return (
        <div className="dashboard">
            <Sidebar />
            <div className="dashboard--content">
                <Content />
                <Profile />
            </div>
        </div>
    );
}

export default Home;
