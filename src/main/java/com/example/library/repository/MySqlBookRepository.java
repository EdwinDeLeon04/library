package com.example.library.repository;

import com.example.library.model.Book;
import java.util.*;
import java.util.stream.Collectors;


public class MySqlBookRepository implements BookRepository
{
    private Map<String, Book> booksMap;

    public MySqlBookRepository()
    {

        booksMap = new HashMap<>();

    }

    @Override
    public Book delete(String bookId) {

        return null;
    }

    @Override
    public List<Book> findByAuthor(String author) {
       
        return booksMap.values().stream().filter(book -> book.getAuthor().toLowerCase().indexOf(author.toLowerCase()) >= 0).collect(Collectors.toList());
    }

    @Override
    public List<Book> findByTitle(String title) {
        return booksMap.values().stream().filter(book -> book.getAuthor().toLowerCase().indexOf(title.toLowerCase()) >= 0).collect(Collectors.toList());
    }

    @Override
    public Book get(String bookId) {

        return null;
    }

    @Override
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        books.addAll(booksMap.values());
        return books;
    }

    @Override
    public Book save(Book book) {

        return null;
    }

    public Map<String, Book> getBooksMap() {
        return booksMap;
    }

   
    
}
