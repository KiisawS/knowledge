package com.knowledge.thread;

import java.util.concurrent.TimeUnit;

/***
 * @ClassName SleepUtil
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/6/4 10:29
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
public class SleepUtil {

    public static void sleepMin(long time) {
        try {
            TimeUnit.MINUTES.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleepSec(long time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleepMilSec(long time) {
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
