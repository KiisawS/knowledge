package com.knowledge.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * @ClassName ThreadController
 * <p>Description: </p>
 * @author TF015582
 * @date 2018/6/4 10:33
 * <p>Company: 杭州传化货嘀科技有限公司</p> 
 */
@RestController
@RequestMapping("/thread")
public class ThreadController {

    @Autowired
    private ThreadService threadService;


    @RequestMapping("/sche1")
    public void sche1() {
        threadService.scheStopByException();
    }

    @RequestMapping("/sche2")
    public void sche2() {
        threadService.scheStopByOtherSche();
    }

    @RequestMapping("/test")
    public void test() {
        threadService.test();
    }


    @RequestMapping("/scheduled")
    public void scheduled(int size) {
        threadService.scheduled(size);
    }
}
