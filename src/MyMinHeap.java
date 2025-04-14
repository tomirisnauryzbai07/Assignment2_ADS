public class MyMinHeap<T extends Comparable<T>> {
    // Underlying list to represent the heap
    private MyArrayList<T> heap = new MyArrayList<>();

    // Adds an element to the heap and restores the heap property
    public void add(T element) {
        heap.addLast(element);
        heapifyUp(heap.size() - 1); // Heapify up from the last element
    }

    // Removes and returns the minimum element (root) from the heap
    public T extractMin() {
        if (heap.size() == 0) throw new IllegalStateException("Heap is empty");
        T min = heap.get(0);  // Get the root (minimum element)
        heap.set(0, heap.get(heap.size() - 1));  // Replace root with last element
        heap.removeLast();  // Remove the last element
        heapifyDown(0);  // Restore the heap property
        return min;
    }

    // Returns the minimum element without removing it
    public T peek() {
        return heap.get(0);
    }

    // Checks if the heap is empty
    public boolean isEmpty() {
        return heap.size() == 0;
    }

    // Returns the number of elements in the heap
    public int size() {
        return heap.size();
    }

    // Moves the element at index i upwards to restore heap property
    private void heapifyUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;  // Get the parent index
            if (heap.get(i).compareTo(heap.get(parent)) < 0) {  // If current element is smaller than parent
                // Swap current element with its parent
                T temp = heap.get(i);
                heap.set(i, heap.get(parent));
                heap.set(parent, temp);
                i = parent;  // Move upwards
            } else {
                break;  // If the heap property is satisfied, break the loop
            }
        }
    }

    // Moves the element at index i downwards to restore heap property
    private void heapifyDown(int i) {
        int size = heap.size();
        while (true) {
            int left = 2 * i + 1;  // Left child index
            int right = 2 * i + 2;  // Right child index
            int smallest = i;

            // Check if left child exists and is smaller than the current element
            if (left < size && heap.get(left).compareTo(heap.get(smallest)) < 0) {
                smallest = left;
            }

            // Check if right child exists and is smaller than the smallest element
            if (right < size && heap.get(right).compareTo(heap.get(smallest)) < 0) {
                smallest = right;
            }

            // If the smallest element is not the current element, swap and continue heapifying down
            if (smallest != i) {
                T temp = heap.get(i);
                heap.set(i, heap.get(smallest));
                heap.set(smallest, temp);
                i = smallest;  // Move downwards
            } else {
                break;  // If heap property is satisfied, break the loop
            }
        }
    }
}