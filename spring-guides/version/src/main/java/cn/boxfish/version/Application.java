package cn.boxfish.version;

import cn.boxfish.version.entity.Book;
import cn.boxfish.version.entity.jpa.BookJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by LuoLiBing on 15/12/15.
 */
@RestController
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Autowired
    private BookJpaRepository bookJpaRepository;


    @RequestMapping(value = "/add/{name}")
    public Object add(@PathVariable String name) {
        Book book = new Book();
        book.setName(name);
        bookJpaRepository.save(book);
        return book;
    }


    @RequestMapping(value = "/update/{id}/{name}")
    public Object update(@PathVariable Long id, @PathVariable String name) {
        Book book = bookJpaRepository.findOne(id);
        book.setName(name);
        bookJpaRepository.save(book);
        return book;
    }


    @RequestMapping(value = "/get/{id}")
    public Object get(@PathVariable Long id) {
        return bookJpaRepository.findOne(id);
    }


    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id) {
        bookJpaRepository.delete(id);
        return "Y";
    }
}
