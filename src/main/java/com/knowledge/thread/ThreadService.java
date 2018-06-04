package com.knowledge.thread;

import com.knowledge.utils.SleepUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/***
 * @ClassName ThreadService
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/6/4 10:27
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
@Service
public class ThreadService {
    private static final Logger LOG = LoggerFactory.getLogger(ThreadService.class);

    @Autowired
    private ScheduledExecutorService scheduledExecutorService;

    public void scheStopByException() {
        LOG.info("主线程开始...");
        final long pre = System.currentTimeMillis();
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            private boolean stop = false;
            @Override
            public void run() {
                LOG.info("任务执行中...");
                isStop(System.currentTimeMillis() - pre > 50000);
                if (stop) {
                    LOG.info("任务终止!");
                    //使用scheduledExecutorService.shutdown()会造成scheduledExecutorService线程池终止,影响后续线程池使用
                    //scheduledExecutorService.shutdown();

                    //使用异常方法中断线程执行
                    throw new RuntimeException("异常中断线程.");
                }
            }
            private void isStop(boolean stop) {
                this.stop = stop;
            }
        }, 10,10, TimeUnit.SECONDS);

        SleepUtil.sleepSec(20);
        LOG.info("主线程结束.");
    }

    public void scheStopByOtherSche() {
        LOG.info("主线程开始...");
        final ScheduledFuture future = scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                LOG.info("任务执行中...");
            }
        }, 10,10, TimeUnit.SECONDS);

        //使用另一个线程终止上一个线程的任务
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                future.cancel(true);
                LOG.info("任务终止!");
            }
        },50, TimeUnit.SECONDS);

        SleepUtil.sleepSec(20);
        LOG.info("主线程结束.");
    }
}
