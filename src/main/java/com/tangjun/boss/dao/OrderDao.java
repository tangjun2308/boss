package com.tangjun.boss.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.tangjun.boss.meta.Order;

public interface OrderDao {
	
    @Insert("INSERT INTO myorder (userId, goodsId, num, goodsPrice, totalPrice, createTime) " +
    	    "VALUES (#{userId}, #{goodsId}, #{num}, #{goodsPrice}, #{totalPrice}, NOW())")
    @Options(useGeneratedKeys=true, keyProperty="id")
    public void insertOrder(Order order);
    
	@Select("select * from myorder where userId=#{userId}")    
	public List<Order> getOrderList(int userId);
	
	@Select("select goodsId from myorder")    
	public List<Integer> getAllOrderGoodsId();
	
	@Select("select goodsId from myorder where userId=#{userId}")    
	public List<Integer> getAllGoodsIdForUser(int userId);
	
}
