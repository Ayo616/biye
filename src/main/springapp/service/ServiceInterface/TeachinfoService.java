package main.springapp.service.ServiceInterface;

import main.springapp.model.Teachinfo;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/5/4 0004.
 */
public interface TeachinfoService {
    /*
    * 删除
    * */
    @Transactional(readOnly = true)
    boolean delete(Teachinfo teachinfo);

    /*
    * 修改更新
    * */
    @Transactional(rollbackFor = Exception.class)
    Teachinfo update(Teachinfo user);

    /*
        * 新增
        * */
    @Transactional(rollbackFor = Exception.class)
    Teachinfo add(Teachinfo teachinfo);
}
