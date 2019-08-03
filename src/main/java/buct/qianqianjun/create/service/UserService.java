package buct.qianqianjun.create.service;

import buct.qianqianjun.create.dao.UserDao;
import buct.qianqianjun.create.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    public User LoginService(String account,String password){
        if(account.equals("") || password.equals("")){
            return null;
        }
        User user=new User();
        user.setAccount(account);
        user.setPassword(password);
        return userDao.Login(user);
    }

    public User registerService(String account, String password, String uName, String mail) {
        if(account.equals("") || password.equals("") || uName.equals("") || mail.equals("")){
            return null;
        }
        User user=new User();
        user.setPassword(password);
        user.setAccount(account);
        user.setMail(mail);
        user.setIdentify(0);
        user.setUName(uName);
        if(userDao.addUser(user)){
            return user;
        }
        return null;
    }
}
