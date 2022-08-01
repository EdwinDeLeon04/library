package com.example.library.util;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.example.library.model.Book;
import com.example.library.service.BookService;

@Component
public class DummyBookFilter {
    private final BookService bookService;

    public DummyBookFilter(BookService bookService) {
        this.bookService = bookService;
    }

@PostConstruct
public void init()
    {
          bookService.addBook(new Book(null, "Star Wars", "Alzamiento del Imperio", "George Lucas", 150.00, 2));
          try{ Thread.sleep(100);} catch (InterruptedException e) { }
          bookService.addBook(new Book(null, "Batman", "El Renacer de Batman", "Bob Kane y Bill Finger", 100.00, 4));
          try{ Thread.sleep(200);} catch (InterruptedException e) { }
          bookService.addBook(new Book(null, "John wick", "El Sindicato de Roma", "Derek Kolstad", 150.00, 6));
          try{ Thread.sleep(300);} catch (InterruptedException e) { }
          bookService.addBook(new Book(null, "Doctor Strange", "El Multiverso de la Locura", "Stan Lee y Steve Ditko", 250.00, 8));
    }
}
