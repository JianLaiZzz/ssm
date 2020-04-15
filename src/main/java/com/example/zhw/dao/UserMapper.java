package com.example.zhw.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: zhw
 * @createDate: 2020/4/12
 */

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> queryAllByUserIdAfterAndAge(@Param("minUserId") Integer minUserId, @Param("age") Integer age);


    List<User> findAllByAgeAfterAndNameAfter(@Param("minAge") Integer minAge, @Param("minName") String minName);


}