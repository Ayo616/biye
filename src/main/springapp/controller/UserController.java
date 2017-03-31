package main.springapp.controller;

import main.springapp.model.User;
import main.springapp.service.ServiceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Administrator on 2017/3/21 0021.
 */

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /*
    * 查找
    * */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    @ResponseBody
    public User findById(@PathVariable("id") long id){
        return userService.findById(id);
    }


    /*
    * 展示
    * */
    @RequestMapping(method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    @ResponseBody
    public User show(){
        return userService.findById(1L);
    }


    /*
    *
    * 更新api
    * */
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public User update(@Valid @RequestBody User User) throws  Exception{
        return  userService.update(User);
    }



    /*
    * 增加
    *
    * */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public User add(@Valid @RequestBody User User) throws  Exception{
        return  userService.add(User);
    }

}
