package com.will;

import com.will.utils.TokenProcessor;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class ProcessRepeatServlet extends HttpServlet {

    /** 响应客户请求*/
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String serverValue=(String)request.getSession().getAttribute("token");
        String clientValue=request.getParameter("token");
        if(serverValue!=null&&clientValue!=null&&serverValue.equals(clientValue)){
            log.info("处理请求");
            request.getSession().removeAttribute("token");
        }else{
            log.info("请不要重复提交！");
        }
    }
}
