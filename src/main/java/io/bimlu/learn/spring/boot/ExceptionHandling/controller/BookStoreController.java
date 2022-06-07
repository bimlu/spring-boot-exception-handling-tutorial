package io.bimlu.learn.spring.boot.ExceptionHandling.controller;

import io.bimlu.learn.spring.boot.ExceptionHandling.exception.BookNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class BookStoreController {

    private final List<Map<String, String>> allBooks;

    {
        final Map<String, String> firstBook = new HashMap<>();
        firstBook.put("name", "The Four Winds: A Novel");
        firstBook.put("author", "Kristin Hannash");
        firstBook.put("publication date", "Feb 02, 2021");
        firstBook.put("length", "464 pages");
        firstBook.put("price", "$17.39");

        final Map<String, String> secondBook = new HashMap<>();
        secondBook.put("name", "The Boy, the Mole, the Fox and the Horse");
        secondBook.put("author", "Charlie Macksey");
        secondBook.put("publication date", "Oct 22, 2021");
        secondBook.put("length", "546 pages");
        secondBook.put("price", "$27.39");

        final Map<String, String> thirdBook = new HashMap<>();
        thirdBook.put("name", "How to avoid a climate disaster");
        thirdBook.put("author", "Bill Gates");
        thirdBook.put("publication date", "Feb 17, 2021");
        thirdBook.put("length", "272 pages");
        thirdBook.put("price", "$20.39");

        allBooks = new ArrayList<>();
        allBooks.add(firstBook);
        allBooks.add(secondBook);
        allBooks.add(thirdBook);
    }

    @GetMapping("/books")
    public List<Map<String, String>> getAllBooks() {

        return allBooks;
    }

    @GetMapping("/books/{bookName}")
    public Map<String, String> getOneBook(@PathVariable final String bookName) {

        return allBooks
                .stream()
                .filter(Objects::nonNull)
                .filter(book -> book.get("name").toLowerCase().equals(bookName.toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException(bookName + " is not found " +
                        "in our store. Please check again."));
    }

    @DeleteMapping("/books/{bookName}")
    public String removeBook(@PathVariable final String bookName) {

        final boolean bookIsRemoved = allBooks
                .removeIf(book -> book.get("name").toLowerCase().equals(bookName.toLowerCase()));

        if (!bookIsRemoved) {
            throw new UnsupportedOperationException(bookName + " is not found in the " +
                    "book store, so you can't delete it");
        }

        return bookName + " is successfully deleted";
    }
}
