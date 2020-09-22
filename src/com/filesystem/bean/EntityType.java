/**
 * 
 */
package com.filesystem.bean;

/**
 * @author omnitya.jha
 *
 */
public enum EntityType {
	
	FILE("File"),
	FOLDER("Folder"),
	DIRECOTRY("Directory");
	
	private String alias;
	private EntityType(String alias) {
		this.alias = alias;
	}
	
	public String getAlias() {
		return alias;
	}

}
