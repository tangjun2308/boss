package com.tangjun.boss.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tangjun.boss.meta.User;
import com.tangjun.boss.service.impl.OrderServiceImpl;

@Controller
public class OrderController {
	@Autowired
	private OrderServiceImpl orderServiceImpl;
	
	@RequestMapping(value = "selledGoodsIds.do")
	@ResponseBody
	public Map<String, Object> selledGoodsIds(){
		Map<String, Object> map=new HashMap<String, Object>();
		String goodsIds = orderServiceImpl.getSellerGoodsIds();
		
		map.put("goodsIds", goodsIds);
		map.put("code", 200);
		
		return map;
	}
	
	@RequestMapping(value = "userGoodsIds.do")
	@ResponseBody
	public Map<String, Object> userGoodsIds(HttpServletRequest request){
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Map<String, Object> map=new HashMap<String, Object>();
		String goodsIds = orderServiceImpl.getUserGoodsIds(user.getId());
		
		map.put("goodsIds", goodsIds);
		map.put("code", 200);
		
		return map;
	}
}
