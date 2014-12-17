package com.hahutest.xml;

import java.util.Map;

public class XMLTestMethod {
	private String mTestMethodName;
	private String mClassName;
	private String mClassFullName;
	private XMLTestScenario mXMLTestSenario;
	private Map<String, String> mParameters;
	
	public String getTestMethodName() {
		return mTestMethodName;
	}
	
	public String getClassName() {
		return mClassName;
	}

	public String getClassFullName() {
		return mClassFullName;
	}

	public void setClassFullName(String classFullName) {
		mClassFullName = classFullName;
	}

	public XMLTestScenario getXMLTestSenario() {
		return mXMLTestSenario;
	}

	public void setXMLTestSenario(XMLTestScenario xMLTestSenario) {
		mXMLTestSenario = xMLTestSenario;
	}

	public Map<String, String> getParameters() {
		return mParameters;
	}

	public void setParameters(Map<String, String> parameters) {
		mParameters = parameters;
	}

	public void setTestMethodName(String testMethodName) {
		mTestMethodName = testMethodName;
	}

	public void setClassName(String className) {
		mClassName = className;
	}
	
	public String toString() {
		String string = "\nmethod: " + mTestMethodName + "\n";
		
		//get class and parameters
		string += "\nClass:\n" + mClassName;
		string += "\nParameters:\n" + mParameters.toString();
		
		return string;
	}
}
