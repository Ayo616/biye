package main.springapp.service;

import main.springapp.model.Dfactor;
import main.springapp.repository.FactorRepository;
import main.springapp.service.ServiceInterface.DfactorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/3/15 0015.
 */
@Service
public class DfactorServiceImpl implements DfactorService {
    @Resource
    private FactorRepository factorRepository;


    /*
    * 通过设备ID查找设备中的信息
    * */
    @Transactional(readOnly = true)
    @Override
    public Dfactor findById(long id) {
        return factorRepository.findOne(id);
    }

    /*
    * 更新设备中的信息
    * */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Dfactor update(Dfactor infoDTO) {
        return factorRepository.save(infoDTO);
    }


    /*
    * 清空设备中的信息
    * */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean reset(Dfactor infoDTO){
        infoDTO = null;
        factorRepository.save(infoDTO);
        return true;
    }


    /*
    * 删除设备信息
    * */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Dfactor delete(Dfactor infoDTO){
        factorRepository.delete(infoDTO);
        return infoDTO;
    }



    /*
    * 根据ID更新设备信息
    * */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Dfactor updateById(long id) {
        Dfactor dfactor = this.findById(id);
        return this.update(dfactor);
    }



    /*
    * 根据ID清空设备信息
    * */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean resetById(long id){
        return true;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Dfactor> findAll() {
        return  factorRepository.findAll();
    }


}
