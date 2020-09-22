/**
 * 
 */
package com.filesystem.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import com.filesystem.bean.Entity;
import com.filesystem.bean.EntityType;

/**
 * @author omnitya.jha
 *
 */
public class FileUtils {
	
	public static List<Entity> listFilesForFolder(File folder){
		List<Entity> files = new ArrayList<Entity>();
		for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	        	files.add(getEntity(fileEntry.getName(), EntityType.FOLDER));
	            listFilesForFolder(fileEntry);
	        } else {
	        	files.add(getEntity(fileEntry.getName(), EntityType.FILE));
	        }
	    }
		return files;
	}
	
	private static Entity<File> getEntity(String fileName, EntityType entityType) {
		Entity<File> entity = new Entity<File>();
    	entity.setName(fileName);
    	entity.setEntityType(entityType);
    	return entity;
	}
	
	/**
	 * This method is used to mkdir with given name in the given location.
	 * @param dirName name
	 * @param path location
	 */
	public static void makeDirecotory(String dirName, String path) {
		new File(path + File.separator + dirName).mkdirs();
	}
	
	/**
	 * This is used to delete the file if it exists.
	 * @param fileName
	 */
	public static void deleteFileIfExist(File file) {
		try {
			Files.deleteIfExists(file.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * This is used to delete the folder if it exists.
	 * @param fileName
	 */
	public static void deleteDir(File fileName) {
		File[] files = fileName.listFiles();
		if(files != null) {
			for (File myFile: files) {
		        if (myFile.isDirectory()) {  
		            deleteDir(myFile);
		        } 
		        myFile.delete();
		    }
		}
	    fileName.delete();
	}
	
	/**
	 * This method use to create a file with given name.
	 * @param fileName
	 */
	public static void createFile(String fileName, String pathName) {
		File file;
		try {
			file = new File(pathName + File.separator + fileName);
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
