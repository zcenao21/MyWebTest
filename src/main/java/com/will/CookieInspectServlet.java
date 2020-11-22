package com.will;

import com.will.utils.TimeUtils;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class CookieInspectServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        Cookie[] cookies=request.getCookies();
        boolean flagExistTimeCookie=false;
        if(cookies!=null){
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("time")){
                    log.info("get cookie with write time"+cookie.getValue());
                    response.getWriter().write("last visit time: "+cookie.getValue());
                    flagExistTimeCookie=true;
                    break;
                }
            }
        }
        if(!flagExistTimeCookie){
            Cookie cookieTime=new Cookie("time",
                    TimeUtils.timeStamp2Date(System.currentTimeMillis(),"yyyy-MM-dd HH:mm:ss"));
            cookieTime.setMaxAge(5);
            response.addCookie(cookieTime);
            response.getWriter().write("This is the first visit and time is "+cookieTime.getValue());
        }
    }
}
