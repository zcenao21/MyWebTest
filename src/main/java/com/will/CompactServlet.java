package com.will;

import com.will.beans.Counter;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

public class CompactServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Logger logger=Logger.getLogger(CompactServlet.class);
        logger.info("Compact Servlet called!");
        response.setContentType("text/html;charset=UTF-8");
        // 设置编码格式，不设置会出现乱码
        response.setHeader("Content-Encoding","gzip");
        String ss= "fsdfhsdfhuisdhfusdhfuids" +
                "fsdfdsfsdfsdfdsfdafdsfhsdjfhsdjkfhkjds" +
                "fdsfjdslkfjsldkfjsdlkfjsdkfsdjkff" +
                "fsjdfjdsklfjdsklfjkldsfjlksdjflksdjflkds" +
                "dsjfklsdjflsdjfkldsfkjsdkfjsldkfjsdlfk" +
                "fdsjlkfjdslkfjsdlkfjlkasjflk";

        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        GZIPOutputStream gzipOutputStream=new GZIPOutputStream(byteArrayOutputStream);
        gzipOutputStream.write(ss.getBytes()  , 0,ss.getBytes().length );
        gzipOutputStream.close();

        byte[] bytes=byteArrayOutputStream.toByteArray();
        response.getOutputStream().write(bytes);
    }
}
