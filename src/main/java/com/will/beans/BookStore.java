package com.will.beans;

import java.util.ArrayList;
import java.util.List;

public class BookStore {
    private static List<Book> list=new ArrayList<>();
    static {
        list.add(new Book("小可爱在哪里"));
        list.add(new Book("小可爱在这里"));
        list.add(new Book("小可爱来了！"));
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
