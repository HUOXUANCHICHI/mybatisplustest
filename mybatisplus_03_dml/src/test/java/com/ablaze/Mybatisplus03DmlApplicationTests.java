package com.ablaze;

import com.ablaze.dao.UserDao;
import com.ablaze.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Mybatisplus03DmlApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void testSave(){
        User user = new User();
        user.setName("黑马程序员");
        user.setPassword("itheima");
        user.setAge(12);
        user.setTel("12345678912");
        userDao.insert(user);
    }

    @Test
    void testDelete(){
        //多记录操作
/*
        ArrayList<Long> list = new ArrayList<>();
        list.add(4L);
        list.add(5L);
        list.add(1563384801479671809L);
        userDao.deleteBatchIds(list);
*/

/*
        ArrayList<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        userDao.selectBatchIds(list);
*/

        userDao.deleteById(2L);
//        System.out.println(userDao.selectList(null));
    }

    @Test
    void testUpdate(){
/*
        User user = new User();
        user.setId(3L);
        user.setName("Tom666");
        user.setVersion(1);
        userDao.updateById(user);
*/
/*
        //1.先通过要修改的数据id将当前数据查出来
        User user = userDao.selectById(3L);
        //2.将要修改的属性注意设置进去
        user.setName("Jock888");
        userDao.updateById(user);
*/

        //1.先通过要修改的数据id将当前数据查出来
        User user = userDao.selectById(3L);  //version3

        User user2 = userDao.selectById(3L);  //version=3
        //2.将要修改的属性注意设置进去
        user2.setName("Jock aaa");
        userDao.updateById(user2);   //vserion=>4

        user.setName("Jock bbb");
        userDao.updateById(user);   //version=3?条件还成立吗
    }

}
