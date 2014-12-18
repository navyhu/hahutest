package com.hahutest.testcontainer;

import java.util.ArrayList;

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
		ArrayList<? extends ITestScenario> testScenarios = parseTestScenarios(xmlTestScenarios);
		hahuTestSuite.setTestScenarios(testScenarios);
		
		return hahuTestSuite;
	}
	
	private ArrayList<? extends ITestScenario> parseTestScenarios(ArrayList<XMLTestScenario> xmlTestScenarios) {
		ArrayList<HahuTestScenario> testScenarios = new ArrayList<HahuTestScenario>();
		
		if (xmlTestScenarios == null) {
			return testScenarios;
		}
		
		//parse each test scenario from XML info
		for (int i = 0;i < xmlTestScenarios.size();i++) {
			XMLTestScenario xmlTestScenario = xmlTestScenarios.get(i);
			HahuTestScenario testScenario = (HahuTestScenario)parseTestScenario(xmlTestScenario);
			if (testScenario != null) {
				testScenarios.add(testScenario);
			}
		}
		
		return testScenarios;
	}
	
	private ITestScenario parseTestScenario(XMLTestScenario xmlTestScenario) {
		ITestScenario testScenario = new HahuTestScenario();
		
		if (xmlTestScenario == null) {
			return null;
		}
		
		//set the corresponding XMLTestScenario
		testScenario.setXMLTestScenario(xmlTestScenario);
		
		//set the scenario name
		String scenarioName = xmlTestScenario.getTestScenarioName();
		testScenario.setTestScenarioName(scenarioName);
		
		//
		
		return testScenario;
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
