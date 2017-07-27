package jsp.tags.bean;

import java.util.Arrays;

public class Dog {
	private String name;
	private Toy[] toys;
	public Dog() {
		super();
	}
	public Dog(String name, Toy[] toys) {
		super();
		this.name = name;
		this.toys = toys;
	}
	public Dog(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Toy[] getToys() {
		return toys;
	}
	public void setToys(Toy[] toys) {
		this.toys = toys;
	}
	@Override
	public String toString() {
		return "Dog [name=" + name + ", toys=" + Arrays.toString(toys) + "]";
	}
	
	
}
