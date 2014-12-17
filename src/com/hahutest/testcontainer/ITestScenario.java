package com.hahutest.testcontainer;

import java.util.ArrayList;

import com.hahutest.xml.XMLTestScenario;

public interface ITestScenario {
	public void setTestClasses(ArrayList<Class<?>> testClasses);
	public ArrayList<Class<?>> getTestClasses();
	
	public void setTestPackages(ArrayList<String> testPackages);
	public ArrayList<String> getTestPackages();
	
	public void setTestScenarioName(String testSenarioName);
	public String getTestSenarioName();
	
	public void setTestMethods(ArrayList<ITestMethod> testMethods);
	public ArrayList<ITestMethod> getTestMethods();
	
	public void setTestSuite(ITestSuite testSuite);
	public ITestSuite getTestSuite();
	
	public void setXMLTestScenario(XMLTestScenario xmlTestScenario);
	public XMLTestScenario getXMLTestScenario();
}
