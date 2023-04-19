package com.example.emt.config;

import com.example.emt.model.enumeration.Category;
import com.example.emt.model.exceptions.AuthorNotFoundException;
import com.example.emt.model.exceptions.CountryNotFoundException;
import com.example.emt.service.AuthorService;
import com.example.emt.service.BookService;
import com.example.emt.service.CountryService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataInitialization {
    private final CountryService countryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public DataInitialization(CountryService countryService, AuthorService authorService, BookService bookService) {
        this.countryService = countryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @PostConstruct
    public void initData() {
        List<Category> categories = new ArrayList<>(Arrays.asList(Category.values()));
        for(int i = 1; i <= 7; i++) {
            this.countryService.save("CountryName" + i, "Continent");
            Long countryId = (long) i;
            this.authorService.save("AuthorName" + i, "Surname" + i, countryService.findById(countryId)
                    .orElseThrow(() -> new CountryNotFoundException(countryId)).getId());
            Long authorId = (long) i;
            this.bookService.save("BookName" + i, categories.get(i-1), authorService.findById(authorId)
                    .orElseThrow(() -> new AuthorNotFoundException(authorId)).getId(), 3 * i);
        }
    }
}
