package com.tangjun.boss.service;

import com.tangjun.boss.meta.User;

public interface UserService {
	public User findById(int id);
	public User findByName(String name);
	public int checkoutUser(String name, String password);
}
