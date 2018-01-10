package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private AuthorRepository authorRepository;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/all")
    public String getALlBookFromAuthors(Model model) {
        Collection<Book> allBooks = new ArrayList<>();
        this.authorRepository.findAll().forEach(a -> allBooks.addAll(a.getBooks()));
        model.addAttribute("books", allBooks);
        return "allBooks";
    }
}
