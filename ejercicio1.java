//importamos las librerias de Scanner y Arrays
import java.util.Scanner;
import java.util.Arrays;


//declarar la clase principal y metodos donde se van a comparar las cedulas 
public class ejercicio1 {

    //metodo de ejecucion del programa 
    public static void main(String[] args) {
        //se crea un la terminal para leer los datos
        Scanner terminal = new Scanner(System.in);
        //Solicita un numero entero para almacenarlo en la variable n
        int n = leerCantidad(terminal);

        //Se crean los objetos de registro reprobados para las materiasal igual 
        // se leen los metodos donde recibe los 3 parametros (matematica,ingles y ambas)
        Registro_Reprobados matematica = leer_Reprobados(terminal, "Matematica", n);
        // (Se registra el segundo grupo de cédulas correspondiente a Inglés.)
        Registro_Reprobados ingles = leer_Reprobados(terminal, "Ingles", n);

        //Se almacena la informacion de los estudiantes que reprobaron ambas asignaturas
        String[] ambas = obtenerReprobadosEnAmbas(matematica, ingles);

        // Se imprime el título de resultados
        System.out.println("============= Resultados =============");
        // se imprime la lista de estudiantes reprobados de matematicas
        mostrarRegistro(matematica);
         // se imprime la lista de estudiantes reprobados de ingles
        mostrarRegistro(ingles);
         // se imprime la lista de estudiantes reprobados ambas materias
        System.out.println("Reprobaron ambas materias: " + Arrays.toString(ambas));

        // se termina el lector de entrada
        terminal.close();
    }

    //Este metodo pide la cantidad de estudiantes a registrar
    static int leerCantidad(Scanner terminal) {
        // (Se declara la variable que almacenará la cantidad de cédulas por asignatura.)
        int n;
        // se crea un ciclo para obtener un valor valido
        do {
            // se pide la cantidad de estudiantes que se van a registrar
            System.out.print("Por favor, ingrese la cantidad de estudiantes: ");
            // (nextInt lee el número entero que ingresa el usuario.)
            n = terminal.nextInt();

            //sentencia para verificar que el numero debe ser mayor a 0
            if (n <= 0) {
                System.out.println("La cantidad debe ser mayor a 0");
            }

        // (Se repite la solicitud mientras n sea menor o igual a cero.)
        } while (n <= 0);

        // Se devuelve la cantidad de estudiantes
        return n;
    }

    //Este metodo ayuda a registrar las cedulas de los estudiantes que reprobaron una asignatura.
    static Registro_Reprobados leer_Reprobados(Scanner terminal, String asignatura, int n) {
        // (Se crea un arreglo de tamaño n para almacenar las cédulas.)
        String[] cedulas = new String[n];

        // se da indicaciones de cual asignatura pertenece las cedulas
        System.out.println("============= Cedulas de estudiantes que reprobaron " + asignatura + " =============");

        // se crea un contador para recorrer las cedulas
        for (int i = 0; i < n; i++) {
            // se repite la cedula en caso de que no cuente con los 10 digitos
            do {
                // (Se muestra el número de la cédula que se está ingresando.)
                System.out.print("Cedula " + (i + 1) + ": ");
                // se almacena la cedula 
                cedulas[i] = terminal.next();

                //instacia que permite que la cedula contenga exactamente 10 numeros.
                if (!cedulas[i].matches("[0-9]{10}")) {
                    // se imprime un aviso en caso de que la cedula no tenga 10 digitos
                    System.out.println("Ingrese 10 digitos numericos.");
                }

            // se vuelve a pedir la cedula en caso de que no contenga los 10 digitos
            } while (!cedulas[i].matches("[0-9]{10}"));
        }

        //devuelve las cedulas registadas
        return new Registro_Reprobados(asignatura, cedulas);
    }

    //metodo en  el cual se realiza una comparacion de los estudiantes reprobados
    static String[] obtenerReprobadosEnAmbas(Registro_Reprobados primera, Registro_Reprobados segunda) {
        // Se guarda las cedulas con coincidencias 
        String[] resultado = new String[primera.cedulas.length];
        // contador de la cantidad de coinicidencias entre la materia de matematicas e ingles
        int cantidad = 0;

        // se revisa las cedulas que se registra en la asignatura de matematica
        for (String cedula : primera.cedulas) {
            // se revisa si hay alguna cedula repetida en la asignatura de ingles
            if (contiene(segunda.cedulas, segunda.cedulas.length, cedula)
                    && !contiene(resultado, cantidad, cedula)) {
                // se guardan las coincidencias de cedulas en ambas materias
                resultado[cantidad] = cedula;
                // se incrementa el numero de coincidencias.
                cantidad++;
            }
        }

        // se crea una lista de las coincidencias
        return Arrays.copyOf(resultado, cantidad);
    }

    // en este metodo se verifica 
    static boolean contiene(String[] arreglo, int elementosUsados, String buscada) {
        // (Se recorren únicamente los elementos ocupados del arreglo.)
        for (int i = 0; i < elementosUsados; i++) {
            // se compara el contenido de las cedulas
            if (arreglo[i].equals(buscada)) {
                // se devuelve en caso de que encuentre la cedula sea la buscada
                return true;
            }
        }

        // caso contrario no se devuelve 
        return false;
    }

    // se imprime las asignaturas reprobadas
    static void mostrarRegistro(Registro_Reprobados registro) {
        // se imprime todas la cedulas registradas
        System.out.println("Reprobaron " + registro.asignatura + ": "
                + Arrays.toString(registro.cedulas));
    }
}

// (Esta clase reúne el nombre de la asignatura con su arreglo de cédulas.)
class Registro_Reprobados {
    // se almacena el nombre de la materia 
    String asignatura;
    // se conservan las cedulas registradas
    String[] cedulas;

    // este contrctor recibe las asignatura y la cedula y crea el registro
    Registro_Reprobados(String asignatura, String[] cedulas) {
        // se asigna un nombre en este caso asignatura
        this.asignatura = asignatura;
        // se asigna un nombre en este caso cedula
        this.cedulas = cedulas;
    }
}