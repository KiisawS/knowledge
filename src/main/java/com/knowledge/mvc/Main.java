package com.knowledge.mvc;


import com.knowledge.mvc.servlet.MyDispatcherServlet;
import org.springframework.web.servlet.DispatcherServlet;

public class Main {

    public static void main(String[] args) {
        MyDispatcherServlet dispatcherServlet =  new MyDispatcherServlet();
    }
}
