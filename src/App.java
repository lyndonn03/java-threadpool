import Pool.ThreadPool;

public class App {
    public static void main(String[] args) throws Exception {

        ThreadPool pool = new ThreadPool(4);

        for(int y = 0; y < 1000; y++) {
            int z = y;
            pool.execute(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " --- task #" + z);
            });
        }

        pool.stop(1000);
        System.out.println("Is pool stopped: " + pool.isStop());

    }
}
