package com.tangjun.boss.service;

import java.util.List;

import com.tangjun.boss.meta.Goods;

public interface GoodsService {
	public int insertGoods(Goods goods);
	public Goods findById(int id);
	public int updateGoods(Goods goods);
	public int deleteGoods(int id);
	public List<Goods> getGoodsList();
}
