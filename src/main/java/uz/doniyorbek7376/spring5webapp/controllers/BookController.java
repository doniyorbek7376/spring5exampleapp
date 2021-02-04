package uz.doniyorbek7376.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import uz.doniyorbek7376.spring5webapp.repositories.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping(value = "/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "books";
    }

}
