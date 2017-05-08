package main.springapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/5/5 0005.
 */
@RestController
@RequestMapping(value = "/test")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    @ResponseBody
    public String test(){
        return "hello world";
    }
}
