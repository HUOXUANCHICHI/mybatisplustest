package com.test.mapper;

import com.test.pojo.Book;

/**
 * @Author: ablaze
 * @Date: 2022/10/12/13:40
 */
public interface BookMapper {

    /**
     * 增 一对多
     * @param b
     */
    void addBook(Book b);

    /**
     * 查 一对多 嵌套查询
     * @param id
     * @return
     */
    Book findBookById(int id);

}
