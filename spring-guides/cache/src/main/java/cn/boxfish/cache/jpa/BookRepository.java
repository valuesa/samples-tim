package cn.boxfish.cache.jpa;

import cn.boxfish.cache.entity.Book;

/**
 * Created by LuoLiBing on 15/9/30.
 */
public interface BookRepository {
    Book getByIsbn(String isbn);
}
