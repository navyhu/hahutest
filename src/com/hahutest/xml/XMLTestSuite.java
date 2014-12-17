package com.hahutest.xml;

import java.util.ArrayList;

public class XMLTestSuite {
	private String mTestSuiteName;
	//private XMLTestScenario[] mXMLTestScenarios;
	private ArrayList<XMLTestScenario> mXMLTestScenarios;
	private ArrayList<String> mPackages;
	private ArrayList<String> mClasses;
	
	public ArrayList<XMLTestScenario> getXMLTestScenarios() {
		return mXMLTestScenarios;
	}

	public String getTestSuiteName() {
		return mTestSuiteName;
	}

	public void setTestSuiteName(String testSuiteName) {
		mTestSuiteName = testSuiteName;
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

	public void setXMLTestScenarios(ArrayList<XMLTestScenario> xMLTestScenarios) {
		mXMLTestScenarios = xMLTestScenarios;
	}
	
	public String toString() {
		String string = "suite: " + mTestSuiteName;
		
		//get packages and classes
		string += "\nClasses:\n" + mClasses.toString();
		string += "\nPackages:\n" + mPackages.toString();
		string += mXMLTestScenarios.toString();
		
		return string;
	}
}
