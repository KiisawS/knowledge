package com.knowledge.thread.countdownlatch;

import com.knowledge.utils.SleepUtil;

import java.util.concurrent.CountDownLatch;

/***
 * Database Service
 * 执行5000ms
 * @ClassName DatabaseHealthChecker
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/6/27 14:26
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
public class DatabaseHealthChecker extends BaseHealthChecker{

    public DatabaseHealthChecker(CountDownLatch countDownLatch) {
        super(countDownLatch, "Database Service");
    }

    @Override
    public void verifyService() {
        long start = System.currentTimeMillis();
        System.out.println("Checking " + this.getServiceName());

        SleepUtil.sleepMilSec(5000);

        System.out.println(this.getServiceName() + "is UP, used time :: " + (System.currentTimeMillis() - start));
    }
}
