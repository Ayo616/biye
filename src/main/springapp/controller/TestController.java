package main.springapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/3/13 0013.
 */

@Controller
@RequestMapping("/")
public class TestController  {
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String home() {
        return "home";
    }
}
