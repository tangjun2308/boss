package com.tangjun.boss.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tangjun.boss.dao.OrderDao;
import com.tangjun.boss.meta.ShoppingCart;
import com.tangjun.boss.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	
	public boolean addOrder(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		return false;
	}

	public String getSellerGoodsIds() {
		List<Integer> list = orderDao.getAllOrderGoodsId();
		String ans = "";
		if(list != null && list.size()>0){
			for(Integer goodsId : list){
				ans = ans + goodsId + ",";
			}
			ans.substring(0, ans.length()-2);
		}
		return ans;
	}

	public String getUserGoodsIds(int userId) {
		List<Integer> list = orderDao.getAllGoodsIdForUser(userId);
		String ans = "";
		if(list != null && list.size()>0){
			for(Integer goodsId : list){
				ans = ans + goodsId + ",";
			}
			ans.substring(0, ans.length()-1);
		}
		return ans;
	}

}