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
            message:"Producto creado con éxito!"
        })
    }catch(error){
        res.status(400).json({
            error:error.message
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
                    message:"Login exitoso"
                });
        }else{
            res.status(500).json({
                message:"Usuario/Contraseña incorrecta intente de nuevo!",
            });
        }
        
    }catch(error){
        res.status(400).json({
            error:error.message
        })
    }
}
