package com.will;

import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class ImgNumberServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Logger logger=Logger.getLogger(ImgNumberServlet.class);
        logger.info("ImgNumber Servlet called!");

//        BufferedImage bufferedImage=new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);
//        Graphics graphics=bufferedImage.getGraphics();
//        graphics.setColor(Color.GRAY);
//        graphics.setFont(new Font(null,Font.BOLD,20));
//        graphics.drawString("12345",0,20);
//
//        response.setHeader("ContentType","jpeg");
//        ImageIO.write(bufferedImage,"jpg",response.getOutputStream());

//        response.sendRedirect("/counter");
        response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
        response.setHeader("Location","/counter");
    }
}
