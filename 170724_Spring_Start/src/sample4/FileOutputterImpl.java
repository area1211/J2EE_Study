package sample4;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutputterImpl implements FileOutputter{
	private String fileName;
	
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void output(String message) throws IOException {
		FileWriter out = new FileWriter(fileName);
		
		out.write(message);
		out.close();
	}
	

}
