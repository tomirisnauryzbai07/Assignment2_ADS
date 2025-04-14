Custom Data Structures in Java This project contains custom implementations of various fundamental data structures in Java, including MyArrayList, MyLinkedList, MyStack, MyQueue, and MyMinHeap. These implementations provide a deeper understanding of how these structures work and are optimized for educational purposes. The goal of this project is to offer a hands-on experience of working with data structures and implementing them from scratch.
Data Structures
	1	MyArrayList
A custom implementation of an ArrayList with basic operations such as: • addFirst(T element) – Adds an element to the beginning. • addLast(T element) – Adds an element to the end. • get(int index) – Retrieves an element at a given index. • set(int index, T element) – Updates an element at a given index. • remove(int index) – Removes the element at the specified index. • removeFirst() – Removes the first element. • removeLast() – Removes the last element. • size() – Returns the number of elements in the list. • clear() – Clears all elements from the list.
	2	MyLinkedList
A custom doubly linked list implementation that supports the following operations: • addFirst(T element) – Adds an element at the beginning. • addLast(T element) – Adds an element at the end. • getFirst() – Retrieves the first element. • getLast() – Retrieves the last element. • removeFirst() – Removes the first element. • removeLast() – Removes the last element. • size() – Returns the current size of the list.
	3	MyStack
A custom stack implementation with the following methods: • push(T element) – Pushes an element onto the stack. • pop() – Pops the top element from the stack. • peek() – Retrieves the top element without removing it. • isEmpty() – Checks if the stack is empty. • size() – Returns the current size of the stack.
	4	MyQueue
A custom queue implementation with these methods: • enqueue(T element) – Adds an element to the end of the queue. • dequeue() – Removes and returns the element from the front of the queue. • front() – Returns the front element without removing it. • isEmpty() – Checks if the queue is empty. • size() – Returns the current size of the queue.
	5	MyMinHeap
A custom implementation of a Min-Heap with the following methods: • add(T element) – Adds an element to the heap and ensures the heap property is maintained. • extractMin() – Extracts the minimum element from the heap. • peek() – Retrieves the minimum element without removing it. • isEmpty() – Checks if the heap is empty. • size() – Returns the size of the heap.
Features • Generic classes that can store any type of object that implements the Comparable interface. • Efficient implementations for common data structure operations. • Suitable for educational purposes to understand data structures at a deeper level.
Usage Example
Below is an example of how to use each of the data structures:
public class Main { public static void main(String[] args) { // MyArrayList Test MyArrayList myArrayList = new MyArrayList<>(); myArrayList.addLast(10); myArrayList.addLast(20); System.out.println("ArrayList get(0): " + myArrayList.get(0)); // Output: 10
    // MyStack Test
    MyStack<Integer> myStack = new MyStack<>();
    myStack.push(100);
    System.out.println("Stack pop: " + myStack.pop()); // Output: 100

    // MyQueue Test
    MyQueue<Integer> myQueue = new MyQueue<>();
    myQueue.enqueue(50);
    System.out.println("Queue dequeue: " + myQueue.dequeue()); // Output: 50

    // MyMinHeap Test
    MyMinHeap<Integer> myMinHeap = new MyMinHeap<>();
    myMinHeap.add(3);
    myMinHeap.add(5);
    System.out.println("MinHeap peek: " + myMinHeap.peek()); // Output: 3
