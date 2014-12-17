package com.hahutest.testcontainer;

import java.util.ArrayList;

public class HahuTestSuite extends BaseTestSuite implements ITestSuite {
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
	public void setTestSuiteName(String testSuiteName) {
		mTestSuiteName = testSuiteName;
	}
	
	@Override
	public String getTestSuiteName() {
		return mTestSuiteName;
	}
	
	@Override
	public void setTestScenarios(ArrayList<ITestScenario> testScenarios) {
		mTestScenarios = testScenarios;
	}
	
	@Override
	public ArrayList<ITestScenario> getTestScenarios() {
		return mTestScenarios;
	}
}
