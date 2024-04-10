package uvg.edu.gt;

import java.util.Vector;

/**
 * Implementación de una cola con prioridad utilizando un heap binario.
 */
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    private Vector<E> data;

    public VectorHeap() {
        data = new Vector<E>();
    }

}
