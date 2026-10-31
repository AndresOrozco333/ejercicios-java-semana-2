package ejercicio6;

import java.util.Locale;
import java.util.Scanner;

/** Ejercicio 6: ventas por vendedor, por año y total general. */
public class Ejercicio6 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner teclado = new Scanner(System.in); // Permite ingresar las dimensiones y ventas.
        System.out.print("Número de vendedores: ");
        int vendedores = leerPositivo(teclado);
        System.out.print("Número de años: ");
        int anos = leerPositivo(teclado)

        double[][] ventas = new double[vendedores][anos]; // Matriz: filas=vendedores, columnas=años.
        for (int vendedor = 0; vendedor < vendedores; vendedor++) {
            for (int ano = 0; ano < anos; ano++) {
                System.out.printf("Ventas del vendedor %d en el año %d: ", vendedor + 1, ano + 1);
                ventas[vendedor][ano] = teclado.nextDouble(); // Guarda la venta correspondiente.
            }
        }

        double totalEmpresa = 0; // Acumula todas las ventas de la empresa.
        System.out.println("\nTotal de ventas por vendedor:");
        for (int vendedor = 0; vendedor < vendedores; vendedor++) {
            double totalVendedor = 0; // Acumula las ventas de un vendedor.
            for (int ano = 0; ano < anos; ano++) {
                totalVendedor += ventas[vendedor][ano]; // Suma las ventas de cada año.
            }
            totalEmpresa += totalVendedor;
            System.out.printf("Vendedor %d: %.2f%n", vendedor + 1, totalVendedor);
        }

        System.out.println("\nTotal de ventas por año:");
        for (int ano = 0; ano < anos; ano++) {
            double totalAno = 0; // Acumula las ventas de un año.
            for (int vendedor = 0; vendedor < vendedores; vendedor++) {
                totalAno += ventas[vendedor][ano]; // Suma las ventas de todos los vendedores.
            }
            System.out.printf("Año %d: %.2f%n", ano + 1, totalAno);
        }
        System.out.printf("\nTotal de ventas de la empresa: %.2f%n", totalEmpresa);
        teclado.close();
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
