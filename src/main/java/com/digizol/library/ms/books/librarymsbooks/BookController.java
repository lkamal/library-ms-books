package com.digizol.library.ms.books.librarymsbooks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private Logger logger = LoggerFactory.getLogger(BookController.class);

    @GetMapping ("")
    public List<Book> list() {
        logger.debug("Start method list()");
        logger.info("Returning books, size = 4");
        logger.debug("End method list()");
        return List.of(
                new Book(1, "Software Architecture in Practice"),
                new Book(2, "Designing Software Architectures"),
                new Book(3, "Documenting Software Architectures"),
                new Book(4, "Software Architecture Patterns")
        );
    }
}
