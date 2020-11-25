package com.will.beans;

import java.util.ArrayList;
import java.util.List;

public class BookStore {
    private static List<Book> list=new ArrayList<>();
    static {
        list.add(new Book("我是谁"));
        list.add(new Book("我从哪来"));
        list.add(new Book("我要到哪里去"));
    }
    public static Book find(String bookName){
        for(Book book:list){
            if(book.getBookName().equals(bookName)){
                return book;
            }
        }
        return null;
    }
    public static List<Book> getBookList(){
        return list;
    }
}
