package com.hahutest.xml;

import java.util.ArrayList;

public class XMLTestScenario {
	private String mTestScenarioName;
	private XMLTestSuite mTestSuite; //belong to this suite
	private ArrayList<String> mPackages;
	private ArrayList<String> mClasses;
	private ArrayList<XMLTestMethod> mXMLMethods;
	
	public String getTestScenarioName() {
		return mTestScenarioName;
	}
	
	public void setTestScenarioName(String testScenarioName) {
		mTestScenarioName = testScenarioName;
	}
	
	public XMLTestSuite getTestSuite() {
		return mTestSuite;
	}
	
	public void setTestSuite(XMLTestSuite testSuite) {
		mTestSuite = testSuite;
	}
	
	public ArrayList<String> getPackages() {
		return mPackages;
	}
	
	public void setPackages(ArrayList<String> packages) {
		mPackages = packages;
	}
	
	public ArrayList<String> getClasses() {
		return mClasses;
	}
	
	public void setClasses(ArrayList<String> classes) {
		mClasses = classes;
	}
	
	public ArrayList<XMLTestMethod> getXMLMethods() {
		return mXMLMethods;
	}
	
	public void setXMLMethods(ArrayList<XMLTestMethod> methods) {
		mXMLMethods = methods;
	}
	
	public String toString() {
		String string = "\nscenario: " + mTestScenarioName + "\n";
		
		//get packages and classes
		string += "\nPackages:\n" + mPackages.toString();
		string += "\nClasses:\n" + mClasses.toString();
		string += mXMLMethods.toString();
		
		return string;
	}
}
