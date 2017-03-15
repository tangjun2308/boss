package com.tangjun.boss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tangjun.boss.dao.UserDao;
import com.tangjun.boss.meta.User;
import com.tangjun.boss.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	public User findById(int id) {
		return userDao.findById(id);
	}
	
	public int checkoutUser(String name, String password){
		User user = userDao.findByName(name);
		if(user == null || !password.equals(user.getPassword()))
			return 0;

		return user.getId();
	}

	public User findByName(String name) {
		return userDao.findByName(name);
	}

}
