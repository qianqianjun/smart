package buct.qianqianjun.create.controller;

import buct.qianqianjun.create.domain.PS;
import buct.qianqianjun.create.domain.SC;
import buct.qianqianjun.create.domain.TC;
import buct.qianqianjun.create.service.PSService;
import buct.qianqianjun.create.service.SCService;
import buct.qianqianjun.create.service.TCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class eduDepertmentController {
    @Autowired
    private PSService psService;
    @Autowired
    private TCService tcService;
    @Autowired
    private SCService scService;
    @GetMapping("/edu")
    public String edu(){
        return "edudepartment/index";
    }

    @GetMapping("/school/addteacher")
    public String addTeacher(){
        return "school/addteacher";
    }

    @PostMapping("/school/getbypaddress")
    @ResponseBody
    public PS getBypaddress(@RequestParam("paddress") String paddress){
        PS ps=psService.getByPaddress(paddress);
        return ps;
    }

    @PostMapping("/school/addps")
    @ResponseBody
    public PS addPS(@RequestParam("paddress") String paddress,@RequestParam("saddress") String saddress){
        return psService.addPS(paddress,saddress);
    }

    @PostMapping("/school/addtc")
    @ResponseBody
    public TC addtc(@RequestParam("taddress") String taddress, @RequestParam("caddress") String caddress){
        return tcService.addTC(taddress,caddress);
    }

    @PostMapping("/school/addsc")
    @ResponseBody
    public SC addsc(@RequestParam("studentAddress") String studentAddress,
                    @RequestParam("contract_address") String contract_address){
        return scService.addSC(studentAddress,contract_address);
    }

    @GetMapping("/school/addstudent")
    public String addstudent(){
        return "school/addstudent";
    }

    @GetMapping("/school/addcertificate")
    public String addCertificate(){
        return "school/addcertificate";
    }
}
