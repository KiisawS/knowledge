package com.knowledge.thread.countdownlatch;

/***
 * @ClassName Main
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/6/27 14:27
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
public class Main {

    public static void main(String []args) {
        long start = System.currentTimeMillis();
        boolean result = false;
        try {
            result = ApplicationStartupUtil.checkExternalServices();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("External services validation completed !! Result was :: "+ result +
                ", used time :: " + (System.currentTimeMillis() - start));
        ApplicationStartupUtil.shutDown();
    }
}
