package cn.boxfish.cache.jpa;

import cn.boxfish.cache.entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * Created by LuoLiBing on 15/9/30.
 */
@Component
public class SimpleBookRepository implements BookRepository {


    private final static Logger log = LoggerFactory.getLogger(SimpleBookRepository.class);


    /**
     * books缓存
     * @param isbn
     * @return
     */
    @Override
    @Cacheable("books")
    public Book getByIsbn(String isbn) {
        simulateSlowService();
        return new Book(isbn, "Some book");
    }


    private void simulateSlowService() {
        try {
            log.info("simpleBookRepository invoke getByIsbn");
            long time = 5000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
