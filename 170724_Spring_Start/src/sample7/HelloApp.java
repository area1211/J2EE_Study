package sample7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import sample7.MessageBean;


public class HelloApp {
	public static void main(String[] args) {
		ApplicationContext factory = new FileSystemXmlApplicationContext("beans6.xml");
		MessageBean bean = (MessageBean)factory.getBean("targetBean");
		//MessageBean bean = factory.getBean("messageBean", MessageBeanImpl.class);
		//MessageBean bean = (MessageBean)factory.getBean("proxy");
		bean.sayHello();
	}
}
