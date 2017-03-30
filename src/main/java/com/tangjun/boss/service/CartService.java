package com.tangjun.boss.service;

import com.tangjun.boss.meta.ShoppingCart;

public interface CartService {
	public int insertCart(ShoppingCart cart);
	public ShoppingCart findByUserId(int userId);
	public int updateCart(ShoppingCart cart);

}
