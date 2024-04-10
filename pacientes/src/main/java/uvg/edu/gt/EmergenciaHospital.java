package uvg.edu.gt;

import java.util.Scanner;

public class EmergenciaHospital {

    private VectorHeap<Paciente> colaPacientes;
    private Scanner scanner;

    public EmergenciaHospital() {
        colaPacientes = new VectorHeap<>();
        scanner = new Scanner(System.in);
    }

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

    public static void main(String[] args) {
        EmergenciaHospital programa = new EmergenciaHospital();
        programa.mostrarMenu();
    }
}
