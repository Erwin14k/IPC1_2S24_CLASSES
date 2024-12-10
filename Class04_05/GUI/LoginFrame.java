package Class04_05.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame {
    static String[] adminData={"ipc1","**"};

    public static void loginView(){
        // Se crea el frame y se la agrega el título
        JFrame loginFrame = new JFrame("Sports");
        loginFrame.setLayout(null);
        // Se hace visible el frame
        loginFrame.setVisible(true);
        // Se restringe al frame a no poder cambiar de tamaño
        loginFrame.setResizable(true);
        // Se le coloca un color al fondo del frame
        loginFrame.getContentPane().setBackground(Color.BLUE);
        // Se le indica al frame que hacer en caso de que se cierre el mismo.
        loginFrame.setDefaultCloseOperation(3);
        //Con esto obtenemos las dimensiones de resolución de pantalla
        //Toolkit myScreen=Toolkit.getDefaultToolkit();
        //Dimension sizeScreen=myScreen.getScreenSize();
        // Le asignamos un tamaño al frame
        loginFrame.setSize(1080,720); // setSize(ancho,alto)
        loginFrame.setLocation(250,80); // setSize(x,y)
        // Le agregamos un ícono al frame
        //Image myIcon= myScreen.getImage("img/logo.png");
        //loginFrame.setIconImage(myIcon);


        // Fuentes de texto
        Font font = new Font("Helvetica",Font.BOLD,30);
        Font font2 = new Font("Showcard Gothic",Font.BOLD,30);
        // Labels
        // Label de título
        JLabel titleLabel= new JLabel("Tienda de deportes");  
        titleLabel.setLayout(null);    
        titleLabel.setVisible(true);     
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setBounds(350,10,900,60); //setBounds(x,y,ancho,alto)
        titleLabel.setFont(font);
        // Agregar el label al frame
        loginFrame.add(titleLabel);

        // Label de usuario
        JLabel usernameLabel = new JLabel("USER: ");
        usernameLabel.setLayout(null);
        usernameLabel.setVisible(true);
        usernameLabel.setForeground(Color.BLACK);
        usernameLabel.setBounds(220,150,250,50);
        usernameLabel.setFont(font2);
        // Agregar el label al frame
        loginFrame.add(usernameLabel);


        // Label de contrasela
        JLabel passwordLabel = new JLabel("PASSWORD: ");
        passwordLabel.setLayout(null);
        passwordLabel.setVisible(true);
        passwordLabel.setForeground(Color.BLACK);
        passwordLabel.setBounds(220,250,250,50);
        passwordLabel.setFont(font2);
        // Agregar el label al frame
        loginFrame.add(passwordLabel);

        // Texfields

        // Texfield de usuario
        JTextField usernameTextField = new JTextField();
        usernameTextField.setLayout(null);
        usernameTextField.setVisible(true);
        usernameTextField.setBounds(450,145,350,40);
        usernameTextField.setFont(font);
        usernameTextField.setBackground(Color.WHITE);
        loginFrame.add(usernameTextField);


        // Texfield de contraseña
        JPasswordField passwordTextField = new JPasswordField();
        passwordTextField.setLayout(null);
        passwordTextField.setVisible(true);
        passwordTextField.setBounds(450,245,350,40);
        passwordTextField.setFont(font);
        passwordTextField.setBackground(Color.WHITE);
        loginFrame.add(passwordTextField);



        // Botón de inicio de sesión
        JButton loginButton= new JButton("Iniciar sesión");
        loginButton.setLayout(null);
        loginButton.setVisible(true);
        loginButton.setBounds(380,350,300,60);
        loginButton.setFont(font2);
        loginButton.setBackground(Color.YELLOW);
        loginButton.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                // Validar login
                if(usernameTextField.getText().equals(adminData[0])&&
                passwordTextField.getText().equals(adminData[1])){
                    JOptionPane.showMessageDialog(null,"<html><p style=\"color:green; font:20px; \">Incio de sesión exitoso</p></html>");
                    loginFrame.dispose();
                }else{
                    JOptionPane.showMessageDialog(null,"<html><p style=\"color:red; font:20px; \">Usuario/Contraseña incorrectos, intente de nuevo</p></html>");
                }
            }
            
        
        });
        loginFrame.add(loginButton);


        // Repintado del frame
        loginFrame.repaint();

    }
    
}
