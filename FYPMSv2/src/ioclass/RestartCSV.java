package ioclass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Comparator;
/**
 * This class takes information from a base case of csv file and save it in a path whereby it will be utilised when
 * the FYP management system is running. Overwriting and resetting the whole system. 
 * @author Dennis Chen
 * @version 1.0
 *
 */
public class RestartCSV {
	
	/**
	 * This method is the one that reset the entire management system back to its original state before any changes was made
	 * @throws IOException if stream to file cannot be written to or closed.
	 */
	public static void restart() throws IOException {
		delete();
		File src = new File(System.getProperty("user.dir") + "\\RestartCSVFiles");
		File dest = new File(System.getProperty("user.dir") + "\\CSVFiles");
		copyFolder(src.toPath(), dest.toPath());
		
	}
	
	/**
	 * This method copy all information from a specificed file path to another specified file path
	 * @param src this is the filepath where the base case csv file should be stored
	 * @param dest this is the filepath whereby want to copy the csv file to.
	 */
	private static void copyFolder(Path src, Path dest) {
		try {
			Files.walk(src).forEach(s->{
			try {
				Files.copy(s, dest.resolve(src.relativize(s)), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.printStackTrace();
			}	
			});
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method delete all csv files stored in the filepath of where the csv file is utilised for the FYP management
	 * system
	 * @throws IOException if stream to file cannot be written to or closed.
	 */
	public static void delete() throws IOException {
		File folder = new File(System.getProperty("user.dir") + "\\CSVFiles");
		if(folder.isDirectory()) {
			File[] files = folder.listFiles();
			for(File file: files)
				file.delete();
		}
	}
}
