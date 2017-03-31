package main.springapp.service;

import main.springapp.model.User;
import main.springapp.repository.UserRepository;
import main.springapp.service.ServiceInterface.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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



}
