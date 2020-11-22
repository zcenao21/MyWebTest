package com.will;

import lombok.extern.slf4j.Slf4j;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.LinkedList;

@Slf4j
public class SessionServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();
        LinkedList<String> bookHistory=(LinkedList<String>)session.getAttribute("bookHistory");
        if(bookHistory==null||bookHistory.size()<1){
            bookHistory=new LinkedList<>();
        }
        String[] splitURL=request.getRequestURI().split("/");
        String des="";
        if(splitURL!=null&&splitURL.length>0){
            des=splitURL[splitURL.length-1];
        }
        if(des!=""){
            if(bookHistory.size()>=3){
                bookHistory.removeLast();
                bookHistory.addFirst(des);
            }else{
                bookHistory.addLast(des);
            }
        }
        session.setAttribute("bookHistory", bookHistory);
        response.sendRedirect(response.encodeURL(request.getRequestURL().toString()));
        response.getWriter().write(bookHistory.toString());
        log.info("SessionServlet visited! des:{}, bookHistory:{}",des, bookHistory);
    }
}
