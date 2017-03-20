package com.tangjun.boss.service;

import java.util.List;

import com.tangjun.boss.meta.Order;

public interface OrderService {
	public boolean addOrder(Order order);
	public String getSellerGoodsIds();
	public String getUserGoodsIds(int userId);
	public int getGoodsSelledNum(int goodsId);
	public int getGoodsUserBuyNum(int goodsId, int userId);
	public Order getOrderByUserIdAndGoodsId(int goodsId, int userId);
	public List<Order> getOrderList(int userId);
}
