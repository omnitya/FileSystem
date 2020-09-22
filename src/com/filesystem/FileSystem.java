/**
 * 
 */
package com.filesystem;

import java.util.List;

import com.filesystem.bean.Entity;

/**
 * @author omnitya.jha
 *
 */
public interface FileSystem {
	
	public String getCurrentDirectory();
	
	public List<Entity> getCurrentDirectoryListing();
	
	public void createDirectory(String directoryName);
	
	public void changeDirectory(String directoryName);
	
	public void createFile(String fileName);
	
	public void deleteFile(String fileName);
	
	public void quit();

}
