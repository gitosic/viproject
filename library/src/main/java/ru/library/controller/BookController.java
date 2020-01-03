package ru.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.library.entity.Book;
import ru.library.service.BookService;

/*
Обрабатывает запросы с темплейтом
 */
@Controller
//@RequestMapping("/")
public class BookController {

    @Autowired
    public BookService bookService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/hello")
    @Secured( "ROLE_ANYROLE" )
    public String hello(){
        return "hello";
    }

    //Model - это грубо говоря мапа которая нужна для передачи данных между view и контроллером
    @GetMapping("/books")
    public String getAllBooks(Model model){
        model.addAttribute("books", bookService.findAll());
        return "booksList";
    }

    @GetMapping("/book/{id}")
    public String getById(@PathVariable("id") int id, Model model){
        model.addAttribute("book", bookService.getById(id));
        return "showBook";
    }

    @GetMapping("/addBook")
    public String createBookPage(){
        return "createBook";
    }

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute("book") Book book) throws Exception {
        bookService.save(book);
        return "redirect:/books";
    }
    @PostMapping("/updateBook")
        public String updateBook(@ModelAttribute("book") Book book) throws Exception {
        bookService.update(book);
        return "redirect:book/" + book.getId();
        }

    @GetMapping("update/{id}")
    public String update(@PathVariable("id") int id, Model model){
        model.addAttribute("book", bookService.getById(id));
        return "editBook";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") int id){
        bookService.delete(id);
        return "redirect:/books";//Если неправильно указал, то редиректит не на нужную страницу
        // и появится такая ошибка --> The origin server did not find a current representation for the target resource or is not willing to disclose that one exists.
    }
}
