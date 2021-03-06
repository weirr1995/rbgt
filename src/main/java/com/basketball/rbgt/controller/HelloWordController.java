package com.basketball.rbgt.controller;

import com.basketball.rbgt.task.TaskUtil;
import com.basketball.rbgt.util.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yiautos
 */
@Api(value = "/hello",tags = "测试 - demo")
@RestController
@RequestMapping("/test")
public class HelloWordController {

    @Autowired
    private TaskUtil taskService;

    @ApiOperation(value = "查询 - demo")
    @GetMapping("/hello")
    public String Test(){
        System.out.println("异步线程开始");
        taskService.getBasketballTournament(DateUtil.getDate(0));
        System.out.println("异步线程结束");
        return "hello word";
    }

    @ApiOperation(value = "查询 - demo")
    @GetMapping("/hello1")
    public String Test1(){
        System.out.println("异步线程开始");
        taskService.getBasketballTournament(DateUtil.getDate(1));
        System.out.println("异步线程结束");
        return "hello word";
    }

    @ApiOperation(value = "查询 - demo")
    @GetMapping("/hello2")
    public String Test2(){
        System.out.println("异步线程开始");
        taskService.getBasketballTournament(DateUtil.getDate(-1));
        System.out.println("异步线程结束");
        return "hello word";
    }
}
