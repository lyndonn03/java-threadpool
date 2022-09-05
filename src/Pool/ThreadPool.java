package Pool;

import Queue.Queue;

public class ThreadPool {

    private Queue tasks;
    private Job[] threads;
    private boolean isStop;

    public ThreadPool() throws InterruptedException {
        this(4);
    }

    public ThreadPool(int threadCount) throws InterruptedException {
        this.tasks = new Queue();
        this.threads = new Job[threadCount];
        for (int x = 0; x < threadCount; x++) {
            System.out.println("Spwaning Thread#" + x);
            Thread.sleep(100);
            Job newThread = new Job(tasks);
            newThread.setName("Thread #" + x);
            threads[x] = newThread;
            newThread.start();
        }
    }

    public synchronized void execute(Runnable task) {
        tasks.push(task);
    }

    public boolean isStop() {
        return this.isStop;
    }

    public void stop(int sleepMillis) throws InterruptedException {
        Thread.sleep(sleepMillis);
        for (int x = 0; x < threads.length; x++) {
            threads[x].kill();
        }
        this.isStop = true;
    }

    public void stop() throws InterruptedException {
        this.stop(100);
    }

    public int threadCount() {
        return this.threads.length;
    }

}
