package Class04_05_06.GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NewProductView {
    public static void productCreationView(){
        // Creación de mi frame para crear productos
        JFrame productCreationFrame= new JFrame("");
        productCreationFrame.setLayout(null);

        // Se hace visible el frame
        productCreationFrame.setVisible(true);
        // Se restringe el cambio de tamaño
        productCreationFrame.setResizable(false);
        // Fondo de color del frame
        productCreationFrame.getContentPane().setBackground(Color.ORANGE);
        // Operación cuando se intente cerrar
        productCreationFrame.setDefaultCloseOperation(0);
        // Dimensiones del frame
        productCreationFrame.setSize(900,600);
        // Ubicación de aparición
        productCreationFrame.setLocation(250,50);


        // Fuentes de texto
        Font font1= new Font("Showcard Gothic",Font.BOLD,30);
        Font font2= new Font("Helvetica",Font.BOLD,30);

        // Label de título
        JLabel titleLabel = new JLabel("Nuevo producto");
        titleLabel.setLayout(null);
        titleLabel.setVisible(true);
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setBounds(320,20,450,60);
        titleLabel.setFont(font2);
        // Agregación del label al frame
        productCreationFrame.add(titleLabel);

        // Label que nos pide el id
        JLabel idLabel = new JLabel("ID:");
        idLabel.setLayout(null);
        idLabel.setVisible(true);
        idLabel.setForeground(Color.BLACK);
        idLabel.setBounds(50,100,450,60);
        idLabel.setFont(font2);
        // Agregación del label al frame
        productCreationFrame.add(idLabel);


        // Label que nos pide el nombre
        JLabel nameLabel = new JLabel("Nombre:");
        nameLabel.setLayout(null);
        nameLabel.setVisible(true);
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setBounds(50,200,450,60);
        nameLabel.setFont(font2);
        // Agregación del label al frame
        productCreationFrame.add(nameLabel);

        // Label que nos pide el precio
        JLabel priceLabel = new JLabel("Precio:");
        priceLabel.setLayout(null);
        priceLabel.setVisible(true);
        priceLabel.setForeground(Color.BLACK);
        priceLabel.setBounds(50,300,450,60);
        priceLabel.setFont(font2);
        // Agregación del label al frame
        productCreationFrame.add(priceLabel);


        // Campos de texto

        // Texfield para el id
        JTextField idTextField= new JTextField();
        idTextField.setLayout(null);
        idTextField.setVisible(true);
        idTextField.setBounds(300,100,400,60);
        idTextField.setBackground(Color.WHITE);
        idTextField.setFont(font2);
        productCreationFrame.add(idTextField);



        // Texfield para el nombre
        JTextField nameTextField= new JTextField();
        nameTextField.setLayout(null);
        nameTextField.setVisible(true);
        nameTextField.setBounds(300,200,400,60);
        nameTextField.setBackground(Color.WHITE);
        nameTextField.setFont(font2);
        productCreationFrame.add(nameTextField);


        // Texfield para el precio
        JTextField priceTextField= new JTextField();
        priceTextField.setLayout(null);
        priceTextField.setVisible(true);
        priceTextField.setBounds(300,300,400,60);
        priceTextField.setBackground(Color.WHITE);
        priceTextField.setFont(font2);
        productCreationFrame.add(priceTextField);



        // Botón de creación de producto
        JButton newProductButton = new JButton("Crear");
        newProductButton.setLayout(null);
        newProductButton.setVisible(true);
        newProductButton.setBounds(320,470,320,60);
        newProductButton.setBackground(Color.YELLOW);
        newProductButton.setFont(font1);
        newProductButton.addActionListener(e->{
            // Todo lo de aquí se realiza con el botón de crear producto
            // Se cierrar el frame actual
            productCreationFrame.dispose();
            // Se regresa al módulo de administración
            AdminView.adminView();
        });
        productCreationFrame.add(newProductButton);





        // Renderizado del frame
        productCreationFrame.repaint();
    }
}
