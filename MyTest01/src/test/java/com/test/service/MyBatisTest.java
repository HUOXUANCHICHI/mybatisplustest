package com.test.service;

import com.test.mapper.CategoryMapper;
import com.test.pojo.Category;
import com.test.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyBatisTest {

    @Test
    public void addCategoryTest() {
        String cname = "儿童丛书";
        String book_describe = "儿童读物";
        Category category = new Category();
        category.setCname(cname);
        category.setBook_describe(book_describe);

        //2. 获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSession();
        //3.获取Mapper接口的代理对象
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        //4.执行方法
        categoryMapper.addCategory(category);
        System.out.println("插入成功!");
        System.out.println(category.getCid());
        //提交事务
        sqlSession.commit();
        //5.释放资源
        sqlSession.close();

    }
    @Test
    public void updateCategoryTest() {
        //接收参数
        String book_describe = "适合5-6岁儿童阅读";
        int cid = 1;

        //封装对象
        Category category = new Category();
        category.setBook_describe(book_describe);
        category.setCid(cid);

        //2. 获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSession();
        //3.获取Mapper接口的代理对象
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        //4.执行方法
        int count = categoryMapper.updateCategory(category);
        if (count > 0) {
            System.out.println("修改了" + count + "行");
        } else System.out.println("修改失败");
        //提交事务
        sqlSession.commit();
        //5.释放资源
        sqlSession.close();
    }
    @Test
    public void findCategoryByIdTest() {

        //接收参数
        int cid = 1;

        //2. 获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSession();
        //3.获取Mapper接口的代理对象
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);

        //4.执行方法
        Category category = categoryMapper.findCategoryByIdTest(cid);
        System.out.println(category);
        //5.释放资源
        sqlSession.close();

    }


}
