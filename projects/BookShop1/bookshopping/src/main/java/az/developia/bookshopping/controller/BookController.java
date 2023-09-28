package az.developia.bookshopping.controller;

import az.developia.bookshopping.dao.BookDao;
import az.developia.bookshopping.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {

    @Autowired
private BookDao bookDAO;


    @GetMapping("/books")
    public String showBooks(Model model) {
        List<Book> books = bookDAO.findAll();
        model.addAttribute("books" , books);
        return "books";

    }

    @GetMapping("/books/new")
    public String openNewBookPage(Model model) {

    Book book = new Book();
    model.addAttribute("book",book);

        return"new-book";
    }


    @PostMapping("/books/new-book=process")

    public String saveBook(@ModelAttribute (name = "Book")Book book) {

      bookDAO.save(book);

        return "redirect:/books";

    }
}
