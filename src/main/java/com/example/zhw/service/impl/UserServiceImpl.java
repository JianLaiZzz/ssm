package com.example.zhw.service.impl;

import com.example.zhw.dao.User;
import com.example.zhw.dao.UserMapper;
import com.example.zhw.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 
 * @author: zhw
 * @createDate: 2020/4/12
 * 
 */
@Service
public class UserServiceImpl implements UserService
{

	@Resource
	private UserMapper userMapper;

	@Override
	public int deleteByPrimaryKey(Integer userId)
	{
		return userMapper.deleteByPrimaryKey(userId);
	}

	@Override
	public int insert(User record)
	{
		return userMapper.insert(record);
	}

	@Override
	public int insertSelective(User record)
	{
		return userMapper.insertSelective(record);
	}

	@Override
	public User selectByPrimaryKey(Integer userId)
	{
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public int updateByPrimaryKeySelective(User record)
	{
		return userMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(User record)
	{
		return userMapper.updateByPrimaryKey(record);
	}

}
