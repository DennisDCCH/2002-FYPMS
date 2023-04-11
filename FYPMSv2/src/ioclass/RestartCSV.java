package ioclass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Comparator;

public class RestartCSV {
	
	public static void restart() throws IOException {
		delete();
		File src = new File(System.getProperty("user.dir") + "\\RestartCSVFiles");
		File dest = new File(System.getProperty("user.dir") + "\\CSVFiles");
		copyFolder(src.toPath(), dest.toPath());
		
	}
	 
	private static void copyFolder(Path src, Path dest) {
		try {
			Files.walk(src).forEach(s->{
			try {
				Files.copy(s, dest.resolve(src.relativize(s)), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			});
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void delete() throws IOException {
		File folder = new File(System.getProperty("user.dir") + "\\CSVFiles");
		if(folder.isDirectory()) {
			File[] files = folder.listFiles();
			for(File file: files)
				file.delete();
		}
	}
}
