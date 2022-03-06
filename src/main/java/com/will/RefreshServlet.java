package com.will;

import com.will.beans.Book;
import com.will.beans.BookStore;
import com.will.beans.Stock;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

@Slf4j
public class RefreshServlet extends HttpServlet {
    Map<String, Stock> map;
    Timer timer;

    @Override
    public void init(ServletConfig config) throws ServletException {

        map = new HashMap<>();

        //新建几只固定的股票
        final Stock zhong = new Stock("1", "百度", 1110.1);
        final Stock fu = new Stock("2", "阿里", 222.2);
        final Stock cheng = new Stock("3", "腾讯", 333.3);
        final Stock ou = new Stock("4", "谷歌", 1133.5);

        //添加到容器中
        map.put("1", zhong);
        map.put("2", fu);
        map.put("3", cheng);
        map.put("4", ou);

        //生成随机数
        final Random random = new Random();

        //格式化生成的随机数
        final DecimalFormat format = new DecimalFormat("#.00");

        //Servlet被启动后1秒开始，每两秒扫描一次
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                double baidu = random.nextDouble() * 1.1;
                double ali = random.nextDouble() * 2;
                double tengxun = random.nextDouble() * 0.3;
                double geogle = random.nextDouble() * 4;

                //概率大致都是50%，我们用来做正负
                if (random.nextBoolean()) {
                    baidu = 0 - baidu;
                }
                if (random.nextBoolean()) {
                    ali = 0 - ali;
                }

                if (random.nextBoolean()) {
                    tengxun = 0 - tengxun;
                }
                if (random.nextBoolean()) {
                    geogle = 0 - geogle;
                }

                //设置它们的当前价格
                zhong.setCurrent(Double.parseDouble(format.format(zhong.getCurrent() + baidu)));
                fu.setCurrent(Double.parseDouble(format.format(fu.getCurrent() + ali)));
                cheng.setCurrent(Double.parseDouble(format.format(cheng.getCurrent() + tengxun)));
                ou.setCurrent(Double.parseDouble(format.format(ou.getCurrent() + geogle)));

            }
        }, 1000, 2000);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //封装成JSON格式，返回给浏览器
        StringBuffer buffer = new StringBuffer();

        //这里我们拼接成4个对象
        buffer.append("({");
        for (Map.Entry<String, Stock> entry : map.entrySet()) {
            String id = entry.getKey();
            Stock stock = entry.getValue();

            buffer.append(id).append(":{yesterday:").append(stock.getYesterday()).append(",today:").append(stock.getToday()).append(",high:").append(stock.getHighest()).append(",low:").append(stock.getLowest()).append(",current:").append(stock.getCurrent()).append(",range:'").append(stock.getRange()).append("'}").append(",");

        }
        //消除最后一个逗号
        buffer.deleteCharAt(buffer.lastIndexOf(","));

        //最后补上括号
        buffer.append("})");

        //返回给浏览器
        resp.getWriter().write(buffer.toString());
    }
}
