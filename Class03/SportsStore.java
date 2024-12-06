package Class03;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class SportsStore {
    static String user="ipc1";
    static String password="**";
    static boolean logged=false;
    static int menuOption=0;
    static String [][] productsMatrix = new String [15][2];
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
            System.out.println("3. Generar archivo html de productos ordenados por precio");
            System.out.println("4. Salir");
            System.out.println();
            System.out.println("Opción a elegir: ");
            menuOption=menuScanner.nextInt();
        }while(menuOption<1 || menuOption>4);

        switch(menuOption){
            case 1:
                String filePath = "C:\\Github\\IPC1_2S24_CLASSES\\Class03\\products.ipc1"; // Ruta del archivo
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
                bubblesort(productsMatrix);
                generateHtml("Class03/productosOrdenados.html");
                menu();
            case 4:
                System.out.println("Vuelva pronto");
                System.exit(0);
            default:
                System.out.println("Opción de menú incorrecta, intente de nuevo");
                menu();
        }
    }



    public static void bubblesort(String [][] matrix){

        //Asegurarnos que no haya valores nulos
        for (int i=0;i<matrix.length;i++){
            if(matrix[i][1]==null){
                matrix[i][1]="0"; // Asignamos un precio por defecto
            }
        }
        int n= matrix.length;
        boolean swapped;

        for (int i=0;i<n-1;i++){
            swapped=false;
            for(int j=0;j<n-1-i;j++){
                // Convertimos el precio (columna 1) a números para comparar
                double price1=Double.parseDouble(matrix[j][1]);
                double price2=Double.parseDouble(matrix[j+1][1]);

                if(price1 < price2){
                    //Intercambiamos las filas
                    String[] temp= matrix[j];
                    matrix[j]=matrix[j+1];
                    matrix[j+1]=temp;
                    swapped=true;
                }
            }
            // Si no hubo intercambios, la matriz ya está ordenada
            if(!swapped){
                break;
            }

        }

    }

    public static void generateHtml(String fileName){

        //Crear HTML
        try(BufferedWriter writter =new BufferedWriter(new FileWriter(fileName))){
            writter.write("<html>\n");
            writter.write("<head>\n");
            writter.write("<title> Tabla de productos ordenada </title>\n");
            writter.write("<style>\n");
            writter.write("table {boder-collapse: collapse; width:100%;}\n");
            writter.write("th,td {boder:1px solid black; padding:8px; text-align:left;}\n");
            writter.write("</style>\n");
            writter.write("</head>\n");
            writter.write("<body>\n");

            writter.write("<h1>Datos de la Tabla</h1>\n");
            writter.write("<table>\n");
            writter.write("<th>Producto</th> <th>Precio</th>\n");

            //Generar las filas de la tabla
            for(int i=0; i<productsCounter;i++){
                writter.write("<tr>\n");
                for(int j=0;j<productsMatrix[i].length;j++){
                    writter.write("<td>"+productsMatrix[i][j]+"</td>\n"); // Datos
                }
                writter.write("</tr>\n");
            }

            writter.write("</table>\n");
            writter.write("</body>\n");
            writter.write("</html>\n");

            System.out.println("Archivo HTML generado correctamente: "+fileName);




        }catch(IOException e ){
            System.err.println("Error al escribir el archivo HTML: "+e.getMessage());
        }
    }



}
