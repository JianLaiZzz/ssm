package com.example.zhw.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;

/**
 * @author: zhw
 * @createDate: 2020/4/12
 */
public class UserMapperTest
{
	private static UserMapper mapper;

	@BeforeClass
	public static void setUpMybatisDatabase()
	{
		SqlSessionFactory builder = new SqlSessionFactoryBuilder()
				.build(UserMapperTest.class.getClassLoader()
						.getResourceAsStream("mybatisTestConfiguration/UserMapperTestConfiguration.xml"));
		//you can use builder.openSession(false) to not commit to database
		mapper = builder.getConfiguration().getMapper(UserMapper.class, builder.openSession(true));
	}

	@Test
	public void testFindAllByAgeAfterAndNameAfter() throws FileNotFoundException
	{
		mapper.findAllByAgeAfterAndNameAfter(18, "zhw");



	}
}
