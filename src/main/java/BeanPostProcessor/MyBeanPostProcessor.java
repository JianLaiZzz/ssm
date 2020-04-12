package BeanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author: zhw
 * @createDate: 2020/1/18
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor, Ordered
{
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException
	{
        System.out.println("初始化 before--实例化的bean对象:"+bean+"\t"+beanName);
        // 可以根据beanName不同执行不同的处理操作
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException
	{
        System.out.println("初始化 after...实例化的bean对象:"+bean+"\t"+beanName);
        // 可以根据beanName不同执行不同的处理操作
        return bean;
	}

    public int getOrder() {
        return 0;
    }
}
