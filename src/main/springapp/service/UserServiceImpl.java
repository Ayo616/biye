package main.springapp.service;

import main.springapp.model.User;
import main.springapp.repository.UserRepository;
import main.springapp.service.ServiceInterface.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/3/21 0021.
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    /*
    * 查
    * */
    @Transactional(readOnly = true)
    @Override
    public User findById(long id) {
        return userRepository.findOne(id);
    }

    /*
* 查班级所有同学
* */
    @Transactional(readOnly = true)
    @Override
    public List<User> findAll(String clazz, Pageable pageable) {
        Page page = userRepository.findAllByClazz(clazz,pageable);
        return page.getContent();
    }


    @Transactional(readOnly = true)
    @Override
    public long count() {
        return userRepository.count();
    }

    /*
    * 修改更新
    * */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public User update(User user) {
        return userRepository.save(user);
    }


    /*
    * 新增
    * */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public User add(User user){
        return  userRepository.save(user);
    }



    /*
    * 根据ID更新修改
    * */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public User updateById(long id) {
        User user = this.findById(id);
        return this.update(user);
    }

    /*
* 查学号集合里的所有同学
* */
    @Transactional(readOnly = true)
    @Override
    public List<User> findAllByNumber(List<Long> numbers) {
        List<User> users= userRepository.findAllByNumberIn(numbers);
        return users;
    }

    /*
* 查学号集合里的所有同学
* */
    @Transactional(readOnly = true)
    @Override
    public List<User> updateAll(List<User> userlist) {
        List<User> users= userRepository.save(userlist);
        return users;
    }

}
