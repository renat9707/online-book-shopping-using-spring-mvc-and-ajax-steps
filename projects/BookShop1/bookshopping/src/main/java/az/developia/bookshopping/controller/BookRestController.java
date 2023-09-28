package az.developia.bookshopping.controller;

import az.developia.bookshopping.dao.BookDao;
import az.developia.bookshopping.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "/rest/books")
public class BookRestController {
    @Autowired
    private BookDao bookDao;

    @GetMapping
  public List<Book> findAll(){

       return bookDao.findAll();
    }


    @GetMapping("/{id}")
    public Book findById(@PathVariable(name="id") Integer id){

        return bookDao.findById(id).get();
    }
}
