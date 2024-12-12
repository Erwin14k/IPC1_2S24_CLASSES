package Class04_05_06_07.Product;

import java.io.Serializable;

public class Product implements Serializable{
    // Atributos
    private int productId; 
    private String name;
    private Double price; 

    // Constuctor
    public Product(int productId, String name,Double price){
        this.productId=productId;
        this.name=name;
        this.price=price;
    }

    
    // Getters y setters
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId){
        this.productId=productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


}
