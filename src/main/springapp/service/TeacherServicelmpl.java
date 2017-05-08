package main.springapp.service;

import main.springapp.model.Teacher;
import main.springapp.repository.TeacherRepository;
import main.springapp.service.ServiceInterface.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/4/27 0027.
 */
@Service
public class TeacherServicelmpl implements TeacherService {

    @Resource
    private TeacherRepository teacherRepository;

    /*
* 查
* */
    @Transactional(readOnly = true)
    @Override
    public Teacher findById(long id) {
        return teacherRepository.findOne(id);
    }

    /*
* 修改更新
* */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Teacher update(Teacher teacher) {
        return teacherRepository.save(teacher);
    }


    /*
    * 新增
    * */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Teacher add(Teacher teacher){
        return  teacherRepository.save(teacher);
    }



    /*
    * 根据ID更新修改
    * */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Teacher updateById(long id) {
        Teacher teacher = this.findById(id);
        return this.update(teacher);
    }
}
