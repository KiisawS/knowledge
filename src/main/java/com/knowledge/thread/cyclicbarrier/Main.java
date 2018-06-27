package com.knowledge.thread.cyclicbarrier;

import com.knowledge.utils.SleepUtil;

/***
 * @ClassName Main
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/6/27 16:27
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
public class Main {

    public static void main(String []args) {
        StudentGoDiningHallUtil.goDiningHall();

        StudentGoDiningHallUtil.shutDown();
    }

}
