package buct.qianqianjun.create.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResourceController {
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
        return "resource/show";
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
