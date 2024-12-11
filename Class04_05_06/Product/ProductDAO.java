package Class04_05_06.Product;

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


}
