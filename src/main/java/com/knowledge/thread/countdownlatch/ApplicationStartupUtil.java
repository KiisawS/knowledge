package com.knowledge.thread.countdownlatch;

import com.knowledge.utils.SleepUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/***
 * 这个类是一个主启动类，它负责初始化闭锁，然后等待，直到所有服务都被检测完。
 * 在这个例子中，我模拟了一个应用程序启动类，它开始时启动了n个线程类，这些线程将检查外部系统并通知闭锁，并且启动类一直在闭锁上等待着。一旦验证和检查了所有外部服务，那么启动类恢复执行。
 * @ClassName ApplicationStartupUtil
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/6/27 14:28
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
public class ApplicationStartupUtil {

    //This latch will be used to wait on
    private static List<BaseHealthChecker> services;

    //This latch will be used to wait on
    private static CountDownLatch latch;

    //Start service checkers using executor framework
    private static ExecutorService executor;

    private ApplicationStartupUtil() {
    }

    private static final ApplicationStartupUtil INSTANCE = new ApplicationStartupUtil();

    public static ApplicationStartupUtil getInstance() {
        return INSTANCE;
    }

    public static boolean checkExternalServices() throws Exception {
        //Initialize the latch with number of service checkers
        latch = new CountDownLatch(3);

        //All add checker in lists
        services = new ArrayList<>();
        services.add(new NetworkHealthChecker(latch));
        services.add(new CacheHealthChecker(latch));
        services.add(new DatabaseHealthChecker(latch));

        //Initialize the executor framework with number of service checkers
        executor = Executors.newFixedThreadPool(services.size());

        for (BaseHealthChecker service : services) {
            executor.execute(service);
        }

        //Now wait till all services are checked
//        latch.await();
        latch.await(3, TimeUnit.MINUTES);

        //Services are file and now proceed startup
        for (BaseHealthChecker service : services) {
            if (!service.isServiceUp()) {
                return false;
            }
        }
        return true;
    }

    /**
     * shutdown executor framework
     */
    public static void shutDown() {
        if (executor != null) {
            SleepUtil.sleepMilSec(1000);
            executor.shutdown();
            System.out.println("it`s ok to shutdown executor framework");
        }
    }
}
