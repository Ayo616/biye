package main.springapp.controller;

import main.springapp.model.Teachinfo;
import main.springapp.service.ServiceInterface.TeachinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/5/4 0004.
 */

@RestController
@RequestMapping(value = "/teachinfo")
public class TeachinfoController {

    @Autowired
    private TeachinfoService teachinfoService;

        /**
             * @api {post} /teachinfo 增加教学班级
             * @apiSampleRequest off
             * @apiHeader {String} Content-type application/json;charset=UTF-8.
             * @apiName  Addteachinfo
             * @apiGroup teacher
             *
             *
             * @apiParam {string} teachclass  教学班级
             * @apiParam {string} relate 教师姓名
             **/
    @RequestMapping(method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    public Teachinfo add(@RequestBody Teachinfo teachinfo){

        return teachinfoService.add(teachinfo);
    }

    /**
     * @api {delete} /teachinfo   删除教学班级
     * @apiSampleRequest off
     * @apiHeader {String} Content-type application/json;charset=UTF-8.
     * @apiName  deleteteachinfo
     * @apiGroup teacher
     *
     *
     * @apiParam {string} teachclass  教学班级
     * @apiParam {string} relate 教师姓名
     **/
    @RequestMapping(method = RequestMethod.DELETE,produces = "application/json; charset=utf-8")
    public boolean delete(@RequestBody Teachinfo teachinfo){

        return teachinfoService.delete(teachinfo);
    }

    /**
     * @api {put} /teachinfo 更新教学班级
     * @apiSampleRequest off
     * @apiHeader {String} Content-type application/json;charset=UTF-8.
     * @apiName  Updateteachinfo
     * @apiGroup teacher
     *
     *
     * @apiParam {string} teachclass  教学班级
     * @apiParam {string} relate 教师姓名
     **/
    @RequestMapping(method = RequestMethod.PUT,produces = "application/json; charset=utf-8")
    public Teachinfo update(@RequestBody Teachinfo teachinfo){

        return teachinfoService.update(teachinfo);
    }

}
