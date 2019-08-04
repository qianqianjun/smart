package buct.qianqianjun.create.controller;
import buct.qianqianjun.create.service.TCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


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
        return "resource/reports";
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
}