package sample5;

public class Rectangle {
	Point start;
	int width;
	int height;
	
	public void draw(){
		System.out.println("[사각형:중심점-("+start.getX()+","+start.getY()+"), 가로-"+width+", 세로-"+height);
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
