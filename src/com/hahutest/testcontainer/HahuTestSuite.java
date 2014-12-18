package com.hahutest.testcontainer;

import java.util.ArrayList;

import com.hahutest.xml.XMLTestSuite;

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
	public void setTestScenarios(ArrayList<? extends ITestScenario> testScenarios) {
		mTestScenarios = testScenarios;
	}
	
	@Override
	public ArrayList<? extends ITestScenario> getTestScenarios() {
		return mTestScenarios;
	}
	
	@Override
	public void setXMLTestSuite(XMLTestSuite xmlTestSuite) {
		mXMLTestSuite = xmlTestSuite;
	}
	
	@Override
	public XMLTestSuite getXMLTestSuite() {
		return mXMLTestSuite;
	}
}
