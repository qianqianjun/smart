package buct.qianqianjun.create.dao;

import buct.qianqianjun.create.domain.SC;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SCDao {
    SC getSCBySAddress(String saddress);
    void addSC(SC sc);
    void deleteBySAddress(String saddress);
    void fixBySC(SC sc);
    List<SC> getAll();
}