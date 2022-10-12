package com.test.service;

import com.test.mapper.BookMapper;
import com.test.mapper.CategoryMapper;
import com.test.pojo.Book;
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

    //测试二 一对多
    //一对多插入
    @Test
    public void addCategoryTestYD(){
        //接收参数
        String Cname = "计算机类图书";
        String describe = "编程程序设计";
        String isbn1 = "9787556097500";
        String isbn2 = "2287556097500";
        String name1 = "Java程序设计";
        String name2 = "Python程序设计";
        String author1 = "王岩";
        String author2 = "贾琼";
        Float price1 = 39f;
        Float price2 = 29f;
        String press1 = "北京理工大学出版社";
        String press2 = "沈阳工学院出版社";

        //2. 获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSession();
        //3.获取Mapper接口的代理对象
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        //4.执行方法
        Category category = new Category();
        category.setCname(Cname);
        category.setBook_describe(describe);
        categoryMapper.addCategory(category);
        Book b1 = new Book();
        Book b2 = new Book();
        b1.setIsbn(isbn1);
        b1.setBookName(name1);
        b1.setAuthor(author1);
        b1.setPrice(price1);
        b1.setPress(press1);
        b1.setCategory(category);
        b2.setIsbn(isbn2);
        b2.setBookName(name2);
        b2.setAuthor(author2);
        b2.setPrice(price2);
        b2.setPress(press2);
        b2.setCategory(category);
        bookMapper.addBook(b1);
        bookMapper.addBook(b2);
        sqlSession.commit();
        //5.释放资源
        sqlSession.close();
    }

    //一对多 嵌套查询
    @Test
    public void testFindBookId() {
        //接收参数
        int id = 4;//2. 获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSession();
        //3.获取Mapper接口的代理对象
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        //4.执行方法
        Category categoryById = categoryMapper.findCategoryById(id);
        System.out.println(categoryById);
        //5.释放资源
        sqlSession.close();
    }

    //一对多 嵌套查询结果
    @Test
    public void testFindBookIdQTCXJG() {
        //接收参数
        int id = 4;//2. 获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSession();
        //3.获取Mapper接口的代理对象
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        //4.执行方法
        Category categoryById = categoryMapper.findCategoryByIdYDJG(id);
        System.out.println(categoryById);
        //5.释放资源
        sqlSession.close();
    }

}
