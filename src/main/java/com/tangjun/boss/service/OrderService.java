package com.tangjun.boss.service;

import com.tangjun.boss.meta.Order;
import com.tangjun.boss.meta.ShoppingCart;

public interface OrderService {
	public boolean addOrder(ShoppingCart shoppingCart);
	public String getSellerGoodsIds();
	public String getUserGoodsIds(int userId);
	public int getGoodsSelledNum(int goodsId);
	public int getGoodsUserBuyNum(int goodsId, int userId);
	public Order getOrderByUserIdAndGoodsId(int goodsId, int userId);
}
