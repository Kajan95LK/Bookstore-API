package com.bookstore.service;

import com.bookstore.entity.Book;
import com.bookstore.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public List<Book> getBooks(Set<Integer> yop, String bookType){
        List<Book> bookList = new ArrayList<>();
        if ( yop == null && bookType==null){
            bookRepository.findAll()
                    .forEach(book -> bookList.add(book));
        }else if(bookType==null){
            return bookRepository.findAllByYearOfPublicationIn(yop);
        }
        else if(yop==null){
            return bookRepository.findAllByType(bookType);
        }else {
           return bookRepository.findAllByYearOfPublicationInAndType(yop, bookType);
        }


        return bookList;
    }
    public Book createBook (Book book){
        return bookRepository.save(book);

    }
    public Book getBookById (Integer bookId){
        return bookRepository.findOne(bookId);

    }

    public Book updateBook(Book inComingBook) {
        return bookRepository.save(inComingBook);
    }

    public String deleteById(Integer bookId) {
        bookRepository.delete(bookId);
        return "Delete Successfully";
    }


}
