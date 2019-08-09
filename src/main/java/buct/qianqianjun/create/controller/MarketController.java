package buct.qianqianjun.create.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MarketController {
    @GetMapping("/market")
    public String market(){
        return "market/index";
    }
}
