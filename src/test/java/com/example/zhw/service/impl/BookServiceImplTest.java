package com.example.zhw.service.impl;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.zhw.BaseTest;
import com.example.zhw.dto.AppointExecution;
import com.example.zhw.service.BookService;

public class BookServiceImplTest extends BaseTest
{

	@Autowired
	private BookService bookService;

	@Test
	public void testAppoint() throws Exception
	{
		long bookId = 1001;
		long studentId = 12345678910L;
		AppointExecution execution = bookService.appoint(bookId, studentId);
		System.out.println(execution);
	}

}
