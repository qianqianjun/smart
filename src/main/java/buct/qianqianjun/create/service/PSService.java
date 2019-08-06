package buct.qianqianjun.create.service;

import buct.qianqianjun.create.dao.PSDao;
import buct.qianqianjun.create.domain.PS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PSService {
    @Autowired
    PSDao psDao;
    public PS getByPaddress(String paddress){
        if(paddress.equals("")){
            return null;
        }
        PS result=psDao.getByPaddress(paddress);
        return result;
    }

    public PS addPS(String paddress,String saddress){
        if(paddress.equals("") || saddress.equals("")){
            return null;
        }
        PS ps=new PS(paddress,saddress);
        psDao.addPS(ps);
        return ps;
    }
}
