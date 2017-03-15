package com.tangjun.boss.dao;

import org.apache.ibatis.annotations.Select;

import com.tangjun.boss.meta.User;

public interface UserDao {
    @Select("select * from user where id=#{id}")
    public User findById(int id);
    
    @Select("select * from user where name=#{name}")
    public User findByName(String name);
}
