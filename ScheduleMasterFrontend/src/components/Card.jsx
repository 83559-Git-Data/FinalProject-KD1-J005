import { BiLogoHtml5, BiLogoAndroid, BiBuilding, BiLogoJava, BiLogoReact, BiLogoMongodb } from 'react-icons/bi';
import React from 'react';

const courses = [
    {
        title: 'Java',
        duration: '2hours',
        icon: <BiLogoJava />,
    },
    {
        title: 'React',
        duration: '2 hours',
        icon: <BiLogoReact/>,
    },
    {
        title: 'MongoDB',
        duration: '2 hours',
        icon: <BiLogoMongodb />,
    },
];

const Card = () => {
    return (
        <div className='card--container'>
            {courses.map((item, index) => (
                <div key={index} className='card'>
                    <div className='card--cover'>{item.icon}</div>
                    <div className='card--title'>
                        <h3>{item.title}</h3>
                    </div>
                    {item.duration && (
                        <div className='card--duration'>
                            <p>{item.duration}</p>
                        </div>
                    )}
                </div>
            ))}
        </div>
    );
}

export default Card;
