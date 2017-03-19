package com.tangjun.boss.service;

import com.tangjun.boss.meta.ShoppingCart;

public interface OrderService {
	public boolean addOrder(ShoppingCart shoppingCart);
	public String getSellerGoodsIds();
	public String getUserGoodsIds(int userId);
}
