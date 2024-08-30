package com.ust.springbootcaching.controller;


import com.ust.springbootcaching.domain.Book;
import com.ust.springbootcaching.service.BookService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/")
    public Book addBook(@RequestBody Book book){
         return bookService.createBook(book);
    }

    @GetMapping("/")
    public List<Book> findAllBooks(){
        return bookService.getAllBooks();
    }

    @Cacheable(value = "books" ,key = "#id")
    @GetMapping("/{id}")
    public Optional<Book> findBookById(@PathVariable Long id){
        try{
            Thread.sleep(7000); //simulating a delay
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return bookService.getBookById(id);
    }


}
