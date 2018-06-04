package com.knowledge.collection;

import com.knowledge.thread.SleepUtil;

import java.util.HashMap;
import java.util.Map;

/***
 * @ClassName MapFailFast
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/6/4 16:40
 * <p>Company: 杭州传化货嘀科技有限公司</p>
 * 结构修改才会引起fail-fast 添加)/删除
 * 如果只是内容改变是不会引发的
 * 对于map:
 * map.put("a","a");
 * map.put("a","b");//内容修改
 * map.put("b","b");//结构修改
 * map.remove("a");//结构修改
 *
 * 对于list/set
 * list.add("a");
 * list.set(0, "b");//内容修改
 * list.add("b");//结构修改
 * list.remove("a");//结构修改
 */
public class FailFastTest {

    public static void main(String []args) {
        final HashMap<String, String> hashMap = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            hashMap.put("key:" + i,"value:" + i);
        }
        //遍历
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    SleepUtil.sleepMilSec(1);
                    System.out.println(entry);
                }
            }
        }, "thread-one").start();

        //修改值
        new Thread(new Runnable() {
            @Override
            public void run() {
                SleepUtil.sleepMilSec(1);
                hashMap.put("key","value");
            }
        }, "thread-two").start();

        SleepUtil.sleepSec(1);
    }
}
