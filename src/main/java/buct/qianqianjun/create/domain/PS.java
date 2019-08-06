package buct.qianqianjun.create.domain;

import lombok.Data;

@Data
public class PS {
    private String paddress;
    private String saddress;
    public PS(String p,String s){
        paddress=p;
        saddress=s;
    }
}
