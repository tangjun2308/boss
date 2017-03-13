package com.tangjun.boss.service.impl;

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

}
