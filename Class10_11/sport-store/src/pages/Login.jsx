import React, {useState} from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import './Login.css'

const Login =()=>{
    // useState para manejar el estado de las credenciales
    const [credentials,setCredentials]= useState({username:'',password:''});
    // useState para manejar el estado de los errores a mostrar
    const [error, setError]=useState('');
    // Para permitirnos navegar entre rutas de react
    const navigate=useNavigate();


    const handleInputChange=(e)=>{
        const {name,value} =e.target;
        setCredentials({...credentials, [name]:value})
    }

    const handleSubmit=async(e)=>{
        e.preventDefault();
        try{
            const response = await axios.post('http://localhost:3006/store/login',credentials);
            if(response.data.status==="success"){
                navigate('/dashboard');
            }
        }catch(err){
            if(err.response && err.response.status===401){
                setError("Usuario/Contraseña incorrecta intente de nuevo!");
            }else{
                setError('Error al conectar con el backend :(');
            }
        }
    }

    return(
        <div className='login-container'>
            <h2>Login</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Usuario:</label>
                    <input 
                        type="text" 
                        name="username" 
                        value={credentials.username}
                        onChange={handleInputChange}
                        required
                        >
                    </input>
                </div>
                <div>
                    <label>Contraseña:</label>
                    <input 
                        type="password" 
                        name="password" 
                        value={credentials.password}
                        onChange={handleInputChange}
                        required
                        >
                    </input>
                </div>
                <button type="submit">Iniciar sesión</button>
                {error && <p style={{color:'red'}}>{error}</p>}
            </form>
        </div>
    );
}


export default Login;