package com.example.zhw.dao;

import java.io.Serializable;

/**
 * @author: zhw
 * @createDate: 2020/4/12
 */
public class TShopAttribute implements Serializable
{
	private static final long serialVersionUID = 779884812394806046L;

	private Integer id;

	private String attributeName;

	private Integer skuId;

	public Integer getSkuId()
	{
		return skuId;
	}

	public void setSkuId(Integer skuId)
	{
		this.skuId = skuId;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getAttributeName()
	{
		return attributeName;
	}

	public void setAttributeName(String attributeName)
	{
		this.attributeName = attributeName;
	}
}
