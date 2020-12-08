package com.will;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ozc on 2017/5/17.
 */
@javax.servlet.annotation.WebServlet(name = "ProvinceServlet",urlPatterns = "/ProvinceServlet")
public class ProvinceServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        //设置中文编码
        request.setCharacterEncoding("UTF-8");
        String province = request.getParameter("province");

        //这里是返回的是XML，因此指定XML数据！
        response.setContentType("text/xml;charset=UTF-8");

        PrintWriter printWriter = response.getWriter();

        /****************返回XML文件给前台**************/
        printWriter.write("<?xml version='1.0' encoding='UTF-8'?>");
        printWriter.write("<root>");
        if("广东".equals(province)){
            printWriter.write("<city>广州</city>");
            printWriter.write("<city>深圳</city>");
            printWriter.write("<city>中山</city>");
        }else if("湖南".equals(province)){
            printWriter.write("<city>长沙</city>");
            printWriter.write("<city>株洲</city>");
            printWriter.write("<city>湘潭</city>");
            printWriter.write("<city>岳阳</city>");
        }
        printWriter.write("</root>");

        System.out.println("1111");


        /*******事后操作*******/
        printWriter.flush();
        printWriter.close();


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        this.doPost(request, response);
    }
}

