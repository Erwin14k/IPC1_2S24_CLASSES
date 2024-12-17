const express=require('express');
const router=express.Router();

const {newProduct,allProducts,login}= require('../controllers/product');


// Métodos de petición:
// POST: Se envía información del frontend y el backend la recibe
// GET: Devolvemos información del backend
// DELETE: Eliminamos algo en el backend
// PUT: Actualizamos algo en backend


// Endpoint para crear un nuevo producto
router.post('/store/new-product',newProduct);

// Endpoint para devolver todos los productos en el sistema
router.get('/store/get-products',allProducts);

// Endpoint para el login
router.post('/store/login',login);

module.exports=router;