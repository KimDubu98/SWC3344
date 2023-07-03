import java.util.LinkedList;//import the LinkedList package

public class Queue {
    private LinkedList q; // Declare the object of queue using LinkedList
    int size = 0;

    // Constructor without param
    public Queue() {
        q = new LinkedList<>();
    }

    // Method to insert an object to the queue
    public void enqueue(Object item) {
        q.addLast(item);
        size++;
    }

    // Method to remove an object from the queue
    public Object dequeue() {
        if (!empty()) {
            size--;
            return q.removeFirst(); // Remove the first element (front)
        } else {
            System.out.println("Queue is empty!");
            return null; // Return null or throw an exception to handle empty queue case
        }
    }

    // Method to test whether the queue is empty or not
    public boolean empty() {
        return (q.size() == 0);
    }

    // Return the element at the front without removing it
    public Object front() {
        if (!empty())
            return q.getFirst();
        else {
            System.out.println("Queue is empty");
            return null; // Return null or throw an exception to handle empty queue case
        }
    }
    
    // Method to get the size of the queue
    public int size() {
        return size;
    }
}
