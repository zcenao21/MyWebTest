package com.will;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReferServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Logger logger=Logger.getLogger(ReferServlet.class);
        logger.info("Refer Servlet called!");

        String referer=request.getHeader("Referer");
        if(referer==null||!referer.contains("localhost:8080/counter")){
            response.sendRedirect("/counter");
            return;
        }
        //能执行下面的语句，说明是从我的首页点击进来的，那没问题，照常显示
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("路飞做了XXXXxxxxxxxxxxxxxxxx");
    }
}
