package com.test.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author: ablaze
 * @Date: 2022/09/21/8:29
 */

@Getter
@Setter
@ToString
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
}
