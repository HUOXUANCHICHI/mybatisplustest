package com.test.pojo;

import lombok.*;

import java.util.List;

/**
 * @Author: ablaze
 * @Date: 2022/09/21/8:29
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    /**
     * id 主键
     */
    private Integer cid;
    /**
     * 用户名称
     */
    private String cname;
    /**
     * 密码
     */
    private String book_describe;

    private List<Book> bs;
}
