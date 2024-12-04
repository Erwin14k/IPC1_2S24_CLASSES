package Class01;

import java.util.Scanner;
public class JavaFundamentals {
    public static void main(String[] args){
        // Comenatios de una línea

        /*
         * Comentarios
         * de
         * varias
         * líneas
         */

        // Declaraciones de variables
        System.out.println("===========Variables============");
        int numeroEntero=100;  // Variable entera
        System.out.println("Variable entera: "+numeroEntero);
        double numeroDecimal=20.5;// Variable decimal
        System.out.println("Variable decimal: "+numeroDecimal);
        String texto= "Hola, estudiantes de ipc1";
        System.out.println("Variable string: "+texto);


        // Tipos primitivos y no primitivos
        System.out.println("\n==========Tipos primitivos y no primitivos============");
        // Primitivo
        boolean esVerdadero=true; // Primitivo : Boolean
        System.out.println("Como es primitivo, no tiene métodos asociados: "+esVerdadero);
        //No primitivo
        String cadena="Esto no es un primitivo";
        System.out.println("Como no es primitivo, se convierte: "+cadena.toUpperCase());


        // Casteos
        System.out.println("\n==========Casteos============");
        System.out.println("Casteo implícito");
        int num=99;
        System.out.println("Aquí es entero: "+num);
        double numGrande=num;
        System.out.println("Aquí se convierte a double: "+numGrande);

        System.out.println("Casteo explícito");
        double decimal=8.7;
        System.out.println("Aquí es double: "+decimal);
        int entero=(int) decimal; // Pérdida de presición
        System.out.println("Se convierte a entero con pérdida de precisión: "+entero);


        // Operadores aritméticos
        System.out.println("\n==========Operadores aritméticos============");
        System.out.println("Suma 5+3= "+(5+3));
        System.out.println("Resta 5-3= "+(5-3));
        System.out.println("Modular 10%3= "+(10%3));


        // Operadores relacionales
        System.out.println("\n==========Operadores Relacionales============");
        // >, <, ==, !=, <=, >=
        System.out.println("Mayor que (5>3): "+(5>3));
        System.out.println("Menor que (5<3): "+(5<3));


        // Operadores Lógicos
        System.out.println("\n==========Operadores Lógicos============");
        // &&, ||, !
        System.out.println("Operación (5>3) && (1<2)= "+((5>3) && (1<2)));
        System.out.println("Operación (5>3) && (1<-1)= "+((5>3) && (1<-1)));
        System.out.println("Operación (1<-1) || (5>3)= "+((1<-1) || (5>3)));
        System.out.println("! Negación: !5>3: "+ !(5>3));


        // Input y output
        System.out.println("\n==========Input/Output============");
        Scanner scanner= new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        String nombreUsuario= scanner.nextLine();
        System.out.println("Hola, "+nombreUsuario+ " estoy seguro que aprobarás ipc1 :)");



        // Estructuras de control
        System.out.println("\n==========Estructuras de control============");
        System.out.println("\nIF,ELSE IF, ELSE");
        int notaIpc1=59;
        if(notaIpc1<61){
            System.out.println("Se reprobó el curso");
        }else if (notaIpc1==61){
            System.out.println("Se aprobó el curso");
        }else{
            System.out.println("Entramos al else");
        }


        int edad = 10;

        if(edad <5 ){
            System.out.println("Eres un bebé");
        }else if ( edad >5 && edad <12){
            System.out.println("Eres un niño");
        }else if(edad >12 && edad < 18){
            System.out.println("Es un adolescente");
        }else{
            System.out.println("Eres un adulto");
        }


        // Ciclos
        System.out.println("\n==========Ciclos============");

        // Ciclo for
        System.out.println("\nCiclo for");
        // for (contador; condición; acción)
        for(int i=0;i<10;i++){
            System.out.println("Iteración "+i+" del ciclo for");
            //i aumenta
        }


        // ciclo while
        System.out.println("\nCiclo While");
        int contador=0;
        // while ( condición){}
        while(contador <5){
            System.out.println("Contador del while: "+contador);
            contador ++;
        }


        // ciclo do-while
        System.out.println("\nCiclo Do-While");
        int numero=5;
        do{
            System.out.println("Número en ciclo do-while: "+numero);
            numero--;
        }while(numero>6);


        // Cerrar scanner
        scanner.close();

    }
}
