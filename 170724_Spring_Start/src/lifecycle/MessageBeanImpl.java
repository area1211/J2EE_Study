package lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageBeanImpl implements MessageBean, BeanNameAware, BeanFactoryAware
										, InitializingBean, DisposableBean{
	private String name;
	private String greeting;
	private String beanName;
	private BeanFactory beanFactory;
	
	public MessageBeanImpl(){
		System.out.println("1. Bean�� ������ ����");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
		System.out.println("2. ���� �޼���(setGreeting) ����");
	}

	public void sayHello(){
		String message = greeting + name + beanName + "!";
		System.out.println(message);
	}
	public void init() {
		System.out.println("7. �ʱ�ȭ �޼��� ����");
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("����...");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("6. ������Ƽ ���� �Ϸ�");
	}

	@Override
	public void setBeanName(String beanName) {
		// TODO Auto-generated method stub
		System.out.println("3. Bean �̸�����");
		this.beanName=beanName;
		System.out.println(" -> "+ beanName);
	}
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("4. BeanFactory ����");
		this.beanFactory=beanFactory;
		System.out.println(" -> "+ this.beanFactory.getClass());
		
	}

}
