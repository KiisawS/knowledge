package com.knowledge.thread.countdownlatch;

import com.knowledge.utils.SleepUtil;

import java.util.concurrent.CountDownLatch;

/***
 * Cache Service
 * 执行8000ms
 * @ClassName CacheHealthChecker
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/6/27 14:25
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
public class CacheHealthChecker extends BaseHealthChecker {
    public CacheHealthChecker(CountDownLatch countDownLatch) {
        super(countDownLatch, "Cache Service");
    }

    @Override
    public void verifyService() {
        long start = System.currentTimeMillis();
        System.out.println("Checking " + this.getServiceName());

        SleepUtil.sleepMilSec(8000);

        System.out.println(this.getServiceName() + "is UP, used time :: " + (System.currentTimeMillis() - start));
    }
}
