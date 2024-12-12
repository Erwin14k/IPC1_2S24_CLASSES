package Class04_05_06_07.GUI;

import java.awt.Color;
import java.awt.Font;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Class04_05_06_07.Product.ProductDAO;

public class AdminView {
    public static void adminView(){
        // Creación del frame
        JFrame adminView= new JFrame("Admin View");
        adminView.setLayout(null);
        // Hacer visible el frame
        adminView.setVisible(true);
        // Restringir el cambio de tamaño en la vista
        adminView.setResizable(false);
        // Color de fondo del frame
        adminView.getContentPane().setBackground(Color.ORANGE);
        // Operación al intentar cerrar el frame
        adminView.setDefaultCloseOperation(0);
        // Tamaño del frame
        adminView.setSize(1300,800);
        // Ubicación de aparición
        adminView.setLocation(0,0);

        // Fuentes de texto
        Font font1= new Font("Showcard Gothic",Font.BOLD,30);
        Font font2= new Font("Arial",Font.BOLD,18);

        // Label para el título
        JLabel frameTitle = new JLabel("Listado oficial de productos");
        frameTitle.setLayout(null);
        frameTitle.setVisible(true);
        frameTitle.setForeground(Color.BLACK);
        frameTitle.setBounds(90,20,600,60);
        frameTitle.setFont(font1);
        adminView.add(frameTitle);


        // Botón de guardar información
        JButton saveButton = new JButton("Guardar datos");
        saveButton.setLayout(null);
        saveButton.setVisible(true);
        saveButton.setBounds(25,630,300,60);
        saveButton.setBackground(Color.CYAN);
        saveButton.setFont(font1);
        saveButton.addActionListener(e->{
            // Todo lo de aquí se realiza con el botón de guardar
            try{
                System.out.println("Guardando datos......");
                ProductDAO productHandler = ProductDAO.getInstance();
                ObjectOutputStream savedData=new ObjectOutputStream(new FileOutputStream("Class04_05_06_07/data.ipc1"));
                savedData.writeObject(productHandler.products);
                savedData.close();
                JOptionPane.showMessageDialog(null,"<html><p style=\"color:green; font:20px;\">Datos guardados con éxito!!!</p></html>");

            }catch(Exception ex){
                System.out.println("An error ocurred: "+ex);
                JOptionPane.showMessageDialog(null,"<html><p style=\"color:red; font:20px\">Error al guardar datos...</p></html>");
            }
        });
        adminView.add(saveButton);

        // Botón para dirigirnos a crear un nuevo producto
        JButton newProductButton = new JButton("Nuevo Producto");
        newProductButton.setLayout(null);
        newProductButton.setVisible(true);
        newProductButton.setBounds(350,630,360,60);
        newProductButton.setBackground(Color.CYAN);
        newProductButton.setFont(font1);
        newProductButton.addActionListener(e->{
            // Todo lo de aquí se realiza con el botón de crear nuevo producto
            // Cerramos el frame actual
            adminView.dispose();
            // Nos dirigimos a la venta de crear producto
            NewProductView.productCreationView();
        });
        adminView.add(newProductButton);


        // Botón para dirigirnos a eliminar un  producto
        JButton deleteProduct = new JButton("Eliminar Producto");
        deleteProduct.setLayout(null);
        deleteProduct.setVisible(true);
        deleteProduct.setBounds(725,630,360,60);
        deleteProduct.setBackground(Color.CYAN);
        deleteProduct.setFont(font1);
        deleteProduct.addActionListener(e->{
            ProductDAO productHandler= ProductDAO.getInstance();
            // Eliminamos un producto de prueba
            productHandler.deleteProduct("Eliminar");
            adminView.dispose();
            

        });
        adminView.add(deleteProduct);


        // Botón para dirigirnos a crear un nuevo producto
        JButton logoutButton = new JButton("Cerrar sesión");
        logoutButton.setLayout(null);
        logoutButton.setVisible(true);
        logoutButton.setBounds(25,700,300,60);
        logoutButton.setBackground(Color.RED);
        logoutButton.setFont(font1);
        logoutButton.addActionListener(e->{
            // Todo lo de aquí se realiza con el botón de cerrar sesión
            adminView.dispose();
            LoginFrame.loginView();
        });
        adminView.add(logoutButton);


        // Creación de la tabla de productos

        // Instancia de mi clase de manejador de productos
        ProductDAO productHandler=ProductDAO.getInstance();
        // Encabezado de la tabla
        String [] header={"Código","Nombre","Precio"};
        // Creación del componente tabla
        JTable productsTable= new JTable(productHandler.returnProductsData(),header);
        // SCROLL ( Contenedor que almacena mi tabla)
        JScrollPane productsDataTableSC= new JScrollPane(productsTable);

        // Color a mi tabla
        productsDataTableSC.getViewport().setBackground(Color.WHITE);

        // Modificar mi tabla 
        // Color de fondo de mis encabezados
        productsTable.getTableHeader().setBackground(Color.decode("#1D2A3B"));
        // Color de la letra de mis encabezados
        productsTable.getTableHeader().setForeground(Color.WHITE);

        // Fuente que utilizarán mis encabezados
        productsTable.getTableHeader().setFont(font2);

        // Tamaño de mis columnas
        productsTable.getColumnModel().getColumn(0).setPreferredWidth(150);
        productsTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        productsTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        // Tamaño de filas
        productsTable.setRowHeight(40);
        productsTable.setFont(font2);

        // Dimensiones de mi tabla ( Se las asignamos al scroll que es mi componente padre)
        productsDataTableSC.setBounds(20,100,800,500);

        // Agregamos la tabla al frame.
        adminView.add(productsDataTableSC);







        // Renderizado de la vista
        adminView.repaint();






    }
}
