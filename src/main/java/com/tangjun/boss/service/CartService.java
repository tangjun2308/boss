package com.tangjun.boss.service;

import com.tangjun.boss.meta.ShoppingCart;

public interface CartService {
	public boolean insertCart(ShoppingCart cart);
	public ShoppingCart findByUserId(int userId);
	public boolean updateCart(ShoppingCart cart);

}
