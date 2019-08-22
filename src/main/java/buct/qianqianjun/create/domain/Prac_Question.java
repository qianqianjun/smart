package buct.qianqianjun.create.domain;


import lombok.Data;

/*
    问题表
    id
    题干
    选项（四个）
    答案（数字表示）：
        0-3     表示单选 a b c d
        4-9     表示正确答案有两个 ab ac ad bc bd cd
        10-13   表示正确答案有三个 abc abd acd bcd
        14      表示正确答案有四个 abcd
 */
@Data
public class Prac_Question {
    private int question_id;
    private String stem;//题干
    private String option1;//选项1，以此类推
    private String option2;
    private String option3;
    private String option4;
    private int answer;


    public Prac_Question(int id,String s,String o1,String o2,String o3,String o4,int a){
        question_id = id;
        stem = s;
        option1 = o1;
        option2 = o2;
        option3 = o3;
        option4 = o4;
        answer = a;
    }
}
