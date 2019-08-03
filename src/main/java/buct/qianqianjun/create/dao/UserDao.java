package buct.qianqianjun.create.dao;

import buct.qianqianjun.create.domain.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao {
    public User Login(User user);
    public Boolean addUser(User user);
    public User getByAccount(String account);
}
