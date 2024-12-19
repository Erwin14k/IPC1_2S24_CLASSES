import React ,{useState} from 'react';
import Swal from 'sweetalert2';
import 'bootstrap/dist/css/bootstrap.min.css';
import './Dashboard.css';

import Table from 'react-bootstrap/Table';


const Dashboard =()=>{  
    const [ productBody, setProductBody]= useState(''); // Para guardar el contenido de mi nuevo producto
    // UseState para administrar los productos que obtengamos de nuestro backend
    const[products, setProducts]=useState([]);

    // Función que maneja el cambio de texto en el textarea
    const handleChange=(event)=>{
        setProductBody(event.target.value);
    };

    // Función que maneja el envío de mi producto hacia el backend para su creación
    const handleSubmit=async()=>{
        const data={
            content:productBody // Contenido del textarea
        }
        // Realizamos la solicitud al backend para crear nuevo producto
        const response= await fetch('http://localhost:3006/store/new-product',{
            method:'POST',
            headers:{
                'Content-Type':'application/json',
            },
            body: JSON.stringify(JSON.parse(data.content)),
        });

        const result = await response.json();
        if(result.status==="success"){
            await Swal.fire({
                title:'<span style="color:#A0A4B4;">Nuevo producto</span>',
                html:'<span style="color:#A0A4B4;">Creación de producto exitosa</span>',
                icon:"success",
                confirmButtonText:"Cerrar",
                background:"#222",
                confirmButtonColor:"red",
            })
            await updateProducts();
        }else{
            await Swal.fire({
                title:'<span style="color:#A0A4B4;">Nuevo producto</span>',
                html:'<span style="color:#A0A4B4;">Errpr al crear el producto</span>',
                icon:"error",
                confirmButtonText:"Cerrar",
                background:"#222",
                confirmButtonColor:"red",
            })
        }
    }


    // Petición al backend para obtener todos los productos registrados
    const getProducts = async()=>{
        const response= await fetch("http://localhost:3006/store/get-products",{
            method:"GET",
            headers:{
                'Content-Type':'application/json',
            },
        });
        // Capturamos los productos obtenidos
        const products=await response.json();
        return products;
    }
    
    // Función para actualizar los productos actuales, con los más recientes del backend
    const updateProducts = async()=>{
        try{
            var products= await getProducts();
            // Actualizamos productos
            setProducts(products);
        }catch(error){
            console.log(error)
        }
    }
    
    
    return(
        <>
            <div>
                <h2>Bienvenido al dashboard de la tienda</h2>
                <textarea
                    rows="10"
                    cols="50"
                    placeholder='Crea un nuevo producto aquí.....'
                    value={productBody} // Valor del textarea almacenado en mi variable del contenido del producto
                    onChange={handleChange} // Función para actualizar el estado de mi producto
                />
                <br/>
                <button onClick={handleSubmit}>Enviar</button>
            </div>
            <h1>Productos registrados en el sistema</h1>
            <div className="table-container">
                <Table striped bordered hover variant='dark'>
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Precio</th>
                        </tr>
                    </thead>
                    <tbody>
                        {/*Recorremos los productos y mostramos cada uno en una fila */}
                        { products.length>0 ?(
                            products.map((product)=>(
                                <tr key={product.product_id}>
                                    <td>{product.product_id}</td>
                                    <td>{product.name}</td>
                                    <td>{product.price}</td>
                                </tr>
                            ))
                        ):(
                            <tr>
                                <td colSpan="3">No hay productos registrados</td>
                            </tr>
                        )}  
                    </tbody>
                </Table>


            </div>
        </>

    );
}


export default Dashboard;