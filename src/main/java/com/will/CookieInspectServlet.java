package com.will;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CookieInspectServlet extends HttpServlet {
    int count=0;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        Cookie cookie=new Cookie("username","will");
        cookie.setMaxAge(5);
        response.addCookie(cookie);
        response.getWriter().write("我已经向浏览器发送了一个Cookie！");
    }
}
