package uvg.edu.gt;

import java.util.NoSuchElementException;
import java.util.Vector;

/**
 * Una implementación simple de un heap mínimo basado en un vector.
 * 
 * @param <E> El tipo de elementos almacenados en este heap.
 */
public class VectorHeap<E extends Comparable<E>> {

    private Vector<E> data; // Almacena los elementos del heap

    /**
     * Constructor que inicializa el vector que almacenará los elementos del heap.
     */
    public VectorHeap() {
        data = new Vector<>();
    }

    /**
     * Añade un elemento al heap.
     * 
     * @param item El elemento a añadir.
     */
    public void add(E item) {
        data.add(item); // Añade al final del vector
        percolateUp(data.size() - 1); // Reordena el heap
    }

    /**
     * Reordena el elemento en la posición i del vector hacia arriba para mantener
     * las propiedades del heap.
     * 
     * @param leaf La posición del elemento a reordenar.
     */
    private void percolateUp(int leaf) {
        int parent = (leaf - 1) / 2; // Encuentra el índice del padre
        E value = data.get(leaf); // El valor que percolará hacia arriba
        while (leaf > 0 && (value.compareTo(data.get(parent)) < 0)) {
            data.set(leaf, data.get(parent)); // Mueve el padre hacia abajo
            leaf = parent;
            parent = (parent - 1) / 2;
        }
        data.set(leaf, value);
    }

    /**
     * Elimina y devuelve el elemento con mayor prioridad (mínimo) del heap.
     * 
     * @return El elemento con mayor prioridad.
     */
    public E remove() {
        E minVal = data.get(0); // El mínimo está en la raíz
        data.set(0, data.get(data.size() - 1)); // Mueve el último al inicio
        data.setSize(data.size() - 1); // Disminuye el tamaño del vector
        if (!data.isEmpty()) {
            pushDownRoot(0); // Reordena el nuevo primer elemento
        }
        return minVal;
    }

    /**
     * Reordena el elemento en la raíz hacia abajo para mantener las propiedades del
     * heap.
     * 
     * @param root La posición de la raíz del subheap a reordenar.
     */
    private void pushDownRoot(int root) {
        int heapSize = data.size();
        E value = data.get(root); // Guarda el valor de la raíz
        while (root < heapSize) {
            int childpos = leftChild(root); // Empieza con el hijo izquierdo
            if (childpos < heapSize) {
                if ((rightChild(root) < heapSize) && (data.get(childpos + 1).compareTo(data.get(childpos)) < 0)) {
                    childpos++; // El derecho es menor que el izquierdo
                }
                // Si el valor más grande de los hijos es menor que el padre, se intercambian
                if (data.get(childpos).compareTo(value) < 0) {
                    data.set(root, data.get(childpos));
                    root = childpos; // Sigue hacia abajo
                } else { // Se encontró la posición correcta
                    data.set(root, value);
                    return;
                }
            } else { // No hay hijos
                data.set(root, value);
                return;
            }
        }
    }

    /**
     * Comprueba si el heap está vacío.
     * 
     * @return Verdadero si el heap está vacío, falso en caso contrario.
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * Devuelve la posición del hijo izquierdo de un nodo.
     * 
     * @param pos La posición del nodo padre.
     * @return La posición del hijo izquierdo.
     */
    private int leftChild(int pos) {
        return 2 * pos + 1;
    }

    /**
     * Devuelve la posición del hijo derecho de un nodo.
     * 
     * @param pos La posición del nodo padre.
     * @return La posición del hijo derecho.
     */
    private int rightChild(int pos) {
        return 2 * pos + 2;
    }

    /**
     * Devuelve, pero no elimina, el elemento de mayor prioridad (el mínimo) del
     * heap.
     * 
     * @return El elemento de mayor prioridad.
     */
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap está vacío");
        }
        return data.get(0);
    }

}
