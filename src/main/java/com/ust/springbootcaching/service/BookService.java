package com.ust.springbootcaching.service;


import com.ust.springbootcaching.domain.Book;
import com.ust.springbootcaching.repository.BookRepository;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();

    }
    public Book createBook(Book book){
        return bookRepository.save(book);
    }
    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }
}
