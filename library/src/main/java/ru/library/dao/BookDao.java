package ru.library.dao;

import ru.library.entity.Book;

import java.util.List;

/*
Работа с базой данных
 */
public interface BookDao {

    void save(Book book);
    Book getById(int id);
    void update(Book book);
    void delete(int id);
    List<Book> findAll();

}
