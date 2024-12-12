package Class04_05_06_07;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import Class04_05_06_07.GUI.LoginFrame;
import Class04_05_06_07.Product.Product;
import Class04_05_06_07.Product.ProductDAO;

public class Main {
    public static void main(String[] args){
        // Instancias de objetos (cada uno es único)
        //Product producto = new Product(1,"",12.99);
        //Product product2 = new Product(2,"",13.99);
        
        // Instancias de objetos (es la misma instancia)
        //ProductDAO prod=ProductDAO.getInstance();
        // Carga masiva
        //ProductDAO prod2=ProductDAO.getInstance();

        // Reconstruir la información serializada
        ProductDAO productHandler= ProductDAO.getInstance();
        try{
            ObjectInputStream recoveredData= new ObjectInputStream(new FileInputStream("Class04_05_06_07/data.ipc1"));
            productHandler.products=(ArrayList<Product>)recoveredData.readObject();
            recoveredData.close();
        }catch(Exception e){
            System.out.println("An error ocurred: "+e);
        }
        LoginFrame.loginView();
    
    }
    
}
