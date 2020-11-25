package com.will;

import com.will.beans.Book;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Slf4j
public class SessionPassShowServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();
        List<Book> bookList=(List<Book>)session.getAttribute("bookList");
        PrintWriter writer=response.getWriter();
        for(int i=0;bookList!=null&&i<bookList.size();i++){
            log.info(bookList.get(i).toString());
            writer.write(bookList.get(i).toString()+"</br>");
        }
    }
}
