package com.knowledge.utils;

import java.util.concurrent.TimeUnit;

/***
 * @author KiisawS
 * @date 2018-6-6
 * 线程睡眠类
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
