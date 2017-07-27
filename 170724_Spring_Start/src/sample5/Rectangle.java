package sample5;

public class Rectangle {
	Point start;
	int width;
	int height;
	
	public void draw(){
		System.out.println("[�簢��:�߽���-("+start.getX()+","+start.getY()+"), ����-"+width+", ����-"+height);
	}

	public Point getStart() {
		return start;
	}

	public void setStart(Point start) {
		this.start = start;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Rectangle(Point start, int width, int height) {
		super();
		this.start = start;
		this.width = width;
		this.height = height;
	}

	public Rectangle() {
		super();
	}
}
