package lifecycle;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;



public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XmlBeanFactory factory = new XmlBeanFactory(new FileSystemResource("lifecycle.xml"));
		factory.addBeanPostProcessor(new CustomBeanPostProcessor());
		MessageBean bean = (MessageBean)factory.getBean("messageBean");
		bean.sayHello();
	}
}
