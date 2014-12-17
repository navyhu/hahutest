package com.hahutest.testcontainer;

import java.util.ArrayList;

public class HahuTestScenario extends BaseTestScenario implements ITestScenario {
	@Override
	public void setTestClasses(ArrayList<Class<?>> testClasses) {
		mClasses = testClasses;
	}
	
	@Override
	public ArrayList<Class<?>> getTestClasses() {
		return mClasses;
	}
	
	@Override
	public void setTestPackages(ArrayList<String> testPackages) {
		mPackages = testPackages;
	}
	
	@Override
	public ArrayList<String> getTestPackages() {
		return mPackages;
	}
	
	@Override
	public void setTestScenarioName(String testSenarioName) {
		mTestScenarioName = testSenarioName;
	}
	
	@Override
	public String getTestSenarioName() {
		return mTestScenarioName;
	}
	
	@Override
	public void setTestMethods(ArrayList<ITestMethod> testMethods) {
		mTestMethods = testMethods;
	}
	
	@Override
	public ArrayList<ITestMethod> getTestMethods() {
		return mTestMethods;
	}
	
	@Override
	public void setTestSuite(ITestSuite testSuite) {
		mTestSuite = testSuite;
	}
	
	@Override
	public ITestSuite getTestSuite() {
		return mTestSuite;
	}
}
