package com.knowledge.thread;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/***
 * @ClassName ThreadConfig
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/6/4 9:54
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
@Configuration
public class ThreadConfig {

    @Bean
    public ScheduledExecutorService scheduledExecutorService() {
        return new ScheduledThreadPoolExecutor(10, new ThreadFactory() {
            private SecurityManager s = System.getSecurityManager();
            private AtomicInteger threadNumber = new AtomicInteger(1);
            @Override
            public Thread newThread(Runnable r) {
                ThreadGroup group = s != null? s.getThreadGroup():Thread.currentThread().getThreadGroup();
                String name = "pool" + "-thread-" + threadNumber.getAndIncrement();
                Thread t = new Thread(group, r, name, 0);
                return t;
            }
        });
    }
}
