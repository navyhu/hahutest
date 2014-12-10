package com.hahutest.testcontainer;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;

public interface ITestMethod {
	public void setTestClass(Class<?> testClass);
	public void setTestMethod(Method testMethod);
	public void setMethodParameters(Map<String, String> parameters);
	public void setMethodParameterValues(ArrayList<String> parameterValues);
	public void invokeTestMethod();
}
