package com.knowledge.thread.countdownlatch;

import com.knowledge.utils.SleepUtil;

import java.util.concurrent.CountDownLatch;

/***
 * Network Service
 * 执行7000ms
 * @ClassName NetworkHealthChecker
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/6/27 14:13
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
public class NetworkHealthChecker extends BaseHealthChecker{

    public NetworkHealthChecker(CountDownLatch countDownLatch) {
        super(countDownLatch, "Network Service");
    }

    @Override
    public void verifyService() {
        long start = System.currentTimeMillis();
        System.out.println("Checking " + this.getServiceName());

        SleepUtil.sleepMilSec(7000);

        System.out.println(this.getServiceName() + "is UP, used time :: " + (System.currentTimeMillis() - start));
    }
}
