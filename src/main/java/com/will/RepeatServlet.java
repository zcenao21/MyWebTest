package com.will;

import com.will.utils.TokenProcessor;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class RepeatServlet extends HttpServlet {

    /** 响应客户请求*/
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //读取表单中的用户名
        String username = request.getParameter("username");

        //生出随机数
        TokenProcessor tokenProcessor = TokenProcessor.getInstance();
        String token = tokenProcessor.makeToken();

        request.getSession().setAttribute("token", token);
        request.getRequestDispatcher("/repeat.jsp").forward(request,response);
    }
}
