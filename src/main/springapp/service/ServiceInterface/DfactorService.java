package main.springapp.service.ServiceInterface;

import main.springapp.model.Dfactor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/3/15 0015.
 */

public interface DfactorService {
    Dfactor findById(long id);
    Dfactor update(Dfactor infoDTO);
    Boolean reset(Dfactor infoDTO);
    Dfactor delete(Dfactor infoDTO);

    /*
        * 根据ID更新设备信息
        * */
    @Transactional(rollbackFor = Exception.class)
    Dfactor updateById(long id);

    /*
        * 根据ID清空设备信息
        * */
    @Transactional(rollbackFor = Exception.class)
    Boolean resetById(long id);
    List<Dfactor>  findAll();
 }
