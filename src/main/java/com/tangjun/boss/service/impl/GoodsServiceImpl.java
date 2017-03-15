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
	
	public boolean insertGoods(Goods goods) {
		try{
			goodsDao.insertGoods(goods);
		}catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	public Goods findById(int id){
		return goodsDao.findById(id);
	}

	public boolean updateGoods(Goods goods) {
		try{
			goodsDao.updateGoods(goods);
		}catch (Exception e) {
			return false;
		}

		return true;
	}

	public boolean deleteGoods(int id) {
		try{
			goodsDao.deleteGoods(id);
		}catch (Exception e) {
			return false;
		}

		return true;
	}

	public List<Goods> getGoodsList() {
		return goodsDao.getGoodsList();
	}

}
