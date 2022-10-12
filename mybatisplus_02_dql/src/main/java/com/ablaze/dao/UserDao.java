package com.ablaze.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ablaze.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {



}
