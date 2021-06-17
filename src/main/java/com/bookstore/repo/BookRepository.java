package com.bookstore.repo;

import com.bookstore.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository
public interface BookRepository extends CrudRepository<Book,Integer> {



    List<Book> findAllByYearOfPublicationIn(Set<Integer> yop);
    List<Book> findAllByYearOfPublicationInAndType(Set<Integer> yop, String bookType);
    List<Book> findAllByType(String bookType);
}
