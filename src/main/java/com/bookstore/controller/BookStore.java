package com.bookstore.controller;


import com.bookstore.entity.Book;
import com.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Set;


@RestController
public class BookStore {

    @Autowired
    public BookService bookService;

    @RequestMapping(value = "/books")
    public List<Book> getBooks(@RequestParam (value = "yearOfPublication",required = false) Set<Integer> yop,
                               @RequestParam (value = "bookType",required = false) String bookType){

        return bookService.getBooks(yop, bookType);
    }
    @RequestMapping(value = "/books",method =RequestMethod.POST )
    public Book createBook(@RequestBody Book book){
        return bookService.createBook(book);

    }

    @RequestMapping(value = "/books/{id}")
    public Book getBookById(@PathVariable("id") Integer bookId){
        return bookService.getBookById(bookId);
    }
    @RequestMapping(value = "/books", method = RequestMethod.PUT)
    public Book updateBook(@RequestBody  Book inComingBook){
        return bookService.updateBook(inComingBook);
    }
    @RequestMapping(value = "/books/{bookId}",method = RequestMethod.DELETE)
    public String deleteBookById (@PathVariable Integer bookId){
        return bookService.deleteById(bookId);
    }
}
