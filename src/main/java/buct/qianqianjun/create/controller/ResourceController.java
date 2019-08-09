package buct.qianqianjun.create.controller;
import buct.qianqianjun.create.domain.TC;
import buct.qianqianjun.create.service.TCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class ResourceController {
    @Autowired
    private TCService tcService;
    @GetMapping("/resource")
    public String resource(){
        return "resource/index";
    }
    @GetMapping("/resource/management")
    public String management(){
        return "/resource/management";
    }

    @GetMapping("/resource/share")
    public String share(){
        return "resource/share";
    }

    @GetMapping("/resource/message")
    public String message(){
        return "resource/show2";
    }

    @GetMapping("/resource/upload")
    public String upload(){
        return "resource/upload";
    }
    @PostMapping("/resource/getcaddress")
    @ResponseBody
    public TC getcaddress(@RequestParam("taddress") String taddress){
        return tcService.getByTAddress(taddress);
    }

    @GetMapping("/resource/getalltc")
    @ResponseBody
    public List<TC> getAllTc(){
        return tcService.getAllTc();
    }
}