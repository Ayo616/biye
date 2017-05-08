package main.springapp.controller;

import main.springapp.common.StringUtil;
import main.springapp.dto.TeacherDTO;
import main.springapp.dto.UserDTO;
import main.springapp.model.Teacher;
import main.springapp.model.Teachinfo;
import main.springapp.service.ServiceInterface.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Administrator on 2017/4/27 0027.
 */
@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

        /**
             * @api {get} http://localhost/teacher/{id} 查询教师信息
             * @apiSampleRequest off
             * @apiHeader {String} Content-type application/json;charset=UTF-8.
             * @apiName  QuerryTeacher
             * @apiGroup teacher
             *
             *
             * @apiParam {long} id 教师账号信息ID
             **/
    @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    @ResponseBody
    public TeacherDTO findById(@PathVariable("id") long id){
        Teacher teacher = teacherService.findById(id);
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setName(teacher.getName());
        teacherDTO.setTeacher_id(teacher.getTeacher_id());

        ArrayList<String> arrayList = new ArrayList();
        Set<Teachinfo> teachinfos = teacher.getTeachinfos();
        for (Teachinfo teachinfo :teachinfos){
            arrayList.add(teachinfo.getTeachclass());
        }
        teacherDTO.setTeachclazz(arrayList);
        return teacherDTO;

    }

    /**
     * @api {post} http://localhost/teacher/register 教师用户注册
     * @apiSampleRequest off
     * @apiHeader {String} Content-type application/json;charset=UTF-8.
     * @apiName  AddTeacher
     * @apiGroup teacher
     *
     *
     * @apiParam {long} teacher_id 教师账号ID
     * @apiParam {string} name 教师名称
     * @apiParam {string} password 教师账号密码
     **/
    @RequestMapping(value = "/register",method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public boolean add(@Valid @RequestBody Teacher teacher) throws  Exception{
        teacherService.add(teacher);
        return true;
    }


    /**
     * @api {post}  http://localhost/teacher/login 教师用户登陆
     * @apiSampleRequest off
     * @apiHeader {String} Content-type application/json;charset=UTF-8.
     * @apiName  login
     * @apiGroup teacher
     *
     *
     * @apiParam {long} id 账户ID.
     * * @apiParam {String} password 用户密码
     **/
    @RequestMapping(value = "/login",method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public Teacher login(@Valid @RequestBody UserDTO user)throws  Exception {
        Teacher find = teacherService.findById(user.getId());
        if (StringUtil.isNotEmpty(user.getPassword()) && find.getPassword().equals(user.getPassword())){
            return find;
        }
        return  null;
    }

}
