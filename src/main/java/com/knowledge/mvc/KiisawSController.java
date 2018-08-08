package com.knowledge.mvc;

import com.knowledge.mvc.annotation.MyAutowired;
import com.knowledge.mvc.annotation.MyController;
import com.knowledge.mvc.annotation.MyRequestMapping;

@MyController
@MyRequestMapping("/kiisaws")
public class KiisawSController {

    @MyAutowired("/ksService")
    private KiisawSService kiisawSService;


    @MyRequestMapping("/query")
    public void ssss() {

    }
}
