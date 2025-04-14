public class MyQueue<T extends Comparable<T>> {
    // Underlying linked list to store queue elements
    private MyLinkedList<T> list = new MyLinkedList<>();

    // Adds an element to the end of the queue
    public void enqueue(T element) {
        list.addLast(element);
    }

    // Removes and returns the first element from the queue
    public T dequeue() {
        if (isEmpty()) throw new IllegalArgumentException("Queue is empty");
        T element = list.getFirst();
        list.removeFirst();
        return element;
    }

    // Checks if the queue is empty
    public boolean isEmpty() {
        return list.size() == 0;
    }

    // Returns the number of elements in the queue
    public int size() {
        return list.size();
    }

    // Returns the first element without removing it
    public T peek() {
        return list.getFirst();
    }

    // Clears all elements from the queue
    public void clear() {
        list.clear();
    }

    // Returns a string representation of the queue
    public String toString() {
        return list.toString();
    }

    // Returns the first element of the queue (same as peek)
    public T front() {
        if (isEmpty()) throw new NullPointerException("Queue is empty");
        return list.getFirst();
    }
}