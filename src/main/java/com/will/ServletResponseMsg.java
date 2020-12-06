package com.will;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class ServletResponseMsg extends HttpServlet {
    public void doPost(
    HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        String name=req.getParameter("username");
        System.out.println("name input:"+name);
        resp.setContentType("text/html;charset=UTF-8");
        if(name!=null&&name.equals("will")){
            resp.getWriter().write("你是个天才，没错！");
        }else{
            resp.getWriter().write("你康康你输入了个啥？！");
        }
    }
}
