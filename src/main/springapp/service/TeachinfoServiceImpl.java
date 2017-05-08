package main.springapp.service;

import main.springapp.model.Teachinfo;
import main.springapp.repository.TeachinfoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/5/4 0004.
 */
@Service
public class TeachinfoServiceImpl implements main.springapp.service.ServiceInterface.TeachinfoService {

    @Resource
    private TeachinfoRepository teachinfoRepository;


    /*
* 删除
* */
    @Transactional(readOnly = true)
    @Override
    public boolean delete(Teachinfo teachinfo) {
        teachinfoRepository.delete(teachinfo);
        return  true;
    }

    /*
* 修改更新
* */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Teachinfo update(Teachinfo user) {
        return teachinfoRepository.save(user);
    }


    /*
    * 新增
    * */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Teachinfo add(Teachinfo teachinfo){
        return  teachinfoRepository.save(teachinfo);
    }
}
