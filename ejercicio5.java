//importamos la libreria Scanner y Locale
import java.util.Scanner;
import java.util.Locale;
//clase principal donde se encuentran todos los metodos y clases a utilizar 
public class ejercicio5 {

    // Definimos los datos de precios y cantidades 
    static class DatosVentas {
        // guardamos el dato de precios como double ya que vamos a usar decimales
        double[][] precios;
        // guardamos el dato de cantidad_vendida como entero
        int[][] Cantidad_Vendida;

        // este constructor resibira los valores de articulos y sucursales
        DatosVentas(int n, int m) {
            // se crea una matriz para contener en n los articulos y en m las sucursales
            precios = new double[n][m];
            // se crea esta matriz para contener los valores de los valores de cada sucursal
            Cantidad_Vendida = new int[n][m];
        }
    }

    //clase principal que se usara para ejecutar el codigo 
    public static void main(String[] args) {
        // Se crea un lector para recibir los datos 
        Scanner terminal = new Scanner(System.in);
        // se usa locale.us para los valores en decimales 
        terminal.useLocale(Locale.US);
        //se pide el numero de articulos
        System.out.print("Numero de articulos: ");
        //pide a usuario un valor de articulos
        int n = terminal.nextInt();
        //se pide el numero de sucursales
        System.out.print("Numero de sucursales: ");
        //pide al usuario un valor de sucursales
        int m = terminal.nextInt();
        //Se valida si el usuario ingrso numeros mayores a 0, 
        // en caso que sea menor o igual a 0 terminal el programa
        if (n <= 0 || m <= 0) {
            System.out.println("Ingrese cantidades mayores a 0.");
            // se termina la entrada en caso de que los datos sean invalidos.
            terminal.close();
            // se retorna para evitar dimenciones incorrectas
            return;
        }
        //es un objeto que contiene las matrices de los valores ingresados
        DatosVentas datos = new DatosVentas(n, m);
        //este metodo solicita y guarda los datos tanto de precios de los articulos como los articulos vendidos
        registrarVentas(terminal, datos);
        //este metodo calcula y muestra los resultados de las ventas 
        mostrarReporte(datos);
        //cuando ya no nesecitamo los datos este nos ayuda a terminar la entrada de datos
        terminal.close();
    }

    // Funcion donde se registra los precios y la cantidades vendidas
    static void registrarVentas(Scanner terminal, DatosVentas datos) {
        //esta parte del codigo nos ayuda a avnzar las filas al momento de llenar los datos
        for (int i = 0; i < datos.precios.length; i++) {
            //en cambio este nos ayuda a avanzar las columnas a medida que llenemos los datos
            for (int j = 0; j < datos.precios[i].length; j++) {
                //Registro de los precios y cantidades empezando desde la 
                // sucursal 0 y en caso de que sea negativo se repite
                do {
                    System.out.print("Precio articulo " + (i + 1)
                            + " sucursal " + (j + 1) + ": ");
                    // se lee y se almacena el precio del articulo de la sucursal
                    datos.precios[i][j] = terminal.nextDouble();
                    // (Se comprueba si el precio es negativo.)
                    if (datos.precios[i][j] < 0) {
                        // se imprime un aviso para corregir el precio 
                        System.out.println("El precio no puede ser negativo.");
                    }
                //En esta parte solo acepta valores mayores o iguales a 0    
                } while (datos.precios[i][j] < 0); 
                //En caso de que el valor sea negativo se repetira el proceso
                do {
                    System.out.print("Cantidad vendida: ");
                    // Se lee y se guarda la cantidad vendida
                    datos.Cantidad_Vendida[i][j] = terminal.nextInt();
                    // Se valida si la cantidad vendida es negativa
                    if (datos.Cantidad_Vendida[i][j] < 0) {
                        // Se da a conocer que no se puede registrar cantidades negativas
                        System.out.println("La cantidad vendida no puede ser negativa.");
                    }
                //Se puede aceptar 0 o mas cantidades vendidas
                } while (datos.Cantidad_Vendida[i][j] < 0);
            }
        }
    }

    // Funcion con parametros de retorno del valor
    static double calcularVenta(double precio, int cantidad) {
        // (Se devuelve el ingreso obtenido al multiplicar precio por cantidad.)
        return precio * cantidad;
    }

    // En esta funcion se procesa los datos y se precenta los totales 
    static void mostrarReporte(DatosVentas datos) {

        // se obtine el valor a partir del numero de filas en el apartado de precios
        int n = datos.precios.length;
        // se optine el valor a partir de las columnas del apartado de precios
        int m = datos.precios[0].length;

        // Se acumula el dinero vendido de los articulos
        double[] Total_Articulo = new double[n];
        // se acumula el dinero vendido de cada sucursal
        double[] Total_Sucursal = new double[m];

        // se acumula las unidades vendidas de cada artuiculo
        int[] Unidades_Articulo = new int[n];
        // se acumula las unidades vendidas de cada sucursal
        int[] Unidades_Sucursal = new int[m];

        // Se instancia el valor inicial de todas las ventas 
        double Total_General = 0;

        // i recorre los articulos registrados
        for (int i = 0; i < n; i++) {
            // j recorre las sucursales de cada articulo
            for (int j = 0; j < m; j++) {

                // toma los datos de la cantidad vendida de los aticulos y las sucursales
                int cantidad = datos.Cantidad_Vendida[i][j];

                // Se calcula el dinero vendido por el precio 
                double venta = calcularVenta(
                        datos.precios[i][j], cantidad);
                // en esta parte se suman los valores a los que ya existe de los articulos
                Total_Articulo[i] += venta;
                // en esta parte se suman los valores a los que ya existe del total de la sucursal
                Total_Sucursal[j] += venta;
                // en esta parte se suman los valores a los que ya existe de las unidades acumuladas de los articulos
                Unidades_Articulo[i] += cantidad;
                // en esta parte se suman los valores a los que ya existe de las unidades acumuladas de la sucursal
                Unidades_Sucursal[j] += cantidad;
                // Se añade el ingreso al total general
                Total_General += venta;
            }
        }
        //Se muestra los resultados por cada articulo
        System.out.println("============ Productos vendidos por articulo ============");
        // se imprime los totales de todos los articulos y sus totales
        for (int i = 0; i < n; i++) {
            // se muestra los valores entero y de los articulos y los valores en decimales
            System.out.printf(Locale.US,
                    "Articulo %d: %d unidades - $%.2f%n",
                    i + 1, Unidades_Articulo[i], Total_Articulo[i]);
        }
        //muestra los rersultados por cada sucursal
        System.out.println("============== Unidades vendidades por sucursal =============");
        // se imprime las sucursales y sus totales
        for (int j = 0; j < m; j++) {
            // se imprime las unidades vendidas y el dinero generado de cada sucursal
            System.out.printf(Locale.US,
                    "Sucursal %d: %d unidades - $%.2f%n",
                    j + 1, Unidades_Sucursal[j], Total_Sucursal[j]);
        }
        //Se muestra el valor general de las ventas en todas las sucursales
        System.out.printf(Locale.US,
                "Total en General: $%.2f%n", Total_General);
    }
}
