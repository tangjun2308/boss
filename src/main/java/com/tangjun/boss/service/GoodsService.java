package com.tangjun.boss.service;

import java.util.List;

import com.tangjun.boss.meta.Goods;

public interface GoodsService {
	public boolean insertGoods(Goods goods);
	public Goods findById(int id);
	public boolean updateGoods(Goods goods);
	public boolean deleteGoods(int id);
	public List<Goods> getGoodsList();
}
