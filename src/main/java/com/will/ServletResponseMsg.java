package com.will;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

@Slf4j
public class ServletResponseMsg extends HttpServlet {
    public void doPost(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String name=request.getParameter("username");
        System.out.println("name input:"+name);
        response.setContentType("text/html;charset=UTF-8");
        if(name!=null&&name.equals("will")){
            response.getWriter().write("你是个天才，没错！");
        }else{
            response.getWriter().write("你康康你输入了个啥？！");
        }
    }
}
