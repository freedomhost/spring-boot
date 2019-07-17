package mmc.edu.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class LoginIntercepter implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException,ServletException{
        Object user = request.getSession().getAttribute("user");
        if(user == null){
            request.setAttribute("msg","没有权限");
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;
        }else
            return true;
    }


}
