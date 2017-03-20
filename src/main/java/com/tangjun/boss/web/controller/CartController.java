package com.tangjun.boss.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tangjun.boss.meta.ShoppingCart;
import com.tangjun.boss.meta.User;
import com.tangjun.boss.service.impl.CartServiceImpl;

@Controller
public class CartController {
	@Autowired
	private CartServiceImpl cartServiceImpl;
	
	@RequestMapping(value = "/addToMyCart.do")
	@ResponseBody
	public Map<String, Object> addToMyCart(HttpServletRequest request, 
			                               @RequestParam("goodsId") int goodsId,
			                               @RequestParam("num") int num,
			                               @RequestParam("userId") int userId){
		Map<String, Object> map=new HashMap<String, Object>();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user == null || user.getType()==1){
			map.put("code", -1);
			return map;
		}
		
		
		boolean success = false;
		ShoppingCart cart = cartServiceImpl.findByUserId(userId);
		if(cart != null){
			String[] ids= cart.getGoodsIds().split(",");
			String[] nums= cart.getGoodsNums().split(",");
			if(ids.toString().contains(goodsId + "")){
				String newNums = ""; 
				for(int i=0; i<ids.length - 1; i++){
					String id = ids[i];
					if(id.equals(goodsId + "")){
						nums[i] = (Integer.valueOf(nums[i]) + num) + "";
					}
					newNums = newNums + nums[i] + ",";
				}
				cart.setGoodsNums(newNums);
			}else{
				cart.setGoodsIds(cart.getGoodsIds() + goodsId + ",");
				cart.setGoodsNums(cart.getGoodsNums() + num + ",");
			}
			success = cartServiceImpl.insertCart(cart);
		}else{
			cart = new ShoppingCart();
			cart.setGoodsIds(goodsId + ",");
			cart.setGoodsNums(num + ",");
			cart.setUserId(userId);
			success = cartServiceImpl.insertCart(cart);
		}

		if(success){
			map.put("code", 200);
			map.put("cart", cart);
		}else{
			map.put("code", 0);
		}
		
		return map;
	}
	
}
