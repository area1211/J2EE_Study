package simple6;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;


public class HelloApp {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("beans7.xml"));
		MessageBean bean = (MessageBean)factory.getBean("proxy");
		//MessageBean bean = factory.getBean("messageBean", MessageBeanImpl.class);
		bean.sayHello();
	}
}
