package buct.qianqianjun.create.domain;

import lombok.Data;

/*
    章节表
    id
    名称
    所有题目id
 */
@Data
public class Prac_Chapter {
    private int chapter_id;
    private String chapter_name;
    private int chapter_order;

    public Prac_Chapter(int id,String name,int order){
        chapter_id = id;
        chapter_name = name;
        chapter_order = order;
    }

}
