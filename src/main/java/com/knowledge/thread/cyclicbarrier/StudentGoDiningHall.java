package com.knowledge.thread.cyclicbarrier;

import com.knowledge.utils.SleepUtil;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/***
 * @ClassName StudentGoDiningHall
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/6/27 16:24
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
public class StudentGoDiningHall implements Runnable{

    private CyclicBarrier barrier;

    private String studentName;

    public StudentGoDiningHall(CyclicBarrier barrier, String studentName) {
        this.barrier = barrier;
        this.studentName = studentName;
    }

    @Override
    public void run() {
        System.out.println(studentName + "开始从宿舍出发...");
        SleepUtil.sleepMilSec(1000);
        try {
            barrier.await();
            System.out.println(studentName + "开始从宿舍楼下出发...");
            SleepUtil.sleepMilSec(1000);
            System.out.println(studentName + "到达食堂...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
