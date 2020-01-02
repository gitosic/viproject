package ru.library.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.library.entity.Book;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        Book book = new Book();
        book.setId((long) resultSet.getInt("id"));
        book.setName(resultSet.getString("name"));
        book.setIsbn(resultSet.getString("isbn"));
        book.setAuthor(resultSet.getString("author"));
        return book;
    }
}
