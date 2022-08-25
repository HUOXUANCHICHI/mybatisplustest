package com.ablaze;

import com.ablaze.dao.UserDao;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ablaze.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mybatisplus01QuickstartApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void testSave(){
        User user = new User();
        user.setName("黑马程序员");
        user.setPassword("itheima");
        user.setAge(12);
        user.setTel("12312312312");
        userDao.insert(user);
    }

    @Test
    void testDelete() {
        userDao.deleteById(1562366275193217025L);
    }

    @Test
    void testUpdate() {
        User user = new User();
        user.setId(1L);
        user.setName("Tom666");
        userDao.updateById(user);
    }

    @Test
    void testGetById() {
        User user = userDao.selectById(2L);
        System.out.println(user);
    }


    @Test
    void testGetAll() {
        List<User> userList = userDao.selectList(null);
        //System.out.println(userList);
        userList.forEach(System.out::println);
    }

    @Test
    void testGetByPage() {
        IPage page = new Page(2,3);
        userDao.selectPage(page,null);
        System.out.println("当前页码值:" + page.getCurrent());
        System.out.println("每页显示数:" + page.getSize());
        System.out.println("一共多少页:" + page.getPages());
        System.out.println("一共多少条数据:" + page.getTotal());
        System.out.println("数据:" + page.getRecords());

    }

}
