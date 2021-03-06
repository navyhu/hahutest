package com.hahutest.testcontainer;

import java.util.ArrayList;

import com.hahutest.xml.XMLTestSuite;

public interface ITestSuite {
	public void setTestClasses(ArrayList<Class<?>> testClasses);
	public ArrayList<Class<?>> getTestClasses();
	
	public void setTestPackages(ArrayList<String> testPackages);
	public ArrayList<String> getTestPackages();
	
	public void setTestSuiteName(String testSuiteName);
	public String getTestSuiteName();
	
	public void setTestScenarios(ArrayList<? extends ITestScenario> testScenarios);
	public ArrayList<? extends ITestScenario> getTestScenarios();
	
	public void setXMLTestSuite(XMLTestSuite xmlTestSuite);
	public XMLTestSuite getXMLTestSuite();
}
