package uvg.edu.gt;

import java.util.Vector;

/**
 * Implementación de una cola con prioridad utilizando un heap binario.
 */
public class VectorHeap<E extends Comparable<E>> {
    private Vector<E> data;

    public VectorHeap() {
        data = new Vector<E>();
    }

    public void add(E item) {

    }

    public E remove() {

        return null;
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

}
