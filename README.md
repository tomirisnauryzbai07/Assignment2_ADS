public class Main {
    public static void main(String[] args) {
        // ---------- Test MyArrayList ----------
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.addLast(10);
        arrayList.addLast(20);
        arrayList.addFirst(5);
        arrayList.set(1, 15);
        System.out.println("ArrayList get(0): " + arrayList.get(0)); // 5
        System.out.println("ArrayList get(1): " + arrayList.get(1)); // 15
        System.out.println("ArrayList size: " + arrayList.size());   // 3
        arrayList.remove(1);
        System.out.println("After remove(1), size: " + arrayList.size()); // 2
        arrayList.add(1, 25); // Add at index 1
        System.out.println("ArrayList get(1) after add(1, 25): " + arrayList.get(1)); // 25
        System.out.println();

        // ---------- Test MyLinkedList ----------
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addLast(10);
        linkedList.addFirst(5);
        linkedList.addLast(20);

        System.out.println("LinkedList getFirst: " + linkedList.getFirst()); // 5
        System.out.println("LinkedList getLast: " + linkedList.getLast());   // 20
        linkedList.removeFirst();
        System.out.println("LinkedList getFirst after removeFirst: " + linkedList.getFirst()); // 10
        linkedList.removeLast();
        System.out.println("LinkedList getLast after removeLast: " + linkedList.getLast()); // 10
        System.out.println();

        // ---------- Test MyStack ----------
        MyStack<Integer> stack = new MyStack<>();
        stack.push(100);
        stack.push(200);
        System.out.println("Stack pop: " + stack.pop()); // 200
        System.out.println("Stack peek: " + stack.peek()); // 100
        stack.pop(); // Now stack is empty
        // System.out.println("Stack pop from empty: " + stack.pop()); // Uncomment to test error handling
        System.out.println();

        // ---------- Test MyQueue ----------
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(50);
        queue.enqueue(100);

        System.out.println("Queue dequeue: " + queue.dequeue()); // 50
        System.out.println("Queue front: " + queue.front()); // 100
        // queue.dequeue(); // Uncomment to test queue being empty
        // System.out.println("Queue dequeue from empty: " + queue.dequeue()); // Uncomment to test error handling

        // ---------- Test MyMinHeap ----------
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.add(5);
        heap.add(3);
        heap.add(8);
        System.out.println("MinHeap peek: " + heap.peek()); // 3
        System.out.println("MinHeap extractMin: " + heap.extractMin()); // 3
        System.out.println("MinHeap peek after extractMin: " + heap.peek()); // 5
    }
}
