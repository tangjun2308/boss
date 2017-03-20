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
	
	public boolean insertCart(ShoppingCart shoppingCart) {
		try{
			cartDao.insertCart(shoppingCart);
		}catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	public ShoppingCart findByUserId(int userId){
		ShoppingCart cart = cartDao.findByUserId(userId);
		return cart;
	}
	
	public boolean updateCart(ShoppingCart cart){
		try{
			cartDao.updateCart(cart);
		}catch (Exception e) {
			return false;
		}
		
		return true;
	}

}
