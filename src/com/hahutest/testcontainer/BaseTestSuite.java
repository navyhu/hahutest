package com.hahutest.testcontainer;

import java.util.ArrayList;

import com.hahutest.xml.XMLTestSuite;

public class BaseTestSuite {
	protected String mTestSuiteName;
	protected ArrayList<ITestScenario> mTestScenarios;
	protected ArrayList<Class<?>> mClasses;
	protected ArrayList<String> mPackages;
	protected XMLTestSuite mXMLTestSuite;
}
