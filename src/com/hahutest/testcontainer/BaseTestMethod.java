package com.hahutest.testcontainer;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;

import com.hahutest.xml.XMLTestMethod;

public abstract class BaseTestMethod {
	protected Class<?> mTestClass;
	protected Method mTestMethod;
	protected String mTestMethodName;
	protected Map<String, String> mParameters;
	protected ArrayList<String> mParameterValues = null;
	protected ArrayList<String> mParameterNames;
	protected ITestScenario mTestScenario;
	protected XMLTestMethod mXMLTestMethod;
}
