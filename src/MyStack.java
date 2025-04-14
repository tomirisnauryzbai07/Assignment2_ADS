public class MyStack<T extends Comparable<T>> {

    // Underlying list to store stack elements
    private MyArrayList<T> list = new MyArrayList<>();

    // Pushes an element onto the stack
    public void push(T element) {
        list.addLast(element);
    }

    // Removes and returns the top element of the stack
    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        T element = list.getLast();
        list.removeLast();
        return element;
    }

    // Returns the top element without removing it
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return list.getLast();
    }

    // Returns true if the stack is empty
    public boolean isEmpty() {
        return list.size() == 0;
    }

    // Returns the number of elements in the stack
    public int size() {
        return list.size();
    }
}