package buct.qianqianjun.create.service;

import buct.qianqianjun.create.dao.Pra_SubDao;
import buct.qianqianjun.create.domain.Prac_Chapter;
import buct.qianqianjun.create.domain.Prac_Question;
import buct.qianqianjun.create.domain.Prac_Score;
import buct.qianqianjun.create.domain.Prac_Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Pra_SubService {
    @Autowired
    Pra_SubDao pra_subDao;

    public List<Prac_Subject> getAllSubject(){
        List<Prac_Subject> subs = pra_subDao.getAllSubject();
        return subs;
    }

    public List<Prac_Chapter> getChaptersBySubjectName(String sub_name){
        return pra_subDao.getChaptersBySubjectName(sub_name);
    }

    public List<Prac_Question> getQuestionsByChapterID(int chapter_ID){
        return pra_subDao.getQuestionsByChapterID(chapter_ID);
    }

    public void addScore(Prac_Score pracScore1){
        pra_subDao.addScore(pracScore1);
    }
}
