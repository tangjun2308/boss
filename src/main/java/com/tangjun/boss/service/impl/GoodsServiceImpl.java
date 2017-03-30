package com.tangjun.boss.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tangjun.boss.dao.GoodsDao;
import com.tangjun.boss.meta.Goods;
import com.tangjun.boss.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService{
	@Autowired
	private GoodsDao goodsDao;
	
	public int insertGoods(Goods goods) {
		return	goodsDao.insertGoods(goods);
	}
	
	public Goods findById(int id){
		return goodsDao.findById(id);
	}

	public int updateGoods(Goods goods) {
		return goodsDao.updateGoods(goods);
	}

	public int deleteGoods(int id) {
		return goodsDao.deleteGoods(id);
	}

	public List<Goods> getGoodsList() {
		return goodsDao.getGoodsList();
	}

}
