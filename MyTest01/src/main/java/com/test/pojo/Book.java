package com.test.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: ablaze
 * @Date: 2022/10/12/13:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private Integer id;
    private String isbn;
    private String bookName;
    private String author;
    private Float price;
    private String press;
    /**
     * 关联属性
     */
    private Category category;
}
