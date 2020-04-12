package BeanPostProcessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: zhw
 * @createDate: 2020/1/18
 */
public class cilent
{

	public static void main(String args[])
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		User user = context.getBean(User.class);
		System.out.println(user);

	}
}
