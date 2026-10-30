//importamos la libreria Scanner y Locale
import java.util.Scanner;
import java.util.Locale;

public class ejercicio7 {

    // NUmero de materias
    static final int Materias = 8;

    // Datos que se guardaran del estudiante
    static class Estudiante {
        //se declara la identificacion del estudiante
        String Id_estudiante; 
        // Se declara las notas del estudiante dependiendo delas materias
        double[] Notas_Estudiante = new double[Materias]; 
    }

    public static void main(String[] args) {
        //Se utiliza scanner para que el usuario pueda ingresar los datos
        Scanner terminal = new Scanner(System.in);
        //Se ingresa los datos como decimal
        terminal.useLocale(Locale.US);

        System.out.print("Numero de estudiantes: ");
        //pide al usuario la cantidad y la almacena en n
        int n = terminal.nextInt(); 
        //Se valida la cantidad sea mayor a 0
        if (n <= 0) { 
            //se imprime un mensaje indicando que la cantidad no es mayor a 0
            System.out.println("Cantidad incorrecta.");
            terminal.close();
            return;
        }

        Estudiante[] Grupo_Estudiantes = new Estudiante[n]; 
        //se registra las notas del estudiante
        registrar(terminal, Grupo_Estudiantes); 
        // se muestran los resultados
        mostrarResultados(Grupo_Estudiantes); 
        // se cierra los pedidos de datos
        terminal.close(); 
    }

    // Metodo para registrar estudiantes y calificaciones.
    static void registrar(Scanner terminal, Estudiante[] Grupo_Estudiantes) {

        for (int i = 0; i < Grupo_Estudiantes.length; i++) {
            //se crea un nuevo estudiante
            Grupo_Estudiantes[i] = new Estudiante(); 
            System.out.print("Id_estudiante del estudiante " + (i + 1) + ": ");
            // se guarda el identificador del estudiante
            Grupo_Estudiantes[i].Id_estudiante = terminal.next(); 

            for (int j = 0; j < Materias; j++) {
                System.out.print("Nota de la materia " + (j + 1) + ": ");
                // se gurda su nota
                Grupo_Estudiantes[i].Notas_Estudiante[j] = terminal.nextDouble(); 
            }
        }
    }

    // Esta funcion calcula y devuelve el promedio
    static double promedio(double[] Notas_Estudiante) {
        double suma = 0;

        for (double nota : Notas_Estudiante) {
            //se suman las calificaciones
            suma += nota; 
        }
        //Se devuelve un promedio
        return suma / Notas_Estudiante.length;
    }

    // Muestra el resultado de los estudiantes
    static void mostrarResultados(Estudiante[] Grupo_Estudiantes) {
        //muestra el mayor promedio
        double mayor = -1; 
        //muestra el identificador del mejor estudiante
        String mejor = ""; 
        //muestra cuntos aprobaron
        int aprobados = 0; 

        System.out.println("=========== Promedio del Estudiante ==========");

        for (Estudiante e : Grupo_Estudiantes) {
            //Calcula el promedio del estudiante
            double p = promedio(e.Notas_Estudiante);
            System.out.printf("%s: %.2f%n", e.Id_estudiante, p);
            //se encarga de buscar el mejor promedio
            if (p > mayor) {
                mayor = p;
                mejor = e.Id_estudiante;
            }
            //Cuenta cuantos aprobaron con un promedio mayor o igual a 7
            if (p >= 7) {
                aprobados++; 
            }
        }

        System.out.println("Promdedio de cada materia");

        for (int j = 0; j < Materias; j++) {
            //se reinicia la suma
            double suma = 0; 

            for (Estudiante e : Grupo_Estudiantes) {
                //Se suma las notas de la materia
                suma += e.Notas_Estudiante[j]; 
            }

            System.out.printf("Materia %d: %.2f%n",
                    j + 1, suma / Grupo_Estudiantes.length);
        }

        // Se imprime los resultados finales
        System.out.printf("Mejor estudiante: %s (%.2f)%n",
                mejor, mayor);

        System.out.println("Aprobados: " + aprobados);
        System.out.println("Reprobados: " + (Grupo_Estudiantes.length - aprobados));
    }
}
