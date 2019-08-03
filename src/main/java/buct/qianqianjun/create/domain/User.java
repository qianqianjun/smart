package buct.qianqianjun.create.domain;

import lombok.Data;

@Data
public class User {
    private String account;
    private String password;
    private Integer identify;
    private String uName;
    private String mail;
    public User(){}
}
