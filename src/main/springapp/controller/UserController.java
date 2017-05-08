package main.springapp.controller;

import main.springapp.common.StringUtil;
import main.springapp.dto.UserDTO;
import main.springapp.dto.UserDevicedDTO;
import main.springapp.model.Dfactor;
import main.springapp.model.User;
import main.springapp.service.ServiceInterface.DfactorService;
import main.springapp.service.ServiceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2017/3/21 0021.
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private DfactorService dfactorService;

      /**
           * @api {get} /user/{id} 查询用户信息
           * @apiSampleRequest off
           * @apiHeader {String} Content-type application/json;charset=UTF-8.
           * @apiName  QuerryData
           * @apiGroup software
           *
           *
           * @apiParam {long} id 用户ID
           **/
    @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    @ResponseBody
    public User findById(@PathVariable("id") long id){
        User user = userService.findById(id);
        return user;
    }


    /**
         * @api {post} http://localhost/user?clazz=:clazz&page=:page&cout=:cout 查询该班级的学生实验情况
         * @apiSampleRequest off
         * @apiHeader {String} Content-type application/json;charset=UTF-8.
         * @apiName  QuerryAllStudent
         * @apiGroup teacher
         *
         *
         * @apiParam {long} [page] 第几页.
         * @apiParam {long} [count] 每页显示个数
         * @apiParam {string} clazz 班级名称
         **/
    @RequestMapping(method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<User> show(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                     @RequestParam(value = "count", required = false, defaultValue = "10") int count,
    @RequestParam(value = "clazz") String clazz){


        long total = userService.count();
        if (count <= 0 || count > 100) count = 10;
        int maxPage = (int) ((total % count == 0) ? total / count : total / count + 1);
        if (page < 0) page = 0;
        else if (page >= maxPage && page != 0) page = maxPage - 1;

        List<User> users = userService.findAll(clazz,new PageRequest(page, count));
//        return users.stream()
//                .filter(ur->ur.getClazz().contains("物联网"))
//                .collect(Collectors.toList());
        String tag = null;
        try {
            tag = new String(clazz.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return userService.findAll(tag,new PageRequest(page, count));

    }


    /**
     * @api {put} /user 更新用户信息
     * @apiSampleRequest off
     * @apiHeader {String} Content-type application/json;charset=UTF-8.
     * @apiName  QuerryData
     * @apiGroup software
     *
     *
     * @apiParam {long} id 账户ID
     * @apiParam {String} name 学生姓名
     * * @apiParam {long} number 学号
     * * @apiParam {long} deviceID  实验箱ID
     * * @apiParam {String} password 用户密码
     * * @apiParam {String} clazz 班级
     **/
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public User update(@Valid @RequestBody User User) throws  Exception{
        return  userService.update(User);
    }


    /**
     * @api {post} /device  绑定实验箱ID
     * @apiSampleRequest off
     * @apiHeader {String} Content-type application/json;charset=UTF-8.
     * @apiName  BindDevice
     * @apiGroup software

     *
     * @apiParam {long} device_id 设备ID
     * @apiParam {long} user_id 账户ID
     **/
    @RequestMapping(value = "/device",method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public User bindDevice(@Valid @RequestBody UserDevicedDTO info) throws  Exception{
        User user = userService.findById(info.getUser_id());
        Dfactor dfactor  = dfactorService.findById(info.getDevice_id());
        user.setDeviceID(dfactor);
        return  userService.update(user);
    }


      /**
       * @api {post}  http://localhost/user/register 用户注册
       * @apiSampleRequest off
       * @apiHeader {String} Content-type application/json;charset=UTF-8.
       * @apiName  register
       * @apiGroup software
           *
           *
           * @apiParam {long} id 账户ID.
           * @apiParam {String} name 学生姓名
       * * @apiParam {long} number 学号
       * * @apiParam {long} deviceID  设备ID
       * * @apiParam {String} password 用户密码
       * * @apiParam {String} clazz 班级

           **/
    @RequestMapping(value = "/register",method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public boolean add(@Valid @RequestBody UserDTO userDTO) throws  Exception{
        User user = new User();
        user.setPassword(userDTO.getPassword());
        user.setClazz(userDTO.getClazz());
//        user.setDeviceID(userDTO.getDeviceID());
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setNumber(userDTO.getNumber());
        user.setRole(null);
        user.setScore("60");
        userService.add(user);
        return  true;
    }


    /**
     * @api {post}  http://localhost/user/login 用户登陆
     * @apiSampleRequest off
     * @apiHeader {String} Content-type application/json;charset=UTF-8.
     * @apiName  login
     * @apiGroup software
     *
     *
     * @apiParam {long} id 账户ID.
     * * @apiParam {String} password 用户密码
     **/
    @RequestMapping(value = "/login",method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public User login(@Valid @RequestBody UserDTO user)throws  Exception {
            User find = userService.findById(user.getId());
            if (StringUtil.isNotEmpty(user.getPassword()) && find.getPassword().equals(user.getPassword())){
                return find;
            }
            return  null;
    }


        /**
             * @api {post} /user/score 给全班同学打分
             * @apiSampleRequest off
             * @apiHeader {String} Content-type application/json;charset=UTF-8.
             * @apiName  score
             * @apiGroup teacher
             *
             *
             * @apiParam {string} number 学生学号  JSON格式传递
             * @apiParam {string} score  学生分数
             *
             **/

    @RequestMapping(value = "/score",method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public List<User> score(@Valid @RequestBody Map<String,String> user)throws  Exception {

        List listKey = new ArrayList();
        List listValue = new ArrayList();
        Iterator it = user.keySet().iterator();
        while (it.hasNext()) {
            long key = Long.valueOf(it.next().toString());
            listKey.add(key);
            listValue.add(user.get(key));
        }
        List<User> list =  userService.findAllByNumber(listKey);


        List<User> update = new ArrayList<User>();
        for (User u:list){
            u.setScore(user.get(String.valueOf(u.getNumber())));
            update.add(u);
        }

        return  userService.updateAll(update);
    }

}
