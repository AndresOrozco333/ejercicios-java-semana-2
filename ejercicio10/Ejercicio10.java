package ejercicio10;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/** Ejercicio 10: registro y cálculo de pedidos de un restaurante. */
public class Ejercicio10 {
    private static class Pedido {
        String cliente; // Nombre de la persona que realiza el pedido.
        String plato; // Plato solicitado.
        int cantidad; // Número de unidades solicitadas.
        double precioUnitario; // Precio de una unidad del plato.

        Pedido(String cliente, String plato, int cantidad, double precioUnitario) {
            this.cliente = cliente;
            this.plato = plato;
            this.cantidad = cantidad;
            this.precioUnitario = precioUnitario;
        }

        double subtotal() {
            return cantidad * precioUnitario; // Multiplica cantidad por precio unitario.
        }

        double total() {
            double subtotal = subtotal();
            return subtotal > 50 ? subtotal * 0.90 : subtotal; // Aplica 10% de descuento si supera $50.
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner teclado = new Scanner(System.in); // Lee los datos ingresados por el usuario.
        List<Pedido> pedidos = new ArrayList<>(); // Lista que almacenará todos los pedidos.
        System.out.print("Número de pedidos: ");
        int cantidad = leerPositivo(teclado);

        for (int i = 0; i < cantidad; i++) {
            System.out.println("\nPedido " + (i + 1));
            teclado.nextLine();
            System.out.print("Nombre del cliente: ");
            String cliente = teclado.nextLine();
            System.out.print("Plato solicitado: ");
            String plato = teclado.nextLine();
            System.out.print("Cantidad: ");
            int unidades = teclado.nextInt();
            System.out.print("Precio unitario: ");
            double precio = teclado.nextDouble();
            pedidos.add(new Pedido(cliente, plato, unidades, precio)); // Agrega el pedido a la lista.
        }

        double ingresoTotal = 0; // Acumula el ingreso de todos los pedidos.
        Pedido mayor = pedidos.get(0); // Inicialmente, el primer pedido es el mayor.
        System.out.println("\nDetalle de pedidos:");
        for (Pedido pedido : pedidos) {
            ingresoTotal += pedido.total(); // Suma el total del pedido al ingreso general.
            if (pedido.total() > mayor.total()) { // Compara para encontrar el pedido mayor.
                mayor = pedido; // Actualiza el pedido de mayor valor.
            }
            System.out.printf("Cliente: %s | Plato: %s | Subtotal: $%.2f | Total: $%.2f%n",
                    pedido.cliente, pedido.plato, pedido.subtotal(), pedido.total());
        }
        System.out.printf("\nIngreso total del restaurante: $%.2f%n", ingresoTotal);
        System.out.printf("Pedido de mayor valor: %s - %s ($%.2f)%n",
                mayor.cliente, mayor.plato, mayor.total());
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
