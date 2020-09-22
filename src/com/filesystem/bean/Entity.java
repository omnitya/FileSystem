/**
 * 
 */
package com.filesystem.bean;

/**
 * This file can be a file entity or a folder entity.
 * @author omnitya.jha
 *
 */
public class Entity <T> {
	
	private String name;
	private EntityType entityType;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the entityType
	 */
	public EntityType getEntityType() {
		return entityType;
	}
	/**
	 * @param entityType the entityType to set
	 */
	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
	}
	
	@Override
	public String toString() {
		return name + "  "+ entityType +"\n";
	}
}
