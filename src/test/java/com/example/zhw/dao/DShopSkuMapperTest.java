package com.example.zhw.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author: zhw
 * @createDate: 2020/4/12
 */
public class DShopSkuMapperTest
{
	private static DShopSkuMapper mapper;

	@BeforeClass
	public static void setUpMybatisDatabase()
	{
		SqlSessionFactory builder = new SqlSessionFactoryBuilder()
				.build(DShopSkuMapperTest.class.getClassLoader().getResourceAsStream(
						"mybatisTestConfiguration/DShopSkuMapperTestConfiguration.xml"));
		//you can use builder.openSession(false) to not commit to database
		mapper = builder.getConfiguration().getMapper(DShopSkuMapper.class, builder.openSession(true));
	}

	@Test
	public void testGetById() throws FileNotFoundException
	{
		DShopSku dShopSku = mapper.getById(1l);
		List<TShopAttribute> list = dShopSku.getAttributes();

		 System.out.println(list.size());

	}
}
