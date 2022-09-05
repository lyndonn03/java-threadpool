package Queue;

public class Node {

    private Runnable task;
    
    private Node next;

    public Node(Runnable task) {
        this(task, null);
    }

    public Node(Runnable task, Node next) {
        this.task = task;
        this.next = next;
    }

    public Runnable getTask() {
        return task;
    }
    public void setTask(Runnable task) {
        this.task = task;
    }

    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    
}
