package com.tangjun.boss.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tangjun.boss.meta.ShoppingCart;

public interface CartDao {
    @Insert("INSERT INTO shoppingcart (userId, goodsIds, goodsNums, createTime, updateTime) VALUES (#{userId}, #{goodsIds}, #{goodsNums}, NOW(), NOW())")
    @Options(useGeneratedKeys=true, keyProperty="id")
    public int insertCart(ShoppingCart shoppingCart);
    
    @Select("select * from shoppingcart where userId=#{userId}")
    public ShoppingCart findByUserId(@Param("userId")Integer userId);
    
    @Update("update shoppingcart set goodsIds=#{goodsIds}, goodsNums=#{goodsNums}, updateTime=NOW()"
            + " where userId=#{userId}")
    public int updateCart(ShoppingCart cart);
}
