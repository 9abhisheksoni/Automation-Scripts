package fileReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

public class TextFileHandler {
	
	private Logger log = Logger.getLogger(TextFileHandler.class.getName());
	
	public void writeToFile(String text, String filename) {
		String filePath = System.getProperty("user.dir")+"/src/main/resources/data/TextFiles/"+filename+".txt";
		log.info("printing into text file "+filename);
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filePath,true));
			bw.write(text);
			bw.newLine();
			bw.close();
		} catch (Exception e) {
			log.info("Error encountered while writing to file");
			e.printStackTrace();
		} 
	}
	
	public void deleteFile(String filename) {
		String filePath = System.getProperty("user.dir")+"/src/main/resources/data/TextFiles/"+filename+".txt";
		File file= new File(filePath);
		if (file.exists() && file.isFile()) 
		  { 
		  file.delete(); 
		  } 
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		log.info("file Successfully deleted");
	}
}
