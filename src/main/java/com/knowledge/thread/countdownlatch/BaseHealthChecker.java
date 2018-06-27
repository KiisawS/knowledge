package com.knowledge.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/***
 * 这个类是一个Runnable，负责所有特定的外部服务健康的检测。它删除了重复的代码和闭锁的中心控制代码。
 * @ClassName BaseHealthChecker
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/6/27 14:06
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
public abstract class BaseHealthChecker implements Runnable{

    private CountDownLatch latch;

    private String serviceName;

    private boolean serviceUp;

    /**
     * Get latch object in constructor so that after completing the task, thread can countDown() the latch
     * @param countDownLatch
     * @param serviceName
     */
    public BaseHealthChecker(CountDownLatch countDownLatch, String serviceName) {
        super();
        this.latch = countDownLatch;
        this.serviceName = serviceName;
        this.serviceUp = false;
    }

    @Override
    public void run() {
        try {
            verifyService();
            serviceUp = true;
        } catch(Exception e) {
            e.printStackTrace(System.err);
            serviceUp = false;
        } finally {
            if (latch != null) {
                latch.countDown();
            }
        }
    }

    public String getServiceName() {
        return serviceName;
    }

    public boolean isServiceUp() {
        return serviceUp;
    }

    public abstract void verifyService();
}
