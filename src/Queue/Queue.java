package Queue;

public class Queue {

    private Node first;
    private Node last;

    public synchronized void push(Runnable task) {
        Node newNode = new Node(task);
        if (this.isEmpty()) {
            this.first = this.last = newNode;
            return;
        }
        this.last.setNext(newNode);
        this.last = newNode;
    }

    public synchronized Runnable pop() {
        if(this.isEmpty())
            throw new RuntimeException("Queue does not have elements to pop.");
        
        Node toPop = this.first;
        this.first = toPop.getNext();
        return toPop.getTask();
        
    }

    public boolean isEmpty() {
        return this.first == null && this.last == null;
    }

}
