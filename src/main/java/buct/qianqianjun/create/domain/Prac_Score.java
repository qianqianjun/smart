package buct.qianqianjun.create.domain;


import lombok.Data;

@Data
public class Prac_Score {
    private String student;
    private int subject_id;
    private int chapter_id;
    private int score;

    public Prac_Score(String stu,int s_id,int c_id,int sco){
        student = stu;
        subject_id = s_id;
        chapter_id = c_id;
        score = sco;
    }
}
