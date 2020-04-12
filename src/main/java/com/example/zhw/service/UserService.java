package com.example.zhw.service;

import com.example.zhw.dao.User;
    /**
 * 
 * @author: zhw
 * @createDate: 2020/4/12
 * 
 */
public interface UserService{


    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}
