package buct.qianqianjun.create.service;
import buct.qianqianjun.create.dao.SCDao;
import buct.qianqianjun.create.domain.SC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class SCService {
    @Autowired
    private SCDao scDao;
    public SC getBySaddress(String saddress){
        if(saddress.equals("")){
            return null;
        }
        SC res=scDao.getSCBySAddress(saddress);
        return res;
    }

    public SC addSC(String saddress,String caddress){
        if(saddress.equals("")|| caddress.equals("")){
            return null;
        }
        SC sc=new SC();
        sc.setCaddress(caddress);
        sc.setSaddress(saddress);
        scDao.addSC(sc);
        return sc;
    }
    public List<SC> getAllTc() {
        return  scDao.getAll();
    }
}
