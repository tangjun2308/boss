package com.tangjun.boss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tangjun.boss.dao.CartDao;
import com.tangjun.boss.meta.ShoppingCart;
import com.tangjun.boss.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartDao cartDao;
	
	public int insertCart(ShoppingCart shoppingCart) {
		return cartDao.insertCart(shoppingCart);
	}
	
	public ShoppingCart findByUserId(int userId){
		ShoppingCart cart = cartDao.findByUserId(userId);
		return cart;
	}
	
	public int updateCart(ShoppingCart cart){
		return cartDao.updateCart(cart);
	}

}
