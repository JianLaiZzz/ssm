package com.example.zhw.dao;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author: zhw
 * @createDate: 2020/4/12
 * 
 */
public class User implements Serializable
{
	private static final long serialVersionUID = 8808349070517026234L;
	/**
	 * userId
	 */
	private Integer userId;

	/**
	 * name
	 */
	private String name;

	/**
	 * age
	 */
	private Integer age;

	/**
	 * datebith
	 */
	private Date datebith;



    public Integer getUserId()
	{
		return userId;
	}

	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getAge()
	{
		return age;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}

	public Date getDatebith()
	{
		return datebith;
	}

	public void setDatebith(Date datebith)
	{
		this.datebith = datebith;
	}


}