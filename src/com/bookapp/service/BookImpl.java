package com.bookapp.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.bookapp.bean.Book;
import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;

public class BookImpl implements BookInter {

    List<Book> bookList = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        bookList.add(book);
    }

    @Override
    public List<Book> getAllBooks() {
        bookList.sort(Comparator.comparing(Book::getTitle));
        return bookList;
    }

    @Override
    public List<Book> getBookbyAuthor(String author) throws AuthorNotFoundException {
        // TODO Auto-generated method stub
        List<Book> filteredList;

        filteredList = bookList.stream()
                .filter(book -> Objects.equals(book.getAuthor(), author))
                .collect(Collectors.toList());

        if (filteredList.isEmpty()) {
            throw new AuthorNotFoundException();
        }

        return filteredList;
    }

    @Override
    public List<Book> getBookbycategory(String category) throws CategoryNotFoundException {
        // TODO Auto-generated method stub
        List<Book> filteredList;

        filteredList = bookList.stream()
                .filter(book -> Objects.equals(book.getCategory(), category))
                .collect(Collectors.toList());

        if (filteredList.isEmpty()) {
            throw new CategoryNotFoundException();
        }

        return filteredList;
    }
}
