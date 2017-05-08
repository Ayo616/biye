package main.springapp.service.ServiceInterface;

import main.springapp.model.Teacher;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/4/27 0027.
 */
public interface TeacherService {
    /*
    * 查
    * */
    @Transactional(readOnly = true)
    Teacher findById(long id);

    /*
* 修改更新
* */
    @Transactional(rollbackFor = Exception.class)
    Teacher update(Teacher teacher);

    /*
        * 新增
        * */
    @Transactional(rollbackFor = Exception.class)
    Teacher add(Teacher teacher);

    /*
            * 根据ID更新修改
            * */
    @Transactional(rollbackFor = Exception.class)
    Teacher updateById(long id);
}
