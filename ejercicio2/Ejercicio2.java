package ejercicio2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/** Ejercicio 2: búsqueda y procesamiento de un vector de 20 enteros. */
public class Ejercicio2 {
    public static void main(String[] args) {
        final int TAMANO = 20; // Define que el vector tendrá 20 elementos.
        int[] vector = new int[TAMANO]; // Crea el vector donde se guardarán los números.
        Random aleatorio = new Random(); // Permite generar números aleatorios.

        for (int i = 0; i < vector.length; i++) {
            vector[i] = aleatorio.nextInt(51); // Guarda valores aleatorios entre 0 y 50.
        }

        Scanner teclado = new Scanner(System.in); // Permite leer datos ingresados por el usuario.
        System.out.println("Vector original: " + Arrays.toString(vector));
        System.out.print("Ingrese un número para buscar: ");
        int buscado = teclado.nextInt();

        boolean encontrado = false; // Indica si el número buscado aparece en el vector.
        System.out.print("Posición(es) encontrada(s): ");
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == buscado) { // Compara cada elemento con el número buscado.
                System.out.print(i + " ");
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.print("ninguna");
        }
        System.out.println();

        int[] vectorImpares = new int[TAMANO / 2]; // Guarda los elementos de índices 1, 3, 5, etc.
        int posicion = 0;
        for (int i = 1; i < vector.length; i += 2) { // Recorre únicamente las posiciones impares.
            vectorImpares[posicion++] = vector[i];
        }
        System.out.println("Vector de índices impares: " + Arrays.toString(vectorImpares));

        int mayoresA20 = 0; // Contador de elementos mayores que 20.
        for (int valor : vectorImpares) {
            if (valor > 20) { // Verifica la condición solicitada.
                mayoresA20++;
            }
        }
        System.out.println("Elementos mayores que 20: " + mayoresA20);
        teclado.close(); 
    }
}
