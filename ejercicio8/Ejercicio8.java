package ejercicio8;

import java.util.Scanner;

/** Ejercicio 8: cálculo del grado de eficiencia de operarios. */
public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in); // Permite leer los datos de cada operario.
        System.out.print("Número de operarios: ");
        int cantidad = leerPositivo(teclado);

        for (int i = 0; i < cantidad; i++) {
            System.out.println("\nOperario " + (i + 1));
            System.out.print("Código: ");
            int codigo = teclado.nextInt(); // Código que identifica al trabajador.
            System.out.print("Horas de ausencia: ");
            int ausencia = teclado.nextInt();
            System.out.print("Pupitres defectuosos: ");
            int defectuosos = teclado.nextInt();
            System.out.print("Pupitres producidos: ");
            int producidos = teclado.nextInt();

            // Evalúa las tres condiciones y obtiene el grado correspondiente.
            int grado = calcularGrado(ausencia <= 3, defectuosos < 300, producidos > 10000);
            System.out.println("Código: " + codigo);
            System.out.println("Horas de ausencia: " + ausencia);
            System.out.println("Pupitres defectuosos: " + defectuosos);
            System.out.println("Pupitres producidos: " + producidos);
            System.out.println("Grado de eficiencia: " + grado);
        }
        teclado.close();
    }

    // Convierte la combinación de condiciones cumplidas en el grado indicado.
    private static int calcularGrado(boolean condicion1, boolean condicion2, boolean condicion3) {
        // Se asigna un valor diferente a cada condición para identificar combinaciones.
        int condiciones = (condicion1 ? 1 : 0) + (condicion2 ? 2 : 0) + (condicion3 ? 4 : 0);
        switch (condiciones) { // Selecciona el grado según las condiciones cumplidas.
            case 0: return 5;
            case 1: return 7;
            case 2: return 8;
            case 4: return 9;
            case 3: return 12;
            case 5: return 13;
            case 6: return 15;
            case 7: return 20;
            default: return 5;
        }
    }

    private static int leerPositivo(Scanner teclado) {
        int valor;
        do {
            valor = teclado.nextInt();
            if (valor <= 0) {
                System.out.print("Ingrese un valor mayor que cero: ");
            }
        } while (valor <= 0);
        return valor;
    }
}
