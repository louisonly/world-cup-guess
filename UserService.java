package com.louis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.entity.User;
import com.louis.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public List<User> getUsersList() {
		List<User> usersList = userMapper.findAll();
		if(usersList!=null) {
			return usersList;
		}
		return null;
	}
}
