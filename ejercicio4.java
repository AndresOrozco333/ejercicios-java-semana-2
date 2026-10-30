// importamos las librerias random y scanner 
import java.util.Random;
import java.util.Scanner;

//creacion de la clase principal el cual va a contener todos los metodos e instrucciones
public class ejercicio4 {

    // se crea la case matriz para almacenar los numeros de las matrices
    static class Matriz {
        // se crea una matriz donde se guardaran los numeros enteros en 2 dimenciones
        int[][] datos;

        //este constructo permite asignar numeros a la matriz
        Matriz(int[][] datos) {
            // se almacena dentro del objeto
            this.datos = datos;
        }
        //nos permite saber cuantas filas hay en la matriz
        int filas() {
            // devuelve la cantidad de filas 
            return datos.length;
        }
        //nos permite saber cuantas columnas hay en la matriz 
        int columnas() {
            // se toma la primera fila con el fin de conocer cuantas columnas hay
            return datos[0].length;
        }
    }
    //instancia principal donde se ejecuta el codigo
    public static void main(String[] args) {
        //en este apartado la terminal sirve como vsriable para ingresar la informacion
        Scanner terminal = new Scanner(System.in);
        // se crea un generador de nuemros aleatorios con el fin dellenar matrices
        Random variable = new Random();

        // se declara m como la cantidad de filas 
        int m;
        // se repite en caso de que el valor no sea mayor a 0
        do {
            //Solicitamos la cantidad de filas que va a tener las matrices
            System.out.print("Ingrese el numero de filas: ");
            // (nextInt lee el número de filas introducido.)
            m = terminal.nextInt();
            //en caso de que la variable sea 0 se dara esta respuesta
            if (m <= 0) {
                System.out.println("ingrese un numero mayor a 0");
            }
        // se vuelve a empezar si el valor es menor o ingual a 0
        } while (m <= 0);

        // se declara n como la cantidad de columnas
        int n;
        //  se repite en caso de que el valor no sea mayor a 0
        do {
            //Solicitamos la cantidad de columnad que tendra las matrices
            System.out.print("Ingrese el numero de columnas: ");
            // se lee el numero de columnas
            n = terminal.nextInt();
            //igual que arriba en caso de que sea 0 imprimira el mensaje
            if (n <= 0) {
                System.out.println("ingrese un numero mayor a 0");
            }
        // se vuelve a empezar si el valor es menor o ingual a 0
        } while (n <= 0);
        //Se crea una las 2 matrices que utilizaremos en el ejerccicio
        Matriz a = generarMatriz(m, n, variable);
        // se crea otra matrices pero con otros numeros aleatorios
        Matriz b = generarMatriz(m, n, variable);

        // se imprime el nombre de la matriz A
        System.out.println("Matriz A:");
        // se imprime su contenido
        mostrarMatriz(a);

        // se imprime el nombre de la matriz B
        System.out.println("Matriz B:");
        // se imprime su contenido
        mostrarMatriz(b);
        //en esta parte donde creamos un menu para seleccionar la operacion a realizar entre las matrices
        int operacion_matematica;

        // mediante la instacia do-while se mantiene el menu activo hasta que elijan la opcion 0
        do {
            // (Se imprime el encabezado del menú de operaciones.)
            System.out.println("=========== Menu de operaciones ============");
            // (Se presenta la opción para sumar matrices.)
            System.out.println("1. Sumar A + B");
            // (Se presenta la opción para restar matrices.)
            System.out.println("2. Restar A - B");
            // (Se presenta la opción para multiplicar matrices.)
            System.out.println("3. Multiplicar A x B");
            // (Se presenta la opción para calcular transpuestas.)
            System.out.println("4. Trasponer A y B");
            // (Se presenta la opción para terminar.)
            System.out.println("0. Salir");
            // (Se solicita la elección del usuario.)
            System.out.print("Seleccione una operacion: ");

            // se almacena la opcion matematica seleccionada
            operacion_matematica = terminal.nextInt();
            //en esta parte se realizan las operaciones dependiendo de cada caso
            switch (operacion_matematica) {

                case 1:
                    //caso 1 se realiza la suma
                    System.out.println("Resultado A + B:");
                    // (Se llama a la suma de matrices y se imprime la matriz que retorna.)
                    mostrarMatriz(sumarMatrices(a, b));
                    // termina el caso de la suma
                    break;

                case 2:
                    // caso 2 se realiza una resta
                    System.out.println("Resultado A - B:");
                    // (Se llama a la resta de matrices y se imprime el resultado.)
                    mostrarMatriz(restarMatrices(a, b));
                    // termina el caso de la resta
                    break;

                case 3:
                    //caso 3 se realiza una multiplicacion siempre y cuando columnas y filas sea iguales
                    if (a.columnas() == b.filas()) {
                        System.out.println("Resultado A x B:");
                        // calcula el producto de las matrices y su resultado
                        mostrarMatriz(multiplicarMatrices(a, b));
                        //caso contrario no se podra realizar
                    } else {
                        System.out.println("No se pueden multiplicar las matrices");
                    }
                    // termina el caso de la multiplicacion
                    break;

                case 4:
                    // Caso 4 se realiza una traspocision
                    System.out.println("Transpuesta de A:");
                    // se calcula la traspuesta de la matriz A
                    mostrarMatriz(trasponerMatriz(a));

                    System.out.println("Transpuesta de B:");
                    // se calcula la traspuesta de la matriz B
                    mostrarMatriz(trasponerMatriz(b));
                    // termina el caso de la traspuesta
                    break;

                case 0:
                    //en caso que el usuario quiera terminar la ejecucion lo puedes hacer con este caso
                    System.out.println("Programa finalizado");
                    // termina el caso
                    break;

                default:
                    //en caso que el el usuario llegue a equivocarse (error en capa 8) con las opciones saldra este mensaje
                    System.out.println("Opcion invalida");
            }
            //mientras el valor de de las opciones no sea 0 se seguira ejecutando  
        } while (operacion_matematica != 0);

        // en caso de que se use la opcion 0 se finalizara el programa
        terminal.close();
    }
    //En este metodo es donde podemos crear las matrices y llenarla de numeros aleatorios
    static Matriz generarMatriz(int filas, int columnas, Random variable) {

        // se crea una matriz dependiendo el numero de filas y columnas
        int[][] datos = new int[filas][columnas];

        // la i recore las filas de la nueva matriz
        for (int i = 0; i < filas; i++) {
            // la j recore las columnas de cada fila
            for (int j = 0; j < columnas; j++) {
                // se producen los numeros aleatorios del 0 al 9
                datos[i][j] = variable.nextInt(10);
            }
        }

        // se devuelve un objeto matriz con los datos 
        return new Matriz(datos);
    }
    //Este metodo es el encargado de sumar las matrices 
    static Matriz sumarMatrices(Matriz a, Matriz b) {

        // la suma tendra el mismo numero de filas y columnas de A
        int[][] resultado = new int[a.filas()][a.columnas()];

        // se recorre cada fila de la matriz resultante
        for (int i = 0; i < a.filas(); i++) {
            // se recorre cada columna de la actual fila
            for (int j = 0; j < a.columnas(); j++) {
                // se suman los numeros ubicado en la misma posicion de A y B
                resultado[i][j] = a.datos[i][j] + b.datos[i][j];
            }
        }

        // se devuelve la matriz resultante
        return new Matriz(resultado);
    }
    //Este metodo es el encargado de restar las matrices
    static Matriz restarMatrices(Matriz a, Matriz b) {

        // se prepara las dimenciones de A y almacenarlas en la resta
        int[][] resultado = new int[a.filas()][a.columnas()];

        // se recorre cada fila para realizar la resta
        for (int i = 0; i < a.filas(); i++) {
            // Se recorre las columnas de la fila actual
            for (int j = 0; j < a.columnas(); j++) {
                // se resta el elemento b de la fila A corespondiente
                resultado[i][j] = a.datos[i][j] - b.datos[i][j];
            }
        }

        // se devuelve el resultado como una nueva matriz
        return new Matriz(resultado);
    }
    //Este metodo es el encargado de multiplacr las matrices
    static Matriz multiplicarMatrices(Matriz a, Matriz b) {

        // el producto se invertiran las filas de las columnas
        int[][] resultado = new int[a.filas()][b.columnas()];

        // se recorre las filas para realizar el producto
        for (int i = 0; i < a.filas(); i++) {
            // se recoren las columnas para realizar el producto
            for (int j = 0; j < b.columnas(); j++) {
                // el indice k recorre las pocisiones las cules e multiplicaran y sumaran
                for (int k = 0; k < a.columnas(); k++) {
                    // los productos parciales se añanden al resultado
                    resultado[i][j] += a.datos[i][k] * b.datos[k][j];
                }
            }
        }

        // se devuelve la matriz que contiene la multiplicacion
        return new Matriz(resultado);
    }
    //Este metodo nos da a conocer la traspuesta de la matriz
    static Matriz trasponerMatriz(Matriz original) {

        // se intercambian las dimenciones es decir las filas en columnas y viseversa
        int[][] resultado = new int[original.columnas()][original.filas()];

        // se recorren las filas de la matriz original
        for (int i = 0; i < original.filas(); i++) {
            // se recorren las columnas de la matriz original
            for (int j = 0; j < original.columnas(); j++) {
                // se intercambian las filas y las columnas(Se intercambian los índices de fila y columna para transponer.)
                resultado[j][i] = original.datos[i][j];
            }
        }

        // se devuelve el resultado de las transpocision
        return new Matriz(resultado);
    }
    //este metodo muestra los ejementos de la matriz de forma ordenada
    static void mostrarMatriz(Matriz matriz) {

        // se recorre cada fila que se almaceno en la matriz
        for (int[] fila : matriz.datos) {
            // se recorre cada numero de la fila 
            for (int valor : fila) {
                // se imprime el numero ocupando el numero que ocupa 5 espacios para la alineacion de columnas
                System.out.printf("%5d", valor);
            }
            // se pasa una nueva linea despues de imprimr la fila
            System.out.println();
        }
    }
}
