/**
 * 
 */
package com.filesystem.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.filesystem.FileSystem;
import com.filesystem.FileSystemImpl;
import com.filesystem.bean.Entity;
import com.filesystem.bean.EntityType;
import com.filesystem.util.FileUtils;

/**
 * @author omnitya.jha
 *
 */
class FilesyStemTest {
	
	private final String FILE_NAME = "Test";
	private final String PATH = "/opt/test";
	private FileSystem fileSystem;
	
	@Before
	public void initilize() {
		fileSystem = new FileSystemImpl(PATH);
		resetPath();
	}

	@Test
	void test_getCurrentDirectory() {
		String currDir = fileSystem.getCurrentDirectory();
		assertEquals(currDir, PATH);
	}
	
	@After
	@Test
	void test_getDirectoryListing() {
		FileSystem fs = new FileSystemImpl(PATH);
		List<Entity> files = fs.getCurrentDirectoryListing();
		System.out.println(files);
		assertNotNull(files);
	}
	
	@Test
	<T> void test_createDirectory() {
		Entity<T> entity = new Entity();
		entity.setName("test_createDirectory");
		entity.setEntityType(EntityType.FOLDER);
		String dirName = "test_createDirectory";
		FileSystem fs = new FileSystemImpl(PATH);
		fs.createDirectory(dirName);
		List<Entity> files = fs.getCurrentDirectoryListing();
		assertFalse(files.isEmpty());
		System.out.println(files);
		FileUtils.deleteDir(new File(PATH + File.separator +dirName));
	}
	
	@Test
	void test_changeDirectory() {
		String dirName = "test_changeDirectory";
		FileSystem fs = new FileSystemImpl(PATH);
		fs.createDirectory(dirName);
		fs.changeDirectory(dirName);
		String currDir = fs.getCurrentDirectory();
		//resetPath();
		assertEquals(currDir, PATH + File.separator + dirName);
		FileUtils.deleteDir(new File(PATH + File.separator +dirName));
	}
	
	@Test
	void test_createFile() {
		String fileName = "test_createFile";
		FileSystem fs = new FileSystemImpl(PATH);
		fs.createFile(fileName);
		List<Entity> files = fs.getCurrentDirectoryListing();
		assertFalse(files.contains(fileName));
		FileUtils.deleteFileIfExist(new File(PATH + File.separator + fileName));
	}
	
	@Test
	void test_quit() {
		fileSystem.quit();
	}
	
	private void resetPath() {
		fileSystem.changeDirectory(PATH);
	}

}
