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

    /**
     * Compara este paciente con otro para determinar la prioridad en la cola.
     * 
     * @param otro El paciente con el que comparar.
     * @return Un valor negativo si este paciente tiene mayor prioridad, cero si es
     *         la misma prioridad, o un valor positivo si tiene menor prioridad.
     */
    @Override
    public int compareTo(Paciente otro) {
        return Character.compare(this.codigoEmergencia, otro.codigoEmergencia);
    }

    public String getNombre() {
        return nombre;
    }

    public String getSintoma() {
        return sintoma;
    }

    public char getCodigoEmergencia() {
        return codigoEmergencia;
    }
}
