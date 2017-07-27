package dao.jndi.impl;

public class TestVO {
	private int id;
	private String foo;
	private int bar;
	public TestVO() {
		super();
	}
	public TestVO(int id, String foo, int bar) {
		super();
		this.id = id;
		this.foo = foo;
		this.bar = bar;
	}
	public int getId() {
		return id;
	}
	public String getFoo() {
		return foo;
	}
	public int getBar() {
		return bar;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setFoo(String foo) {
		this.foo = foo;
	}
	public void setBar(int bar) {
		this.bar = bar;
	}
	@Override
	public String toString() {
		return "TestVO [id=" + id + ", foo=" + foo + ", bar=" + bar + "]";
	}
	
	
}
