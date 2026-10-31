package ejercicio3;

import java.util.Scanner;

/** Ejercicio 3: registro y búsqueda de empleados por código. */
public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in); // Lee la información desde el teclado.
        System.out.print("Ingrese la cantidad de empleados: ");
        int cantidad = leerEnteroPositivo(teclado);

        int[] codigos = new int[cantidad]; // Almacena los códigos de los empleados.
        String[] nombres = new String[cantidad]; // Almacena los nombres de los empleados.

        for (int i = 0; i < cantidad; i++) {
            System.out.println("\nEmpleado " + (i + 1));
            System.out.print("Código: ");
            codigos[i] = teclado.nextInt(); // Guarda el código del empleado.
            teclado.nextLine(); // Limpia el salto de línea pendiente.
            System.out.print("Nombre: ");
            nombres[i] = teclado.nextLine(); // Guarda el nombre completo.
        }

        System.out.print("\nIngrese el código que desea buscar: ");
        int codigoBuscado = teclado.nextInt();
        int indice = buscarEmpleado(codigos, codigoBuscado); // Busca la posición del código.

        if (indice >= 0) {
            System.out.println("Empleado encontrado: " + nombres[indice]);
        } else {
            System.out.println("No existe un empleado con ese código.");
        }
        teclado.close();
    }

    // Devuelve la posición del empleado o -1 si el código no existe.
    private static int buscarEmpleado(int[] codigos, int codigoBuscado) {
        for (int i = 0; i < codigos.length; i++) {
            if (codigos[i] == codigoBuscado) { // Compara el código actual con el buscado.
                return i;
            }
        }
        return -1;
    }

    private static int leerEnteroPositivo(Scanner teclado) {
        int valor;
        do {
            valor = teclado.nextInt();
            if (valor <= 0) {
                System.out.print("Debe ser mayor que cero. Intente otra vez: ");
            }
        } while (valor <= 0);
        return valor;
    }
}
