package Class02;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class SportsStore {
    static String user="ipc1";
    static String password="**";
    static boolean logged=false;
    static int menuOption=0;
    static String [][] productsMatrix = new String [15][3];
    static Scanner loginScanner= new Scanner(System.in);
    static Scanner menuScanner= new Scanner(System.in);
    static int productsCounter=0;
    public static void main(String[] args){
        login();
    }

    public static void login(){
        do{
            String[] loginData=new String[2];
            System.out.println("*******-Login-*********");
            System.out.println("User: ");
            loginData[0]= loginScanner.nextLine();
            System.out.println("Password: ");
            loginData[1]= loginScanner.nextLine();
            if(Objects.equals(loginData[0],user) &&  Objects.equals(loginData[1], password)){
                System.out.println("Bienvenido a la tienda de deportes admin !!");
                logged=true;
            }else{
                System.out.println("Error, datos incorrectos, intente de nuevo :()");
            }
        }while(!logged);
        menu();
    }


    public static void menu(){
        do{
            System.out.println("\n");
            System.out.println("*****************Menú*************");
            System.out.println("1. Cargar archivo de productos (Carga Masiva)");
            System.out.println("2. Ver productos en inventario");
            System.out.println("3. Salir");
            System.out.println();
            System.out.println("Opción a elegir: ");
            menuOption=menuScanner.nextInt();
        }while(menuOption<1 || menuOption>3);

        switch(menuOption){
            case 1:
                String filePath = "C:\\Github\\IPC1_2S24_CLASSES\\Class02\\products.ipc1"; // Ruta del archivo
                try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                    String line;
                    boolean isFirstLine = true; // Para omitir los encabezados
        
                    while ((line = br.readLine()) != null) {
                        if (isFirstLine) {
                            isFirstLine = false; // Saltar los encabezados
                            continue;
                        }
        
                        String[] parts = line.split(";");
                        if (parts.length == 2) {
                            String nombre = parts[0];
                            try {
                                double precio = Double.parseDouble(parts[1]);
                                if (precio > 0) {
                                    productsMatrix[productsCounter][0]=nombre;
                                    productsMatrix[productsCounter][1]=Double.toString(precio);
                                    productsCounter++;
                                } else {
                                    System.out.println("Precio inválido (menor o igual a 0) en el producto: " + nombre);
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Formato de precio inválido en la línea: " + line);
                            }
                        } else {
                            System.out.println("Línea inválida: " + line);
                        }
                    }
                } catch (IOException e) {
                    System.err.println("Error al leer el archivo: " + e.getMessage());
                }
                menu();
            case 2:
                System.out.println("\nProductos en inventario: ");
                for (int i=0;i<productsCounter;i++){
                    System.out.println(productsMatrix[i][0]+"-----"+productsMatrix[i][1]);
                }
                menu();
                
            case 3:
                System.out.println("Vuelva pronto");
                System.exit(0);
            default:
                System.out.println("Opción de menú incorrecta, intente de nuevo");
                menu();
        }
    }

}
