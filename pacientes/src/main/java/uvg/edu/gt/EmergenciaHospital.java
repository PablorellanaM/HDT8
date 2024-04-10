package uvg.edu.gt;

import java.util.Scanner;

/**
 * Clase principal que proporciona un menú interactivo para manejar la cola de
 * pacientes en una emergencia hospitalaria.
 */
public class EmergenciaHospital {

    private VectorHeap<Paciente> colaPacientes;
    private Scanner scanner;

    /**
     * Constructor que inicializa la cola de prioridades de pacientes y el scanner
     * para entrada de datos.
     */
    public EmergenciaHospital() {
        colaPacientes = new VectorHeap<>();
        scanner = new Scanner(System.in);
    }

    /**
     * Muestra un menú interactivo para ingresar nuevos pacientes, mostrar el
     * siguiente paciente a atender o salir del programa.
     */
    public void mostrarMenu() {
        String opcion;
        do {
            System.out.println("\nMenú de Emergencias del Hospital:");
            System.out.println("1. Ingresar nuevo paciente");
            System.out.println("2. Mostrar siguiente paciente a atender");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    ingresarPaciente();
                    break;
                case "2":
                    mostrarSiguientePaciente();
                    break;
                case "3":
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        } while (!opcion.equals("3"));
    }

    /**
     * Permite al usuario ingresar la información de un nuevo paciente y lo añade a
     * la cola de prioridades.
     */
    private void ingresarPaciente() {
        System.out.print("Ingrese el nombre del paciente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la descripción del síntoma: ");
        String sintoma = scanner.nextLine();
        char codigoEmergencia;
        while (true) {
            System.out.print("Ingrese el código de emergencia (A-E): ");
            String input = scanner.nextLine().toUpperCase();
            if (input.length() == 1 && input.charAt(0) >= 'A' && input.charAt(0) <= 'E') {
                codigoEmergencia = input.charAt(0);
                break;
            } else {
                System.out.println("Código inválido. Debe ser una letra entre A y E.");
            }
        }

        Paciente nuevoPaciente = new Paciente(nombre, sintoma, codigoEmergencia);
        colaPacientes.add(nuevoPaciente);
        System.out.println("Paciente ingresado con éxito.");
    }

    /**
     * Muestra el siguiente paciente a atender según la prioridad y lo retira de la
     * cola.
     */
    private void mostrarSiguientePaciente() {
        if (!colaPacientes.isEmpty()) {
            Paciente siguiente = colaPacientes.remove();
            System.out.println("Siguiente paciente a atender:");
            System.out.println("Nombre: " + siguiente.getNombre());
            System.out.println("Síntoma: " + siguiente.getSintoma());
            System.out.println("Código de emergencia: " + siguiente.getCodigoEmergencia());
        } else {
            System.out.println("No hay pacientes en espera.");
        }
    }

    /**
     * El punto de entrada del programa. Crea una instancia de EmergenciaHospital y
     * muestra el menú.
     * 
     * @param args Argumentos de línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        EmergenciaHospital programa = new EmergenciaHospital();
        programa.mostrarMenu();
    }
}
