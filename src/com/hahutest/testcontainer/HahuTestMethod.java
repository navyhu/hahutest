package com.hahutest.testcontainer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;

public class HahuTestMethod extends BaseTestMethod implements ITestMethod {
	@Override
	public void setTestClass(Class<?> testClass) {
		mTestClass = testClass;
	}
	
	@Override
	public void setTestMethod(Method testMethod) {
		mTestMethod = testMethod;
	}
	
	@Override
	public void setMethodParameters(Map<String, String> parameters) {
		mParameters = parameters;
	}
	
	@Override
	public void setMethodParameterValues(ArrayList<String> parameterValues) {
		mParameterValues = parameterValues;
	}
	
	@Override
	public void invokeTestMethod() {
		if (mTestMethod == null) {
			return;
		}
		
		try {
			Object testClassObj = mTestClass.newInstance();
			mTestMethod.setAccessible(true);
			if (mParameterValues != null) {
				mTestMethod.invoke(testClassObj, mParameterValues.toArray());
			} else {
				mTestMethod.invoke(testClassObj);
			}
		} catch (InstantiationException exception) {
			System.out.println(exception.getStackTrace());
		} catch (IllegalAccessException exception) {
			System.out.println(exception.getStackTrace());	
		} catch (InvocationTargetException exception) {
			System.out.println(exception.getStackTrace());
		}
		
	}
	
	@Override
	public Class<?> getTestClass() {
		return mTestClass;
	}
	
	@Override
	public Method getTestMethod() {
		return mTestMethod;
	}
	
	@Override
	public Map<String, String> getMethodParameters() {
		return mParameters;
	}
	
	@Override
	public ArrayList<String> getMethodParameterValues() {
		return mParameterValues;
	}
	
	@Override
	public void setTestScenario(HahuTestScenario testScenario) {
		mTestScenario = testScenario;
	}
	
	@Override
	public ITestScenario getTestScenario() {
		return mTestScenario;
	}
}
