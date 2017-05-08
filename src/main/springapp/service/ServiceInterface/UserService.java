package main.springapp.service.ServiceInterface;

import main.springapp.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/3/21 0021.
 */
public interface UserService {
    /*
    * 查
    * */
    @Transactional(readOnly = true)
    User findById(long id);


    /*
* 查班级所有同学
* */
    @Transactional(readOnly = true)
    List<User> findAll(String clazz, Pageable pageable);

    @Transactional(readOnly = true)
    long count();

    /*
                    * 修改更新
                    * */
    @Transactional(rollbackFor = Exception.class)
    User update(User user);

    /*
        * 新增
        * */
    @Transactional(rollbackFor = Exception.class)
    User add(User user);

    /*
            * 根据ID更新修改
            * */
    @Transactional(rollbackFor = Exception.class)
    User updateById(long id);


    /*
    * 查学号集合里的所有同学
    * */
    @Transactional(readOnly = true)
    List<User> findAllByNumber(List<Long> numbers);

    /*
    * 查学号集合里的所有同学
    * */
    @Transactional(rollbackFor = Exception.class)
    List<User> updateAll(List<User> userlist);
}
