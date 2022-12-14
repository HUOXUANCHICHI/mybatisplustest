package com.ablaze;

import com.ablaze.dao.UserDao;
import com.ablaze.domain.User;
import com.ablaze.domain.query.UserQuery;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mybatisplus02DqlApplicationTests {

    @Autowired
    private UserDao userDao;



    @Test
    void testGetAll() {
        //方式一：按条件查询
/*
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.lt("age",18);
        List<User> userList = userDao.selectList(queryWrapper);
        //System.out.println(userList);
        userList.forEach(System.out::println);
*/
        //方式二：lambda格式按条件查询
/*
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.lambda().lt(User::getAge,10);
        List<User> userList = userDao.selectList(queryWrapper);
        //System.out.println(userList);
        userList.forEach(System.out::println);
*/

        //方式三：lambda格式按条件查询
/*
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>();
*/
/*
        lambdaQueryWrapper.lt(User::getAge,30);
        lambdaQueryWrapper.gt(User::getAge,10);
*//*

        //链式编程
        //10到30岁之间
//        lambdaQueryWrapper.lt(User::getAge,30).gt(User::getAge,10);
        //小于10岁或者大于30岁
        lambdaQueryWrapper.lt(User::getAge,10).or().gt(User::getAge,30);
        List<User> userList = userDao.selectList(lambdaQueryWrapper);
        //System.out.println(userList);
        userList.forEach(System.out::println);
*/

        //模拟页面传递过来的查询数据
        UserQuery uq = new UserQuery();
//        uq.setAge(10);
        uq.setAge2(30);

        //null判定
/*
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        lqw.lt(User::getAge, uq.getAge2());
        if (null != uq.getAge()) {
            lqw.gt(User::getAge, uq.getAge());
        }
        List<User> userList = userDao.selectList(lqw);
        userList.forEach(System.out::println);
*/

/*
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        lqw.lt(User::getAge, uq.getAge2());
        //先判定第一个参数是否为true，如果为true连接当前条件
        lqw.lt(null != uq.getAge2(),User::getAge,uq.getAge2());
        lqw.gt(null != uq.getAge(),User::getAge,uq.getAge());
        List<User> userList = userDao.selectList(lqw);
        System.out.println(userList);
*/

        //查询投影
/*
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        lqw.select(User::getId,User::getName,User::getAge);
*/
/*
        QueryWrapper<User> lqw = new QueryWrapper();
        lqw.select("id","name","age","tel");
        List<User> userList = userDao.selectList(lqw);
        System.out.println(userList);
*/

/*
        QueryWrapper<User> lqw = new QueryWrapper<User>();
        lqw.select("count(*) as count, tel");
        lqw.groupBy("tel");
        List<Map<String,Object>> userList = userDao.selectMaps(lqw);
        System.out.println(userList);
*/

        //条件查询
/*
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        //等同于=
        lqw.eq(User::getName,"Jerry").eq(User::getPassword,"jerry");
        User loginUser = userDao.selectOne(lqw);
        System.out.println(loginUser);
*/
/*
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        //范围查询 lt le gt ge eq between
        lqw.between(User::getAge,10,30);
        List<User> userList = userDao.selectList(lqw);
        System.out.println(userList);
*/
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        //模糊匹配 like
        //范围查询 lt le gt ge eq between
//        lqw.like(User::getName,"J");
//        lqw.likeLeft(User::getName,"J");
        lqw.likeRight(User::getName,"J");
        List<User> userList = userDao.selectList(lqw);
        System.out.println(userList);
    }


}
