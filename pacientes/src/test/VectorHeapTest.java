package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Clase de prueba para VectorHeap.
 */
public class VectorHeapTest {

    /**
     * Prueba que verifica que los elementos se añaden correctamente y mantienen el
     * orden de prioridad.
     */
    @Test
    public void testAdd() {
        VectorHeap<Paciente> heap = new VectorHeap<>();
        heap.add(new Paciente("Juan Perez", "Fractura de pierna", 'C'));
        heap.add(new Paciente("Maria Ramirez", "Apendicitis", 'A'));

        assertEquals('A', heap.peek().getCodigoEmergencia(), "El paciente con mayor prioridad debe ser 'A'");
    }

    /**
     * Prueba que verifica que el elemento con la mayor prioridad se remueva
     * primero.
     */
    @Test
    public void testRemove() {
        VectorHeap<Paciente> heap = new VectorHeap<>();
        Paciente pacienteA = new Paciente("Maria Ramirez", "Apendicitis", 'A');
        Paciente pacienteB = new Paciente("Juan Perez", "Fractura de pierna", 'C');

        heap.add(pacienteB);
        heap.add(pacienteA);
        Paciente result = heap.remove();

        assertEquals(pacienteA, result, "El paciente removido debe ser el de mayor prioridad (A)");
    }

}
