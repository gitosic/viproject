package ru.library.service;

import ru.library.entity.Book;
import java.util.List;

/*
Логика работы
 */
public interface BookService {

    List<Book> findAll();
    void save(Book book) throws Exception;
    Book getById(int id);
    void update(Book book);
    void delete(int id);
}
