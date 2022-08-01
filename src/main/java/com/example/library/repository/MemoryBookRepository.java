package com.example.library.repository;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.library.model.Book;

@Repository
public class MemoryBookRepository implements BookRepository {
     private Map<String, Book> booksMap;

    public MemoryBookRepository()
    {

        booksMap = new HashMap<>();

    }


    @Override
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        books.addAll(booksMap.values());
        return books;
    }

    @Override
    public Book get(String bookId) {
        return booksMap.get(bookId);
    }

    @Override
    public List<Book> findByAuthor(String author) {
        List<Book> ret = new ArrayList<>();

        for(Book book: booksMap.values())
        {
            if (book.getAuthor().indexOf(author) >= 0)
            {
              ret.add(book);
            }
        }
        return ret;
    }

    public List<Book> findByAuthor2(String author) {
        return booksMap.values().stream().filter(book -> book.getAuthor().toLowerCase().indexOf(author.toLowerCase()) >= 0).collect(Collectors.toList());
    }

    public List<Book> findByTitle(String title) {
        return booksMap.values().stream().filter(book -> book.getTitle().toLowerCase().indexOf(title.toLowerCase()) >= 0).collect(Collectors.toList());
    }

    @Override
    public Book save(Book book) {
        if(book.getBookId() == null)
        {
            book.setBookId(String.valueOf(System.currentTimeMillis()));
        }
        booksMap.put(book.getBookId(), book);
        return book;
    }

    @Override
    public Book delete(String bookId) {
        return booksMap.remove(bookId);
    }


}
