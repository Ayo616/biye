package main.springapp.controller;

import com.fasterxml.jackson.core.JsonFactory;
import main.springapp.dto.TestDTO;
import main.springapp.model.TestModel;
import main.springapp.service.ServiceInterface.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.crypto.Data;

/**
 * Created by Administrator on 2017/3/13 0013.
 */

@Controller
@RequestMapping("/home")
public class TestController  {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public TestModel home(@PathVariable("id") long id) {
        return testService.findById(id);
    }

    @RequestMapping(value = "/test",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    @ResponseBody
    public String home(@RequestBody String data) {
        
        return data;
    }
    
}
