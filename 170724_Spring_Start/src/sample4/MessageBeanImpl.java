package sample4;

import java.io.IOException;

public class MessageBeanImpl implements MessageBean{
	private String name;
	private String greeting;
	private FileOutputter outputter;
	
	public MessageBeanImpl(String name){
		this.name=name;
		
	}
	
	public FileOutputter getOutputter() {
		return outputter;
	}

	public void setOutputter(FileOutputter outputter) {
		this.outputter = outputter;
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
	}

	public void sayHello(){
		String message = greeting + name + "!";
		System.out.println(message);
		try{
			outputter.output(message);
			
		}catch(IOException ie){
			ie.printStackTrace();
		}
	}
	

}
