package com.example.zhw.web;

import com.example.zhw.dto.AppointExecution;
import com.example.zhw.dto.Result;
import com.example.zhw.entity.Book;
import com.example.zhw.enums.AppointStateEnum;
import com.example.zhw.exception.NoNumberException;
import com.example.zhw.exception.RepeatAppointException;
import com.example.zhw.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/book") // url:/模块/资源/{id}/细分 /seckill/list
public class BookController implements ApplicationContextAware
{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private ApplicationContext ac2;

	@Autowired
	private ApplicationContext ac;
  
	@Autowired
	private BookService bookService;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
	{
		ac2 = applicationContext;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private String list(Model model, HttpServletRequest request)
	{
		System.out.println("SpringMvc容器获取方式一:" + ac);
		System.out.println("SpringMvc容器获取方式二:" + ac2);
		System.out.println("Spring根容器方式一:" + request.getServletContext()
				.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE));
		System.out.println("Spring根容器方式二:" + ContextLoader.getCurrentWebApplicationContext());
		System.out.println("Spring根容器方式三:" + WebApplicationContextUtils
				.getRequiredWebApplicationContext(request.getServletContext()));
		System.out.println("Spring根容器方式四:"
				+ WebApplicationContextUtils.getWebApplicationContext(request.getServletContext()));
		System.out.println("Spring根容器方式五:" + ac.getParent());

		List<Book> list = bookService.getList();
		model.addAttribute("list", list);
		// list.jsp + model = ModelAndView
		return "list";// WEB-INF/jsp/"list".jsp
	}

	@RequestMapping(value = "/{bookId}/detail", method = RequestMethod.GET)
	private String detail(@PathVariable("bookId") Long bookId, Model model)
	{
		if (bookId == null)
		{
			return "redirect:/book/list";
		}
		Book book = bookService.getById(bookId);
		if (book == null)
		{
			return "forward:/book/list";
		}
		model.addAttribute("book", book);
		return "detail";
	}

	// ajax json
	@RequestMapping(value = "/lists", method = RequestMethod.GET)
	@ResponseBody
	private Result<AppointExecution> appoint(Long bookId, Long studentId)
	{
		//		if (studentId == null || studentId.equals(""))
		//		{
		//			return new Result(false, "学号不能为空");
		//		}
		AppointExecution execution = null;
		try
		{
			execution = bookService.appoint(bookId, studentId);
		}
		catch (NoNumberException e1)
		{
			execution = new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);
		}
		catch (RepeatAppointException e2)
		{
			execution = new AppointExecution(bookId, AppointStateEnum.REPEAT_APPOINT);
		}
		catch (Exception e)
		{
			execution = new AppointExecution(bookId, AppointStateEnum.INNER_ERROR);
		}
		return new Result<AppointExecution>(true, execution);
	}

}
