package buct.qianqianjun.create.controller;

import buct.qianqianjun.create.domain.User;
import buct.qianqianjun.create.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public String login(HttpServletRequest request,
            Map<String, Object> parMap,
                        @RequestParam("account") String account,
                        @RequestParam("password") String password){
        User user=userService.LoginService(account,password);
        if(user==null){
            parMap.put("error_msg","账户名或者密码错误，请重新登录");
        }else{
            HttpSession session=request.getSession();
            session.setAttribute("user",user);
            parMap.put("user",user);
        }
        System.out.println(user);
        return "redirect:/";
    }
    @GetMapping("/")
    public String index(HttpServletRequest request,Map<String,Object> parMap){
        HttpSession session=request.getSession();
        User user=(User) session.getAttribute("user");
        if(user!=null) parMap.put("user",user);
        return "index";
    }

    @PostMapping("/register")
    public String register(HttpServletRequest request,Map<String,Object> parMap,
            @RequestParam("account") String account,@RequestParam("password") String password,
                           @RequestParam("uName") String uName,@RequestParam("mail") String mail){
        User user=userService.registerService(account,password,uName,mail);
        if(user==null){
            parMap.put("error_msg","注册失败，用户名已经存在！请联系管理员");
        }else{
            HttpSession session=request.getSession();
            session.setAttribute("user",user);
            parMap.put("user",user);
        }
        HttpSession session=request.getSession();
        session.setAttribute("user",user);
        System.out.println(user);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.setAttribute("user",null);
        return "redirect:/";
    }
}
