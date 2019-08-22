package buct.qianqianjun.create.dao;


import buct.qianqianjun.create.domain.Prac_Chapter;
import buct.qianqianjun.create.domain.Prac_Question;
import buct.qianqianjun.create.domain.Prac_Score;
import buct.qianqianjun.create.domain.Prac_Subject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Pra_SubDao {
    List<Prac_Subject> getAllSubject();

    List<Prac_Chapter> getChaptersBySubjectName(String subject_name);

    List<Prac_Question> getQuestionsByChapterID(int chapter_ID);

    void addScore(Prac_Score pracScore);
}
