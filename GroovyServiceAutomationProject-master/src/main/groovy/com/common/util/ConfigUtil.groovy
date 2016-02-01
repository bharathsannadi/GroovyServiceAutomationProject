package com.common.util

import groovy.util.ConfigObject

class ConfigUtil {
	
	private ConfigObject configObject
	private String workingDir
	private File configFile
	private final String configFileLocation =  "\\src\\test\\resources\\" 
	private final String configFileExtension = ".groovy"
	
	/**
	 * ConfigUtil(String fileName)
	 * @param fileName
	 */
	public ConfigUtil(String fileName){
		workingDir = System.getProperty("user.dir");
		configFile = new File(workingDir + configFileLocation + fileName + configFileExtension)
		configObject = new ConfigSlurper().parse(configFile.toURI().toURL())
	}
	
	/**
	 * ConfigObject getConfigObject()
	 * @return ConfigObject
	 */
	public ConfigObject getConfigObject() {
		return configObject;
	}

	/**
	 * setConfig(ConfigObject configObject)
	 * @param configObject
	 */
	public void setConfig(ConfigObject configObject) {
		this.configObject = configObject;
	}
	
	/**
	 * String getWorkingDir() 
	 * @return String
	 */
	public String getWorkingDir() {
		return workingDir;
	}

	/**
	 * File getConfigFile()
	 * @return File
	 */
	public File getConfigFile() {
		return configFile;
	}

	
	/**
	 * setWorkingDir(String workingDir)
	 * @param workingDir
	 */
	public void setWorkingDir(String workingDir) {
		this.workingDir = workingDir;
	}

	
	/**
	 * setConfigFile(File configFile)
	 * @param configFile
	 */
	public void setConfigFile(File configFile) {
		this.configFile = configFile;
	}


}
