import { useState } from "react"

function AddCourse() {
    const [name,setName]=useState('');
    const [facultyName,setFacultyName]=useState('');
    const [description,setDescription]=useState('');
    const [course_id,setCourseId]=useState('');
    const [fee,setFee]=useState('');
    const [faculty_id,setFacultyId]=useState('');
    const [startDate,setStartDate]=useState('');
    const [endDate,setEndDate]=useState('');

    const onSave=()=>{
        if(name.length==0){
            alert('Please enter valid Course Name');
        }else if(facultyName.length==0){
            console.log(name);
            alert('Please enter valid Faculty Name');
        }else if(description.length==0){
            alert('Please enter valid Description');
        }else if(course_id.length==0){
            alert('Please enter valid Course Id');
        }else if(fee.length==0){
            alert('Please enter valid Faculty Name');
        }else if(faculty_id.length==0){
            alert('Please enter valid Faculty Id');
        }else if(startDate.length==0){
            alert('Please enter valid start date');
        }else if(endDate.length==0){ 
            alert('Please enter valid End date');
        }

    }



    return (
        <div className="page-header">

            <button className="btn btn-success">Add Course</button>
            <div className="row">
                <div className="col-3"></div>
                <div className="col dotted rounded">
                    <div className="row">
                        <div className="col">
                            <input 
                            onChange={(e)=>(setName(e.target.value))}
                            type="text" className="form-control m-2" placeholder="Course Name" />
                            <input 
                            onChange={(e)=>(setFacultyName(e.target.value))}
                            type="text" className="form-control m-2" placeholder="Faculty Name" />
                            <textarea 
                            onChange={(e)=>(setDescription(e.target.value))}
                            type="text" className="form-control m-2" placeholder="Description" />
                        </div>
                        <div className="col">
                            <input 
                            onChange={(e)=>(setCourseId(e.target.value))}
                            type="text" className="form-control m-2  " placeholder="Course Id" />
                            <input 
                            onChange={(e)=>(setFee(e.target.value))}
                            type="text" className="form-control m-2" placeholder="Fees" />
                            <input
                            onChange={(e)=>(setFacultyId(e.target.value))}
                            type="text" className="form-control m-2" placeholder="Faculty Id" />

                        </div>
                    </div>
                    <div className="row">
                        <div className="col">
                            <input 
                            onChange={(e)=>(setEndDate(e.target.value))}
                            type="date" className="form-control m-2" placeholder="Start Date" />
                        </div>
                        <div className="col">
                            <input 
                            onChange={(e)=>(setEndDate(e.target.value))}
                            type="date" className="form-control m-2" placeholder="End Date" />
                        </div>
                    </div>
                    <div className="roe">
                        <div className="row">
                            <div className="col"><button onClick={onSave}  className="btn btn-success">Save</button></div>
                            <div className="col"><button className="btn btn-primary">Edit</button></div>
                            <div className="col"><button className="btn btn-danger">Cancel</button></div>
                        </div>
                    </div>
                </div>
                <div className="col-3"></div>
            </div>
        </div>
    )
}

export default AddCourse
