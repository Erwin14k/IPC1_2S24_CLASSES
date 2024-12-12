package Class04_05_06_07.Product;

import java.util.ArrayList;

public class ProductDAO {
    public ArrayList<Product> products;
    public static ProductDAO instance;

    public ProductDAO(){
        this.products= new ArrayList<Product>();
    }

    public static ProductDAO getInstance(){
        // Si no existe ninguna instancia de este clase se crea
        if(instance == null){
            instance = new ProductDAO();
        }
        return instance;
    }

    public Object [][] returnProductsData(){ 
        // Obtener cuantas filas (productos) tengo almacenados 
        // Hacemos uso del operador ternario.
        // Luego del ? se aplica si se cumple la condición
        // Luego de los : se aplica si no se cumple la condición.
        int rows= this.products.size()==0?0:this.products.size();
        Object [][] productMatrix;
        // Validamos que tengamos al menos un producto
        if (rows>0){
            productMatrix= new Object[rows][3];
            // Agregar los productos a mi matriz
            for ( int i=0; i<this.products.size(); i++){
                productMatrix[i][0]=this.products.get(i).getProductId();
                productMatrix[i][1]=this.products.get(i).getName();
                productMatrix[i][2]=this.products.get(i).getPrice();
            }
            // Retornamos la matriz con mis productos en ella
            return productMatrix;
        }else{
            // Si no hay productos, retornamos una matriz vacía
            productMatrix= new Object[rows][3];
            return productMatrix;
        }
    }



    // Función para crear un nuevo producto
    public String [] newProduct (int id, String name, Double price){
        // Se devolverá un array con los siguientes datos:
        // [0]: El estado (Si se creo o no correctamente)
        // [1]: Mensaje de respuesta.
        String [] result= new String[2];
        // Validar el precio
        if( price >0){
            // Validar que el producto no existe (Condición: id)
            // for: Tipo_de_objeto objeto_temporal: lista_de_objetos
            for (Product product: this.products){
                if(Integer.compare(product.getProductId(),id)==0){
                    result[0]="0";
                    result[1]="El id del producto ya existe";
                    return result;
                }
            }
            // Ya despupes de validar, ya podemos crear el producto y agregarlo a nuestra vista
            this.products.add(new Product(id,name,price));
            result[0]="1";
            result[1]="Producto creado con éxito";
            return result;

        }else{
            result[0]="0";
            result[1]="El precio no puede ser igual o inferior a 0";
            return result;
        }
    }

    // Eliminar un producto en base a su nombre
    public void deleteProduct(String name){

        // Verificar mi lista inicialmente.
        System.out.println("Mi lista antes de eliminarse: ");
        for (Product product: this.products){
            System.out.println(product.getName());
        }

        for (int i=0;i<this.products.size();i++){
            if(this.products.get(i).getName().equals(name)){
                this.products.remove(i);
                break;
            }
        }

        // Verificar mi lista para ver si se eliminó
        System.out.println("Mi lista después de eliminarse: ");
        for (Product product: this.products){
            System.out.println(product.getName());
        }
    }
}
