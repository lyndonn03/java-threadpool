package Pool;

import Queue.Queue;

public class Job extends Thread {

    private Queue tasks;
    private boolean isStop;

    public Job(Queue tasks) {
        this.tasks = tasks;
        this.isStop = false;
    }

    @Override
    public void run() {
        while(!isStop) {
            try {
                Runnable task = tasks.pop();
                task.run();
            } catch(RuntimeException re) {

            }
        }
    }

    public synchronized void kill() {
        this.isStop = true;
        // super.interrupt();
    }
    
}
