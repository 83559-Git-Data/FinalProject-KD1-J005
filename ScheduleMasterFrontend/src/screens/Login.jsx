import { useState } from "react";
import { Link, useNavigate } from "react-router-dom"
import { toast } from "react-toastify";
import { login } from "../services/admin";

function Login(){
    const [userName, setuserName] = useState('')
    const [password, setPassword] = useState('')
    const [isuserNameEmpty, setuserNameEmpty] = useState(false)
    const [isPasswordEmpty, setPasswordEmpty] = useState(false)
    //conditional rendering --> line 20

    // get navigation hook
    const navigate = useNavigate()

    const onLogin = async () => {
        if(userName.length == 0)
        {
            toast.console.error('Please enter email');
        }
        else if(password.length == 0)
        {
            toast.console.error('Please enter password');
        }
        else{
            // call login API and check its success
            // go to home screen
            const result = await login(userName, password)
            if(result['status'] == 'success')
                {
                    const data = result['data']
                    sessionStorage['name'] = data['name']
                    sessionStorage['token'] = data['token']
                    navigate('/home')
                }else{
                    toast.error(result['error'])
                }
        }
    }


    return(
        <div>
            <h2 className="page-header">Login</h2>
            <div className="row">
            <div className='col'></div>
            <div className='col'>
                <div className='form'>
                    <div className="mb-3">
                        <label htmlFor="">userName</label>
                        <input 
                        onChange={(e) => {
                        if(e.target.value.length == 0){
                            setuserNameEmpty(true)
                        } else{
                            setuserNameEmpty(false)
                        }
                        setuserName(e.target.value)
                        }}    
                        type="userName" className="form-control"/>
                        {isuserNameEmpty && (
                        <p style={{color: 'red'}}>userName is manadatory</p>
                    )}
                    </div>
                    <div className="mb-3">
                        <label htmlFor="">Password</label>
                        <input 
                        onChange={(e) => {
                        if(e.target.value.length == 0){
                            setPasswordEmpty(true)
                        }else {
                            setPasswordEmpty(false)
                        }
                            setPassword(e.target.value)
                        }}
                        type="password" className="form-control"/>
                        {isPasswordEmpty && (
                        <p style={{color: 'red'}}>Password is manadatory</p>
                    )}
                    </div>
                
                    <div className="mb-3">
                        <div>
                            Don't have an account ? <Link to='/register'>Register Here</Link>
                        </div>
                    <button onClick={onLogin} className="btn btn-success mt-2">Login</button>
                    </div>
                </div>  
            </div>
            
            <div className='col'></div>
            </div>
        </div>
    )
}

export default Login; 