package main.springapp.controller;

import main.springapp.model.Dfactor;
import main.springapp.service.ServiceInterface.DfactorService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.List;

/**
 * Created by Administrator on 2017/3/15 0015.
 */

@RestController
@RequestMapping(value = "/smarthome")
public class DfactorController {

    @Autowired
    private DfactorService dfactorService;

        /**
             * @api {get} http://localhost/smarthome/{id}   根据设备ID查询设备信息
             * @apiSampleRequest off
             * @apiHeader {String} Content-type application/json;charset=UTF-8.
             * @apiName  Querry
             * @apiGroup other
             *
             * @apiParam {long} id  设备ID.
             *
             * *@apiSuccessExample	Success:

        {
            id: 1
            temperature: 11
            humidity: 13
            illumination: 14
            pm: 34
            smoke: 35
            room_light: false
            hall_light: false
            airconditioner: false
            window: false
            video: false
            intelligence: false
            rfid: false
            loops: false
        }
        **/

    @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    @ResponseBody
    public Dfactor findById(@PathVariable("id") long id){
        return dfactorService.findById(id);
    }


    /**
     * @api {get} http://localhost/smarthome   查询所有设备信息
     * @apiSampleRequest off
     * @apiHeader {String} Content-type application/json;charset=UTF-8.
     * @apiName  QuerryAll
     * @apiGroup other
     *
     * *@apiSuccessExample	Success:

    {
    id: 1
    temperature: 11
    humidity: 13
    illumination: 14
    pm: 34
    smoke: 35
    room_light: false
    hall_light: false
    airconditioner: false
    window: false
    video: false
    intelligence: false
    rfid: false
    loops: false
    }
     **/
    @RequestMapping(method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<Dfactor> show(){
        return dfactorService.findAll();
    }


    /**
         * @api {put}  http://localhost/smarthome 更新修改设备信息
         * @apiSampleRequest off
         * @apiHeader {String} Content-type application/json;charset=UTF-8.
         * @apiName  Querry
         * @apiGroup hardware
         *
         *
         * @apiParam {long} id 设备ID.
         * @apiParam {long} temperature    温度
         * @apiParam {long} humidity      湿度
         * @apiParam {long} illumination   光照
         * @apiParam {long} pm             PM2.5
         * @apiParam {long} smoke           烟雾
         * @apiParam {boolean} window     窗状态
         * @apiParam {boolean} video        摄像头状态
         * @apiParam {boolean} intelligence   智能模式
         * @apiParam {boolean} rfid          RFID状态
         * @apiParam {boolean} loops      指纹识别状态

         *@apiSuccessExample	Success:
    [2]
    0:  {
        id: 1
        temperature: 11
        humidity: 13
        illumination: 14
        pm: 34
        smoke: 35
        room_light: false
        hall_light: false
        airconditioner: false
        window: false
        video: false
        intelligence: false
        rfid: false
        loops: false
    }-
    1:  {
        id: 2
        temperature: 22
        humidity: 11
        illumination: 19
        pm: 89
        smoke: 55
        room_light: false
        hall_light: false
        airconditioner: false
        window: false
        video: false
        intelligence: false
        rfid: false
        loops: false
    }
    **/
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public Dfactor update(@Valid @RequestBody Dfactor dfactor) throws  Exception{
        return  dfactorService.update(dfactor);
    }



    @RequestMapping(value = "/reset/{id}",method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    public Boolean reset(@PathVariable("id") long id) throws  Exception{
        return  dfactorService.resetById(id);
    }

    @RequestMapping(value = "/picture",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Boolean picture(@RequestParam(value = "img")MultipartFile img) throws  Exception{
        File file = new File(" F:\\biye\\src\\main\\webapp\\image\\test.png");
        FileUtils.copyInputStreamToFile(img.getInputStream(),file);
        return  true;
    }

    @RequestMapping(value = "/picture2",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Boolean picture(@RequestBody byte[] img) throws  Exception{
        File file = new File("F:\\biye\\src\\main\\webapp\\image\\test.png");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(img);
        FileUtils.copyInputStreamToFile(byteArrayInputStream,file);
        return  true;
    }



}
