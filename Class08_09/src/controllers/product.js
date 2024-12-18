const products=require('../models/product');

// Importar la información del admin
const {adminData}=require("../config/config")
// Controlador para manejar la creación de un nuevo producto
module.exports.newProduct=async(req,res,next)=>{
    try{
        // Obtenemos los datos del producto
        const newProduct=req.body;
        products.push(newProduct);
        res.status(200).json({
            message:"Producto creado con éxito!",
            status:"success"
        })
    }catch(error){
        res.status(400).json({
            error:error.message,
            status:"error"
        })
    }
}


// Controlador para obtener todos los productos
module.exports.allProducts=async(req,res)=>{
    try{
        res.status(200).json(products);
    }catch(error){
        res.status(400).json({
            error:error.message
        })
    }
}

// Controlador para administrar el login
module.exports.login=async(req,res)=>{
    try{
        if(req.body.username==adminData.username &&
            req.body.password==adminData.password){
                res.status(200).json({
                    message:"Login exitoso",
                    status:"success"
                });
        }else{
            res.status(401).json({
                message:"Usuario/Contraseña incorrecta intente de nuevo!",
                status:"error"
            });
        }
        
    }catch(error){
        res.status(500).json({
            error:error.message
        })
    }
}
