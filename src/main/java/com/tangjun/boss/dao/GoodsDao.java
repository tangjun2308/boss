package com.tangjun.boss.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tangjun.boss.meta.Goods;

public interface GoodsDao {
	
    @Insert("INSERT INTO goods (name, summary, price, picUrl, detail, createTime, updateTime, status) " +
    	    "VALUES (#{name}, #{summary}, #{price}, #{picUrl}, #{detail}, NOW(), NOW(), #{status} )")
    @Options(useGeneratedKeys=true, keyProperty="id")
    public void insertGoods(Goods goods);
    
    @Select("select * from goods where id=#{id}")
    public Goods findById(int id);
    
    @Update("update goods set name=#{name}, summary=#{summary}, price=#{price}, picUrl=#{picUrl}, detail=#{detail}, status=#{status}"
            + " where id=#{id}")
    public void updateGoods(Goods goods);
    
    @Update("update goods set status=0" + " where id=#{id}")
    public void deleteGoods(int id);
    
	@Results({
		@Result(property="id",column="id"),
		@Result(property="name",column="userName"),
		@Result(property="summary",column="summary"),
		@Result(property="price",column="price"),
		@Result(property="picUrl",column="picUrl"),		
		@Result(property="detail",column="detail"),
		@Result(property="createTime",column="createTime"),
		@Result(property="updateTime",column="updateTime"),
		@Result(property="status",column="status")
		}
    )
	@Select("select * from goods")    
	public List<Goods> getGoodsList();
}
