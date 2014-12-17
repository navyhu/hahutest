package com.hahutest.testcontainer;

import java.util.ArrayList;

import com.hahutest.xml.XMLTestScenario;

public class BaseTestScenario {
	protected String mTestScenarioName;
	protected ITestSuite mTestSuite;
	protected ArrayList<ITestMethod> mTestMethods;
	protected ArrayList<Class<?>> mClasses;
	protected ArrayList<String> mPackages;
	protected XMLTestScenario mXMLTestScenario;
}
