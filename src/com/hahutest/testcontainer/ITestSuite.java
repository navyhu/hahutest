package com.hahutest.testcontainer;

import java.util.ArrayList;

public interface ITestSuite {
	public void setTestClasses(ArrayList<Class<?>> testClasses);
	public ArrayList<Class<?>> getTestClasses();
	
	public void setTestPackages(ArrayList<String> testPackages);
	public ArrayList<String> getTestPackages();
	
	public void setTestSuiteName(String testSuiteName);
	public String getTestSuiteName();
	
	public void setTestScenarios(ArrayList<ITestScenario> testScenarios);
	public ArrayList<ITestScenario> getTestScenarios();
}
