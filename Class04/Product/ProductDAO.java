package Class04.Product;

import java.util.ArrayList;

public class ProductDAO {
    public ArrayList<Product> products;
    public static ProductDAO instance;

    private ProductDAO(){
        this.products= new ArrayList<Product>();
    }

    public static ProductDAO getInstance(){
        return instance;

    }
}
