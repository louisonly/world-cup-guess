package com.louis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.louis.entity.User;

@Mapper
public interface UserMapper {

	@Select("select name, age, email from user")
	List<User> findAll();
}
