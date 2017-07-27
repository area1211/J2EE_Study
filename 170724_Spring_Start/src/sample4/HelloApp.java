package sample4;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;



public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("beans4.xml"));
		MessageBean bean = factory.getBean("messageBean", MessageBeanImpl.class);
		bean.sayHello();
	}
}
