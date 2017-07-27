package vo;

public class PostVO {
 private int postnum;
 private String writer;
 private String title;
 private String postText;
 private String writeDate;
 private int hits;
 
public PostVO() {
	super();
}

public PostVO(int postnum, String writer, String title, String postText, String writeDate, int hits) {
	super();
	this.postnum = postnum;
	this.writer = writer;
	this.title = title;
	this.postText = postText;
	this.writeDate = writeDate;
	this.hits = hits;
}

public int getPostnum() {
	return postnum;
}

public void setPostnum(int postnum) {
	this.postnum = postnum;
}

public String getWriter() {
	return writer;
}

public void setWriter(String writer) {
	this.writer = writer;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getPostText() {
	return postText;
}

public void setPostText(String postText) {
	this.postText = postText;
}

public String getWriteDate() {
	return writeDate;
}

public void setWriteDate(String writeDate) {
	this.writeDate = writeDate;
}

public int getHits() {
	return hits;
}

public void setHits(int hits) {
	this.hits = hits;
}

@Override
public String toString() {
	return "PostVO [postnum=" + postnum + ", writer=" + writer + ", title=" + title + ", postText=" + postText
			+ ", writeDate=" + writeDate + ", hits=" + hits + "]";
}
}
