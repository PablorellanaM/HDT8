package uvg.edu.gt;

/**
 * Representa un paciente con nombre, síntoma y código de emergencia.
 */
public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private String sintoma;
    private char codigoEmergencia;

    /**
     * Crea un nuevo paciente con los detalles proporcionados.
     * 
     * @param nombre           Nombre del paciente.
     * @param sintoma          Descripción del síntoma del paciente.
     * @param codigoEmergencia Código de emergencia que indica la prioridad de
     *                         atención.
     */
    public Paciente(String nombre, String sintoma, char codigoEmergencia) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.codigoEmergencia = codigoEmergencia;
    }

    @Override
    public int compareTo(Paciente o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

}
