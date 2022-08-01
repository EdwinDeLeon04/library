package com.example.library.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.library.service.*;

import ch.qos.logback.core.joran.conditional.ElseAction;

import java.util.*;

import javax.websocket.server.PathParam;

import com.example.library.model.Book;

@RestController
@RequestMapping({"book"})
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
   public  List<Book> getAll(@RequestParam(required = false) String authorId, String title)
   {
    if(authorId == null)
    {
        if(title == null)
           return this.bookService.getAll();
        else
          return this.bookService.findByTitle(title);
    }
    else
        return this.bookService.findByAuthor(authorId);
   }
   
   @GetMapping("/{bookId}")  
   public Book get(@PathVariable String bookId)
      {
    return bookService.get(bookId);
      }

    @PostMapping("")
    public Book addBook(@RequestBody Book book)
    {
        return this.bookService.addBook(book);
    }

    @PutMapping("/{bookId}")
    public Book updateBook(@PathVariable String bookId, @RequestBody Book book)
    { 
        Book ret = this.bookService.updateBook(bookId, book);
        return ret;

    }

    @DeleteMapping("/{bookId}")
    public Book deleteBook(@PathVariable String bookId)
    {
        return this.bookService.deleteBook(bookId);
    }

}
