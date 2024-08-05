import React from 'react';
import { BiHome, BiBookAlt, BiMessage, BiSolidReport, BiStats, BiTask, BiHelpCircle, BiBookContent, BiPen, BiTable } from 'react-icons/bi';
import './Sidebar.css';

const Sidebar = () => {
    return (
        <div >
            <div className='logo'>
                <BiBookAlt className='icon' /> {/* Fixed the CSS class name */}
                <h5>Schedule Master </h5>
                <br/>
                <br/><br/><br/>
            </div>
            <div className='menu'>
            <div className='menu--list'> {/* Fixed the typo here */}
                <a href='#' className='item'>
                    <BiPen className='icon' />
                    Add New Faculty
                </a>

                <a href='#' className='item'>
                    <BiBookContent className='icon' />
                    Add New Courses
                </a>

                <a href='#' className='item'>
                    <BiSolidReport className='icon' />
                    View Student Details
                </a>

                <a href='#' className='item'>
                    <BiStats className='icon' />
                    View Faculty Details
                </a>

                <a href='#' className='item'>
                    <BiTable className='icon' />
                    Confirm Schedule
                </a>

                <a href='#' className='item'>
                    <BiHelpCircle className='icon' />
                    Help
                </a>
            </div>
        </div>
        </div>
    );
}

export default Sidebar;
