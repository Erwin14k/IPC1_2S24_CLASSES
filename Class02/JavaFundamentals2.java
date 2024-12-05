package Class02;

import java.util.ArrayList;

public class JavaFundamentals2 {
    public static void main(String[] args){
        System.out.println("===========Arreglos=======");
        System.out.println("\n Arreglos unidimensionales");


        // Cuando conocemos los elementos
        int[] numeros={1,2,3,4,5};
        // Cuando desconocemos los elementos
        int [] numerosDesconocidos= new int[4];

        System.out.println("Primer elemento de mi array: "+numeros[2]);
        // Recorrer el arreglo números con un for
        System.out.println("Todos los elementos de mi array: ");
        for(int i=0; i<numeros.length;i++){
            System.out.println("Elemento en posición "+i+ " Es igual a:  "+numeros[i]);
        }

        //Modificar elementos
        numeros[1]=-7;
        System.out.println("Elemento modificado de mi array en índice 1: "+numeros[1]);



        System.out.println("\n===========Arreglos Multidimensionales=======");
        // Declaración
        int[][] matriz={
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        // Cuando no conocemos los elementos de una matriz
        int [][] matrizDesconocida= new int [1][2];


        System.out.println("Accediendo al elemento [1][2] de mi matriz: "+matriz[1][2]);

        // Recorrer una matriz
        System.out.println("Recorrido de mi matriz: ");
        // Ciclo para filas
        for(int i=0;i<matriz.length;i++){
            // Ciclo para cada columna de la fila actual
            for(int j=0; j<matriz[i].length;j++){
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }


        System.out.println("\n===========Listas dinámicas=======");
        // Crar una lista
        ArrayList<String> nombres= new ArrayList<>();
        nombres.add("Erwin");
        nombres.add("Juan");
        nombres.add("dsfsdf");
        nombres.add("Jdfsdfuan");
        nombres.add("sdfsdf");

        // Mostrar lista
        System.out.println("Nombres: "+nombres);

        // Acceder a un elemento específico
        System.out.println("Primero de mi lista: "+nombres.get(0));

        // Modificar un elemento 
        nombres.set(1,"María");
        System.out.println("Lista modificada: "+nombres);


        // Eliminar un elemento
        nombres.remove(1);
        System.out.println("Despúes de eliminar: "+nombres);

        // Recorrer la lista
        System.out.println("Recorriendo todos los nombres: ");
        for(String nombre: nombres){
            System.out.println(nombre);
        }

        System.out.println("Llamando al procedimiento predecir futuro....");
        predecirFuturo("IPC1");

        System.out.println("Llamando a función operarTresNumeros....");
        System.out.println("Operando 3+5+6= "+operarTresNumeros(3, 5, 6));
    }


    public static void predecirFuturo(String curso){
        System.out.println("Todos los estudiantes del curso "+curso+ " aprobarán en laboratorio");
        System.out.println("Ganarán "+operarTresNumeros(59,1,1)+" estudiantes");

    }


    public static int operarTresNumeros(int a, int b, int c){
        return a+b+c;
    }

}
