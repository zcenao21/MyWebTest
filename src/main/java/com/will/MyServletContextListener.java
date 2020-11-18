package com.will;

import com.will.beans.Counter;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

@Slf4j
public class MyServletContextListener implements ServletContextListener {
    Logger logger=Logger.getLogger(MyServletContextListener.class);
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("MyWeTest application initialized!");
        ServletContext context=sce.getServletContext();
        try{
            BufferedReader reader=new BufferedReader(
                    new InputStreamReader(context.getResourceAsStream("/count/count.txt")));
            int count=Integer.parseInt(reader.readLine());
            reader.close();

            Counter counter=new Counter(count);
            context.setAttribute("counter",counter);
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("MyWebTest application stopped!");
        System.out.println("stoped!");
        ServletContext context=sce.getServletContext();

        Counter counter=(Counter) context.getAttribute("counter");
        if(counter!=null){
            try{
                String filePath=context.getRealPath("/count");
                filePath=filePath+"/count.txt";
                PrintWriter pw=new PrintWriter(filePath);
                pw.println(counter.getCount());
                pw.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
