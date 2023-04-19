package com.example.emt.service;

import com.example.emt.model.Book;
import com.example.emt.model.DTO.BookDTO;
import com.example.emt.model.enumeration.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> save(String name, Category category, Long authorId, Integer availableCopies);

    Optional<Book> save(BookDTO bookDto);

    Optional<Book> edit(Long bookId, String name, Category category, Long authorId, Integer availableCopies);

    Optional<Book> edit(Long id, BookDTO bookDto);

    void deleteById(Long id);

    Optional<Book> setRented(Long id);

    Page<Book> findAllWithPagination(Pageable pageable);
}
