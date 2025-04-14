
import java.util.Iterator;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {

    // Inner class representing a node in the doubly linked list
    public class Node {
        T data;
        Node next, prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head; // first element
    private Node tail; // last element
    private int size = 0; // tracks number of elements

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            addFirst(element); // insert at head
        } else if (index == size) {
            addLast(element); // insert at tail
        } else {
            // insert in the middle
            Node current = head;
            for (int i = 0; i < index; i++) current = current.next;
            Node newNode = new Node(element);
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    @Override
    public void addFirst(T value) {
        Node newNode = new Node(value);
        if (head == null) {
            // list is empty
            head = tail = newNode;
        } else {
            // insert before head
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T value) {
        Node newNode = new Node(value);
        if (tail == null) {
            // list is empty
            head = tail = newNode;
        } else {
            // append after tail
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // Helper method to get node by index
    private Node getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node current;
        // optimization: start from head or tail depending on index
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current;
    }

    @Override
    public void set(int index, T element) {
        Node node = getNode(index);
        node.data = element;
    }

    @Override
    public T get(int index) {
        return getNode(index).data;
    }

    @Override
    public T getFirst() {
        return (head == null) ? null : head.data;
    }

    @Override
    public T getLast() {
        return (tail == null) ? null : tail.data;
    }

    @Override
    public void remove(int index) {
        Node node = getNode(index);
        // update surrounding nodes
        if (node.prev != null) node.prev.next = node.next;
        else head = node.next;

        if (node.next != null) node.next.prev = node.prev;
        else tail = node.prev;

        size--;
    }

    @Override
    public void removeFirst() {
        if (head == null) return;

        if (head == tail) {
            // only one element
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    @Override
    public void removeLast() {
        if (tail == null) return;

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    @Override
    public void sort() {
        if (size <= 1) return;

        // Convert to array for easier sorting
        Object[] arr = toArray();

        // Simple bubble sort
        for (int i = 0; i < size - 1; i++)
            for (int j = i + 1; j < size; j++) {
                T a = (T) arr[i];
                T b = (T) arr[j];
                if (a.compareTo(b) > 0) {
                    Object temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

        clear(); // clear list and rebuild in sorted order
        for (Object obj : arr) addLast((T) obj);
    }

    @Override
    public int indexOf(Object o) {
        int i = 0;
        for (Node current = head; current != null; current = current.next, i++) {
            if (o.equals(current.data)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int i = size - 1;
        for (Node current = tail; current != null; current = current.prev, i--) {
            if (o.equals(current.data)) return i;
        }
        return -1;
    }

    @Override
    public boolean exists(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        int i = 0;
        for (Node current = head; current != null; current = current.next) {
            arr[i++] = current.data;
        }
        return arr;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
