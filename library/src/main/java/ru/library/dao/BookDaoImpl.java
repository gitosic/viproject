package ru.library.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.library.entity.Book;
import ru.library.mapper.BookMapper;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Book book) {
        String sql = "INSERT INTO library.book (isbn, name, author) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, book.getIsbn(), book.getName(), book.getAuthor());
    }

    @Override
    public Book getById(int id) {
        String sql = "SELECT * FROM library.book WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BookMapper(), id);
    }

    @Override
    public void update(Book book) {
        String sql = "UPDATE library.book SET isbn = ?, name = ?, author = ? WHERE id = ?;";
        jdbcTemplate.update(sql, book.getIsbn(), book.getName(), book.getAuthor(), book.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM library.book WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Book> findAll() {
        String sql = "SELECT * FROM library.book";
        return jdbcTemplate.query(sql, new BookMapper());
    }
}
