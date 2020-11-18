package com.will;

import com.sun.org.apache.xml.internal.utils.res.XResources_sv;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

@Slf4j
public class DownloadServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OutputStream out;
        InputStream in;
        String fileName=request.getParameter("filename");
        log.info("DownloadServlet doGet filename:{}",fileName);
        if(fileName==null){
            out=response.getOutputStream();
            out.write("Please input filename.".getBytes());
            out.close();
            return;
        }

        in=getServletContext().getResourceAsStream("/store/"+fileName);
        int length=in.available();

        response.setContentType("application/force-download");
        response.setHeader("Content-Length",String.valueOf(length));
        response.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"UTF-8")+"");

        out=response.getOutputStream();
        int bytesRead=0;
        byte[] buffer=new byte[512];
        while ((bytesRead=in.read(buffer))!=-1){
            out.write(buffer, 0, bytesRead);
        }
        in.close();
        out.close();
    }
}
