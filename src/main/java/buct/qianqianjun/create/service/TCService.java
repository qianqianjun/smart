package buct.qianqianjun.create.service;

import buct.qianqianjun.create.dao.TCDao;
import buct.qianqianjun.create.domain.TC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TCService {
    @Autowired
    private TCDao tcDao;
    public TC getByTAddress(String tAddress){
        if(tAddress.equals("")){
            return null;
        }
        TC res=tcDao.getTCByTAddress(tAddress);
        return res;
    }

    public TC addTC(String taddress, String caddress) {
        if(taddress.equals("") || caddress.equals("")){
            return null;
        }
        TC tc=new TC();
        tc.setCAddress(caddress);
        tc.setTAddress(taddress);
        tcDao.addTC(tc);
        return tc;
    }

    public List<TC> getAllTc() {
        return  tcDao.getAll();
    }
}
