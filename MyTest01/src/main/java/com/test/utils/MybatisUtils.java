package com.test.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author CHICHI
 */
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;

    static{
        try{
            String resource ="mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //2.根据配置文件构建 SqlSessionFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static SqlSession getSession(){
        return sqlSessionFactory.openSession();
    }
}
