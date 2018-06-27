package com.knowledge.thread.cyclicbarrier;

import com.knowledge.utils.SleepUtil;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***
 * @ClassName StudentGoDiningHallUtil
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/6/27 16:27
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
public class StudentGoDiningHallUtil {

    private static final int THREAD_NUMBER = 3;

    private static CyclicBarrier barrier;

    private static ExecutorService executor;

    private StudentGoDiningHallUtil() {
    }

    private static final StudentGoDiningHallUtil INSTANCE = new StudentGoDiningHallUtil();

    public static StudentGoDiningHallUtil getInstance() {
        return INSTANCE;
    }

    public static void goDiningHall() {

        executor = Executors.newFixedThreadPool(THREAD_NUMBER);

        barrier = new CyclicBarrier(THREAD_NUMBER, new Runnable() {
            @Override
            public void run() {
                System.out.println("大家都到宿舍楼下了,一起去食堂...");
            }
        });

        int start = 0;
        for ( ; start < THREAD_NUMBER; start++) {
            executor.execute(new StudentGoDiningHall(barrier, "同学"+Character.toString((char) (65+start))));
        }

        SleepUtil.sleepMilSec(10000);
        System.out.println("重用(one)CyclicBarrier...");

        for ( ; start < THREAD_NUMBER * 2 ; start++) {
            executor.execute(new StudentGoDiningHall(barrier, "同学"+Character.toString((char) (65+start))));
        }

        SleepUtil.sleepMilSec(10000);
        System.out.println("重用(two)CyclicBarrier...");

        for ( ; start < THREAD_NUMBER * 3; start++) {
            executor.execute(new StudentGoDiningHall(barrier, "同学"+Character.toString((char) (65+start))));
        }
    }

    public static void shutDown() {
        if (executor != null) {
            SleepUtil.sleepMilSec(5000);
            executor.shutdown();
            System.out.println("executor shutdown !");
        }
    }
}
