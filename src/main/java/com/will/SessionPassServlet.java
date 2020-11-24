package com.will;

import com.will.beans.Book;
import com.will.beans.BookStore;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class SessionPassServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();

        List<Book> bookList= BookStore.getBookList();
        session.setAttribute("bookList", bookList);

        String url="session-pass-result";
    }
}
