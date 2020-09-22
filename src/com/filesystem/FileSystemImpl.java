/**
 * 
 */
package com.filesystem;

import java.io.File;
import java.util.List;

import com.filesystem.bean.Entity;
import com.filesystem.util.FileUtils;

/**
 * @author omnitya.jha
 *
 */
public class FileSystemImpl implements FileSystem{
	
	private String currentPath;
	
	public FileSystemImpl(String currentDirectory) {
		this.currentPath = currentDirectory;
	}

	@Override
	public String getCurrentDirectory() {
		return currentPath;
	}

	@Override
	public List<Entity> getCurrentDirectoryListing() {
		List<Entity> directories = FileUtils.listFilesForFolder(new File(currentPath));
		return directories;
	}

	@Override
	public void createDirectory(String directoryName) {
		FileUtils.makeDirecotory(directoryName, currentPath);
	}

	@Override
	public void changeDirectory(String directoryName) {
		currentPath = currentPath + File.separator + directoryName;
	}

	@Override
	public void createFile(String fileName) {
		FileUtils.createFile(fileName, currentPath);
	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFile(String fileName) {
		FileUtils.deleteFileIfExist(new File(currentPath + File.separator + fileName));
	}
}
