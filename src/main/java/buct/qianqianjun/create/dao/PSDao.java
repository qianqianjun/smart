package buct.qianqianjun.create.dao;

import buct.qianqianjun.create.domain.PS;
import org.springframework.stereotype.Repository;

@Repository
public interface PSDao {
    PS getByPaddress(String paddress);
    void addPS(PS ps);
}
