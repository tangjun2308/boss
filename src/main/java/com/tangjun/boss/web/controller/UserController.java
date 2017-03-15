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

import com.tangjun.boss.meta.User;
import com.tangjun.boss.service.impl.UserServiceImpl;

@Controller
public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping("/login")
	@ResponseBody
	public Map<String, Object> login(HttpServletRequest request,
			          @RequestParam("name") String name,
			          @RequestParam("password") String password
			){
		HttpSession session = request.getSession();
		Map<String, Object> map=new HashMap<String, Object>();
		int ans = userServiceImpl.checkoutUser(name, password);
		if(ans == 0)
			map.put("code", 0);
		else{
			map.put("code", 200);
			User user = userServiceImpl.findById(ans);
			session.setAttribute("user", user);
			user.setPassword("");
			map.put("user", user);
		}
		
		return map;
	}
}
