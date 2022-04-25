package cxx.note.summary.网络.demo;

import java.util.concurrent.*;

public class PoolHandler {

    private ExecutorService executorService;

    /**
     * 初始化线程池对象
     */
    public void init(int maxThreadNum, int queueSize) {
        executorService = new ThreadPoolExecutor(3, maxThreadNum, 120, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(queueSize));
    }

    public void execute(Runnable target) {
        executorService.execute(target);
    }
}
