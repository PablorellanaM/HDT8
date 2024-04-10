package uvg.edu.gt;

/**
 * Representa un paciente con nombre, síntoma y código de emergencia.
 */
public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private String sintoma;
    private char codigoEmergencia;

    /**
     * Constructor para crear un nuevo paciente.
     * 
     * @param nombre           Nombre del paciente.
     * @param sintoma          Síntoma del paciente.
     * @param codigoEmergencia Código de emergencia que determina la prioridad de
     *                         atención.
     */
    public Paciente(String nombre, String sintoma, char codigoEmergencia) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.codigoEmergencia = codigoEmergencia;
    }

    /**
     * Compara este paciente con otro paciente para determinar la prioridad en la
     * cola.
     * 
     * @param otro El paciente con el que se compara.
     * @return Un valor negativo si este paciente tiene mayor prioridad, cero si es
     *         la misma, o un valor positivo si es menor.
     */
    @Override
    public int compareTo(Paciente otro) {
        return Character.compare(this.codigoEmergencia, otro.codigoEmergencia);
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getSintoma() {
        return sintoma;
    }

    public char getCodigoEmergencia() {
        return codigoEmergencia;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    public void setCodigoEmergencia(char codigoEmergencia) {
        this.codigoEmergencia = codigoEmergencia;
    }
}
