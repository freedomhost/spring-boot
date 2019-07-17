package mmc.edu.controller;

import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username")String username,
                        @RequestParam("pwd")String password,
                        HttpServletRequest  request,
                        Map<String,Object> map){
        if(!StringUtils.isEmpty(username)&&"1".equals(password)){
            request.getSession().setAttribute("user",username);
            return "redirect:/main.html";
        }else{
            map.put("msg","登陆失败");
        }
        return "login";
    }
}
