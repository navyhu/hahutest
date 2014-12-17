package com.hahutest.testcontainer;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;

import com.hahutest.xml.XMLTestMethod;

public interface ITestMethod {
	public void setTestClass(Class<?> testClass);
	public Class<?> getTestClass();
	
	public void setTestMethod(Method testMethod);
	public Method getTestMethod();
	
	public void setMethodParameters(Map<String, String> parameters);
	public Map<String, String> getMethodParameters();
	
	public void setMethodParameterValues(ArrayList<String> parameterValues);
	public ArrayList<String> getMethodParameterValues();
	
	public void invokeTestMethod();
	
	public void setTestScenario(HahuTestScenario testScenario);
	public ITestScenario getTestScenario();
	
	public void setXMLTestMethod(XMLTestMethod xmlTestMethod);
	public XMLTestMethod getXMLTestMethod();
}
