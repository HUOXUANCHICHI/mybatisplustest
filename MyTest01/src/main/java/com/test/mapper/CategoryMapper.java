package com.test.mapper;

import com.test.pojo.Category;

/**
 * @Author: ablaze
 * @Date: 2022/09/21/8:33
 */
public interface CategoryMapper {
    /**
     * 增
     * @param category
     */
    void addCategory(Category category);

    /**
     * 改
     * @param category
     * @return
     */
    int updateCategory(Category category);

    /**
     * 查
     * @param cid
     * @return
     */
    Category findCategoryByIdTest(int cid);
}
