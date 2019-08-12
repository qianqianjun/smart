package buct.qianqianjun.create.controller;

import buct.qianqianjun.create.domain.SC;
import buct.qianqianjun.create.service.SCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InfoController {
    @Autowired
    private SCService scService;
    @GetMapping("/info")
    public String info(){
        return "info/index";
    }

    @PostMapping("/school/getStudentByaddress")
    @ResponseBody
    public SC isStudent(@RequestParam("studentAddress") String saddress) {
        return scService.getBySaddress(saddress);
    }
}
