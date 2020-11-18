package com.will;

import com.will.beans.Counter;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import org.apache.log4j.Logger;

public class CounterServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Logger logger=Logger.getLogger(CounterServlet.class);
        logger.info("Counter Servlet called!");
        ServletContext context=getServletContext();
        Counter counter=(Counter)context.getAttribute("counter");
        if(counter==null){
            counter=new Counter(1);
            context.setAttribute("counter", counter);
        }

        response.setContentType("text/html;charset=UTF-8");
//        response.setHeader("Refresh","1");
        PrintWriter out=response.getWriter();
        out.println("<html><head><title>CounterServlet</title></head>");
        out.println("<body>");
        out.println("<h1>欢迎光临本站，"+context.getInitParameter("name")+"。 您是第 "
        +counter.getCount()+" 位访问者。</h1>");
        out.println("<a href=\"/referer\">路飞最新资源</a>");
        out.println("</body></html>");

        counter.addOne();
        out.close();
    }
}
