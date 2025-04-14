import java.util.Iterator;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] elements; // Array to store elements
    private int size; // Current number of elements

    public MyArrayList() {
        elements = new Object[10]; // Initial capacity
        size = 0;
    }

    // Ensures there's enough capacity in the array; doubles the size if full
    private void ensureCapacity() {
        if (size >= elements.length) {
            Object[] newArr = new Object[elements.length * 2];
            for (int i = 0; i < size; i++) {
                newArr[i] = elements[i];
            }
            elements = newArr;
        }
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        ensureCapacity(); // Make sure array has room
        // Shift elements to the right to make space at index
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = item;
        size++;
    }

    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        elements[index] = item; // Replaces element at index
    }

    @Override
    public void addFirst(T item) {
        add(0, item); // Adds at the beginning
    }

    @Override
    public void addLast(T item) {
        add(size, item); // Adds at the end
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return (T) elements[index]; // Retrieves element at index
    }

    @Override
    public T getFirst() {
        return get(0); // Gets first element
    }

    @Override
    public T getLast() {
        return get(size - 1); // Gets last element
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        // Shift elements left to fill removed spot
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--; // Decrease size
    }

    @Override
    public void removeFirst() {
        remove(0); // Remove first element
    }

    @Override
    public void removeLast() {
        remove(size - 1); // Remove last element
    }

    @Override
    public void sort() {
        // Selection sort in descending order using compareTo
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                T a = (T) elements[i];
                T b = (T) elements[j];
                if (a.compareTo(b) < 0) { // Swap if a < b
                    Object tmp = elements[i];
                    elements[i] = elements[j];
                    elements[j] = tmp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        // Returns index of first occurrence of object
        for (int i = 0; i < size; i++) {
            if (object.equals(elements[i])) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        // Returns index of last occurrence of object
        for (int i = size - 1; i >= 0; i--) {
            if (object.equals(elements[i])) return i;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        // Checks if object exists in array
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        // Returns raw array (unsafe cast just to mark as T[])
        for (int i = 0; i < size; i++) {
            elements[i] = (T) elements[i];
        }
        return elements;
    }

    @Override
    public void clear() {
        size = 0; // Just resets size; elements remain in memory
    }

    @Override
    public int size() {
        return size; // Returns current number of elements
    }

    @Override
    public Iterator<T> iterator() {
        // Iterator not implemented yet
        return null;
    }
}