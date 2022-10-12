package com.test.mapper;

import com.test.pojo.Category;

/**
 * @Author: ablaze
 * @Date: 2022/09/21/8:33
 */
public interface CategoryMapper {
    /**
     * 增 一对一
     * @param category
     */
    void addCategory(Category category);

    /**
     * 改 一对一
     * @param category
     * @return
     */
    int updateCategory(Category category);

    /**
     * 查 一对一
     * @param cid
     * @return
     */
    Category findCategoryByIdTest(int cid);

    /**
     * 查 一对多 嵌套查询
     * @param id
     * @return
     */
    Category findCategoryById(int id);

    /**
     * 查 一对多 嵌套结果
     * @param id
     * @return
     */
    Category findCategoryByIdYDJG(int id);
}
