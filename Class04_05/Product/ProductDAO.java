package Class04_05.Product;

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
}
