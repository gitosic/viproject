package ru.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.library.dao.BookDao;
import ru.library.entity.Book;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    public BookDao bookDao;

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public void save(Book book) throws Exception {
        bookDao.save(book);
    }

    @Override
    public Book getById(int id) {
        return bookDao.getById(id);
    }

    @Override
    public void update(Book book) {
        bookDao.update(book);
    }

    @Override
    public void delete(int id) {
        bookDao.delete(id);
    }
}
