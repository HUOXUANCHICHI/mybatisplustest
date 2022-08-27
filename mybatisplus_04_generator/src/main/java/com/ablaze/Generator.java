package com.ablaze;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;

/**
 * @Author: ablaze
 * @Date: 2022/08/27/21:30
 */
public class Generator {
    public static void main(String[] args) {
        AutoGenerator autoGenerator = new AutoGenerator();
        DataSourceConfig dataSource = new DataSourceConfig();
        dataSource.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mybatisplus_db?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai");
        dataSource.setUsername("root");
        dataSource.setPassword("Xh710708");
        autoGenerator.setDataSource(dataSource);
        autoGenerator.execute();


    }
}
