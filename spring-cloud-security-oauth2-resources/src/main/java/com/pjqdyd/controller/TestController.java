package com.pjqdyd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**   
 * @Description:  [测试资源访问的controller层]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

@RestController
public class TestController {

    @GetMapping("/view")
    public String view(){
        return "查询接口";
    }

    @GetMapping("/insert")
    public String insert(){
        return "插入接口";
    }

}
