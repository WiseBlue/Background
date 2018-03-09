package com.wiseblue.service;

import com.wiseblue.bean.Book;

import java.util.List;

/**
 * Created by LiZhikang on 2018/2/8.
 */
public interface BookListService {
    public List<Book> getAll();

    public void saveBook();

    public Book getBookById(Integer id);

    public Book getBookByName(String name);

    public void updateBook(Book book);

    public void deleteBook(Integer id);

}
