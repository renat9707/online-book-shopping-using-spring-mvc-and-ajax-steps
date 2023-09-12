package az.developia.bookshopping.dao;

import az.developia.bookshopping.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book,Integer> {

}
