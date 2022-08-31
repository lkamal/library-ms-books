package com.digizol.library.ms.books.librarymsbooks;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping ("")
    public List<Book> list() {
        return List.of(
                new Book(1, "Software Architecture in Practice"),
                new Book(2, "Designing Software Architectures"),
                new Book(3, "Documenting Software Architectures"),
                new Book(4, "Software Architecture Patterns")
        );
    }
}
