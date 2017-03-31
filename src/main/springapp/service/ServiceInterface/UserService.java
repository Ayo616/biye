package main.springapp.service.ServiceInterface;

import main.springapp.model.User;
import org.springframework.transaction.annotation.Transactional;

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
}
