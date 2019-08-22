package buct.qianqianjun.create.controller;


import buct.qianqianjun.create.dao.Pra_SubDao;
import buct.qianqianjun.create.domain.*;
import buct.qianqianjun.create.service.Pra_SubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;
import java.util.List;
import java.util.Map;





@Controller
public class PractiseController {
    @Autowired
    Pra_SubService pra_subService;
    /**
     * 1.获取所有的科目
     * List<Prac_Subject> subjects = pra_subService.getAllSubject();
     *
     * 2.根据科目的名称获取所有的章节
     * List<Prac_Chapter> chapters  =
     *                 pra_subService.getChaptersBySubjectName("高等数学");
     *
     * 3.根据章节ID获取所有的题目
     * List<Prac_Question> questions = pra_subService.getQuestionsByChapterID(11);
     *
     */

    @RequestMapping("/sub")
    public String practise(Map<String,Object> map){
        List<Prac_Subject> subjects = pra_subService.getAllSubject();
        map.put("subjects",subjects);

        List<Prac_Chapter> chapters  =
                pra_subService.getChaptersBySubjectName("高等数学");
        map.put("chapters",chapters);

        List<Prac_Question> questions = pra_subService.getQuestionsByChapterID(11);
        map.put("questions",questions);


        return "practise/test";
    }

    @PostMapping("/score")
    public void record(HttpServletRequest request,
                       @RequestParam("student") String student,
                       @RequestParam("subject_id") int subject_id,
                       @RequestParam("chapter_id") int chapter_id,
                       @RequestParam("score") int score
                       ){
        Prac_Score pracScore = new Prac_Score(student,subject_id,chapter_id,score);
        pra_subService.addScore(pracScore);
    }



}
