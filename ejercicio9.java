//importamos la libreria Scanner y Locale
import java.util.Scanner;
import java.util.Locale;

public class ejercicio9 {

    // Tipo de datos para guardar medicamentos.
    static class Medicamento {
        //se declara el nombre, stock, cantidad minima del medicamente y su precio
        String nombre; 
        int stock; 
        int Cantidad_Minima;  
        double precio; 
    }

    public static void main(String[] args) {
        //Se utiliza scanner para que el usuario pueda ingresar los datos
        Scanner terminal = new Scanner(System.in); 
        //Se ingresa los datos como decimal
        terminal.useLocale(Locale.US);

        System.out.print("Cantidad de medicamentos: ");
        //pide al usuario ingresar la cantidad de medicamentos
        int n = terminal.nextInt(); 

        if (n <= 0) { 
            //valida si la cantidad es mayor o igual a 0
            System.out.println("Cantidad incorrecta.");
            terminal.close();
            return;
        }
        // va a la siguiente linea
        terminal.nextLine(); 
        Medicamento[] Lista_Medicamentos = new Medicamento[n];
        //se registra los medicamentos
        registrar(terminal, Lista_Medicamentos);
        // se muestra si el stock esta bajo
        mostrarBajoCantidad_Minima(Lista_Medicamentos);

        // se muestra el valor economico inicial
        System.out.printf("Valor inicial: $%.2f%n",
                calcularTotal(Lista_Medicamentos));
        //en caso de vender se actualiza el stock
        vender(terminal, Lista_Medicamentos); 
        //se muesttra un reporte general de los medicamentos
        mostrarReporte(Lista_Medicamentos); 
        //cierra el lector
        terminal.close(); 
    }

    // Metodo para registrar medicamentos.
    static void registrar(Scanner terminal, Medicamento[] Lista_Medicamentos) {

        for (int i = 0; i < Lista_Medicamentos.length; i++) {
            //se crea un medicamento
            Lista_Medicamentos[i] = new Medicamento(); 

            System.out.println("\nMedicamento " + (i + 1));

            System.out.print("Nombre: ");
            //guarda el nombre
            Lista_Medicamentos[i].nombre = terminal.nextLine(); 
            System.out.print("Stock actual: ");
            // Guarda el stock disponible
            Lista_Medicamentos[i].stock = terminal.nextInt(); 

            System.out.print("Stock Cantidad_Minima: ");
            //Guarda la cantidad minima que debe haber en la farmacia
            Lista_Medicamentos[i].Cantidad_Minima = terminal.nextInt(); 

            System.out.print("Precio unitario: ");
            //guarda el precio del medicamento
            Lista_Medicamentos[i].precio = terminal.nextDouble(); 
            //una ves terminado los datos salta a la siguiente linea
            terminal.nextLine(); 
        }
    }

    // este mtdodo muestra los medicamentos que tienen bajo stock
    static void mostrarBajoCantidad_Minima(Medicamento[] Lista_Medicamentos) {
        System.out.println("Medicamentos con stock inferior al minimo");
        //contraloa los resultados
        boolean Stock_inferior = false; 

        for (Medicamento m : Lista_Medicamentos) {
            //compara si hay stock suficiente para vender
            if (m.stock < m.Cantidad_Minima) { 
                System.out.println(m.nombre + ": " + m.stock + " Unidades_a_vender");
                // el stock es bajo al minimo
                Stock_inferior = true; 
            }
        }

        if (!Stock_inferior) {
            System.out.println("Ninguno.");
        }
    }

    // esta funcion calcula y devuelve el valor total
    static double calcularTotal(Medicamento[] Lista_Medicamentos) {
        //acumula el total
        double total = 0; 

        for (Medicamento m : Lista_Medicamentos) {
            // suma los precios de los medicamentos
            total += m.stock * m.precio; 
        }
        //devuelve el total
        return total; 
    }

    // en este metodo se registran las ventas de los medicamentos
    static void vender(Scanner terminal, Medicamento[] Lista_Medicamentos) {
        System.out.println("Registrar venta");

        for (int i = 0; i < Lista_Medicamentos.length; i++) {
            System.out.println((i + 1) + ". " + Lista_Medicamentos[i].nombre);
        }

        System.out.print("Numero del medicamento, en caso de omitir precione 0: ");
        //elegimos el medicamento
        int numero = terminal.nextInt(); 
        //en caso de que el numero elejido sea 0 se omite la venta
        if (numero == 0) {
            return; 
        }
        //en caso de que el numero del medicamento sea incorrecto a la lista se cancela la venta
        if (numero < 1 || numero > Lista_Medicamentos.length) {
            System.out.println("Medicamento incorrecto.");
            return; 
        }
        //En esta parte se selecciona el medicamento seleccionado
        Medicamento m = Lista_Medicamentos[numero - 1]; 
        //Se pide una cantidad que se va a vender
        System.out.print("Unidades_a_vender a vender: ");
        int Unidades_a_vender = terminal.nextInt(); 
        //en caso de que las unidades a vender sean meno o igual a 0 o no hay disponivilidad no se realiza la venta
        if (Unidades_a_vender <= 0 || Unidades_a_vender > m.stock) {
            System.out.println("Cantidad incorrecta o stock insuficiente.");
            return;
        }
        // si se llega a vender se descuenta del stock
        m.stock -= Unidades_a_vender; 

        System.out.println("Venta realizada. Stock restante: " + m.stock);
    }

    // se muestra un reporte general de cada mdicamento
    static void mostrarReporte(Medicamento[] Lista_Medicamentos) {
        System.out.println("=========Reporte General===========");

        for (Medicamento m : Lista_Medicamentos) {

            // muestra los datos y el subtotal de la medicina.
            System.out.printf(
                "%s | Stock: %d | Cantidad_Minima: %d | Precio: $%.2f | Subtotal: $%.2f%n",
                m.nombre, m.stock, m.Cantidad_Minima,
                m.precio, m.stock * m.precio
            );
        }

        // Muestra el valor total 
        System.out.printf("Valor Total: $%.2f%n",
                calcularTotal(Lista_Medicamentos));
    }
}
