package com.hahutest.testcontainer;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.hahutest.xml.XMLTestMethod;
import com.hahutest.xml.XMLTestScenario;
import com.hahutest.xml.XMLTestSuite;

/**
 * 
 * @author Navyhu
 * @description This class is used to parse test information from XML classes. 
 * Test information includes test suite, test scenarios, test methods.
 */
public class TestParser {
	public ITestSuite parseTestSuite(XMLTestSuite xmlTestSuite) {
		//make sure the object is valid
		if (xmlTestSuite == null) {
			return null;
		}
		
		HahuTestSuite hahuTestSuite = new HahuTestSuite();
		hahuTestSuite.setXMLTestSuite(xmlTestSuite);
		
		//get test suit name
		hahuTestSuite.setTestSuiteName(xmlTestSuite.getTestSuiteName());
		
		//get packages
		ArrayList<String> packages = parsePackages(xmlTestSuite.getPackages());
		hahuTestSuite.setTestPackages(packages);
		
		//get classes
		ArrayList<Class<?>> classes = parseClasses(xmlTestSuite.getClasses());
		hahuTestSuite.setTestClasses(classes);
		
		//parse and get TestScenarios
		ArrayList<XMLTestScenario> xmlTestScenarios = xmlTestSuite.getXMLTestScenarios();
		ArrayList<? extends ITestScenario> testScenarios = parseTestScenarios(xmlTestScenarios, hahuTestSuite);
		hahuTestSuite.setTestScenarios(testScenarios);
		
		return hahuTestSuite;
	}
	
	private ArrayList<? extends ITestScenario> parseTestScenarios(
			ArrayList<XMLTestScenario> xmlTestScenarios, 
			ITestSuite hahuTestSuite) {
		ArrayList<HahuTestScenario> hahuTestScenarios = new ArrayList<HahuTestScenario>();
		
		if (xmlTestScenarios == null) {
			return hahuTestScenarios;
		}
		
		//parse each test scenario from XML info
		for (int i = 0;i < xmlTestScenarios.size();i++) {
			XMLTestScenario xmlTestScenario = xmlTestScenarios.get(i);
			HahuTestScenario testScenario = (HahuTestScenario)parseTestScenario(xmlTestScenario, hahuTestSuite);
			if (testScenario != null) {
				hahuTestScenarios.add(testScenario);
			}
		}
		
		return hahuTestScenarios;
	}
	
	private ITestScenario parseTestScenario(XMLTestScenario xmlTestScenario, ITestSuite hahuTestSuite) {
		ITestScenario hahuTestScenario = new HahuTestScenario();
		
		if (xmlTestScenario == null) {
			return null;
		}
		
		//set the corresponding XMLTestScenario
		hahuTestScenario.setXMLTestScenario(xmlTestScenario);
		
		//set the scenario name
		String scenarioName = xmlTestScenario.getTestScenarioName();
		hahuTestScenario.setTestScenarioName(scenarioName);
		
		//set the contained Test Suite
		hahuTestScenario.setTestSuite(hahuTestSuite);
		
		//get packages
		ArrayList<String> packages = parsePackages(xmlTestScenario.getPackages());
		hahuTestScenario.setTestPackages(packages);
		
		//get classes
		ArrayList<Class<?>> classes = parseClasses(xmlTestScenario.getClasses());
		hahuTestScenario.setTestClasses(classes);
		
		//get and parse methods
		ArrayList<XMLTestMethod> xmlTestMethods = xmlTestScenario.getXMLMethods();
		ArrayList<? extends ITestMethod> hahuTestMethods = parseTestMethods(xmlTestMethods, hahuTestScenario);
		hahuTestScenario.setTestMethods(hahuTestMethods);
		
		return hahuTestScenario;
	}
	
	private ArrayList<? extends ITestMethod> parseTestMethods(
			ArrayList<XMLTestMethod> xmlTestMethods, 
			ITestScenario hahuTestScenario) {
		ArrayList<HahuTestMethod> hahuTestMethods = new ArrayList<HahuTestMethod>();
		
		if (xmlTestMethods == null) {
			return hahuTestMethods;
		}
		
		//parse each xmlTestMethod
		for (int i = 0;i < xmlTestMethods.size();i++) {
			XMLTestMethod xmlTestMethod = xmlTestMethods.get(i);
			HahuTestMethod hahuTestMethod = (HahuTestMethod)parseTestMethod(xmlTestMethod, hahuTestScenario);
			hahuTestMethods.add(hahuTestMethod);
		}
		
		return hahuTestMethods;
	}
	
	private ITestMethod parseTestMethod(XMLTestMethod xmlTestMethod, ITestScenario hahuTestScenario) {
		ITestMethod hahuTestMethod = new HahuTestMethod();
		
		//set test method name
		hahuTestMethod.setTestMethodName(xmlTestMethod.getTestMethodName());
		
		//set the corresponding xmlTestMethod
		hahuTestMethod.setXMLTestMethod(xmlTestMethod);
		
		//set the contained test scenario
		hahuTestMethod.setTestScenario(hahuTestScenario);
		
		//get Parameters
		Map<String, String> xmlParameters = xmlTestMethod.getParameters();
		Map<String, String> parameters = parseParameters(xmlParameters);
		
		//get class
		String className = xmlTestMethod.getClassName();
		try {
			Class<?> oClass = Class.forName(className);
			hahuTestMethod.setTestClass(oClass);
		} catch (ClassNotFoundException e) {
			//log an error
		}
		
		//get method
		Method method = parseMethod(hahuTestMethod);
		hahuTestMethod.setTestMethod(method);;
		
		return hahuTestMethod;
	}
	
	private Method parseMethod(ITestMethod hahuTestMethod) {
		Method method = null;
		
		//get method name
		String methodName = hahuTestMethod.getTestMethodName();
		
		//try to get Method from the Method Class
		
		
		return method;
	}
	
	private Map<String, String> parseParameters(Map<String, String> xmlParameters) {
		Map<String, String> parameters = new HashMap<String, String>();

		//copy the names and values to the new Map
		parameters.putAll(xmlParameters);
		
		return parameters;
	}
	
	private ArrayList<Class<?>> parseClasses(ArrayList<String> stringClasses) {
		ArrayList<Class<?>> classes = new ArrayList<Class<?>>();
		if (stringClasses == null) {
			return classes;
		}
		
		//get corresponding Class objects
		for (int i = 0;i < stringClasses.size();i++) {
			try {
				Class<?> oClass = Class.forName(stringClasses.get(i));
				classes.add(oClass);
			} catch (ClassNotFoundException e) {
				//log an error
			}
		}
		
		return classes;
	}
	
	private ArrayList<String> parsePackages(ArrayList<String> packages) {
		ArrayList<String> newPackages = new ArrayList<String>();
		
		if (packages == null) {
			return newPackages;
		}
		
		//simply copy the packages to a new arraylist<string>
		for (int i = 0;i < packages.size();i++) {
			newPackages.add(packages.get(i));
		}
		
		return newPackages;
	}
}
