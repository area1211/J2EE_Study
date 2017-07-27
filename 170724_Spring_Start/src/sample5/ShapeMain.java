package sample5;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;



public class ShapeMain {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("beans.xml"));
		Rectangle bean = factory.getBean("rectangle", Rectangle.class);
		bean.draw();
	}
}
