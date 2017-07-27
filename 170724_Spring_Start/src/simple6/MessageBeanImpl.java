package simple6;

public class MessageBeanImpl implements MessageBean {
	private String name;
	
	
	
	public MessageBeanImpl() {
		super();
	}

	public void setName(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public void sayHello(){
		try{
			Thread.sleep(5000);
			
		}catch(InterruptedException e){
			
		}
		System.out.println("Hello, "+name+"!");
	}
	public void byesayHellobye(){
		try{
			Thread.sleep(5000);
			
		}catch(InterruptedException e){
			
		}
		System.out.println("Hello, "+name+"!");
	}
}
