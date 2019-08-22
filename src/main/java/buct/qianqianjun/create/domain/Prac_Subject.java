package buct.qianqianjun.create.domain;

import lombok.Data;

/*
    学科表
    id
    名称
    所有章节id
 */
@Data
public class Prac_Subject {
    private int subject_id;
    private String subject_name;

    public Prac_Subject(int id,String name){
        subject_id = id;
        subject_name = name;
    }
}
