package com.hahutest.xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.hahutest.exception.XMLParseFailedException;
import com.hahutest.xml.dom.XMLNodes;

public class XMLParser {
	public XMLTestSuite parse(String filePath) throws ParserConfigurationException,
								IOException, SAXException, XMLParseFailedException {
		//XMLHahuTest hahuTest = new XMLHahuTest();
		File xmlFile = new File(filePath);
	
		DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	
		Document xmlDoc = docBuilder.parse(xmlFile);
		
		XMLTestSuite hahuSuite = parse(xmlDoc);
	
		return hahuSuite;
	}
	
	public XMLTestSuite parse(Document doc) throws XMLParseFailedException{
		/*
		 * parse the suite level
		 */
		Element root = doc.getDocumentElement();
		
		//make sure the root node is 'suite'
		if (root.getNodeName() != XMLNodes.sElementSuite) {
			throw new XMLParseFailedException();
		}
		XMLTestSuite testSuite = parseSuite(root);
		
		return testSuite;
	}
	
	public XMLTestSuite parseSuite(Element node) {
		XMLTestSuite testSuite = new XMLTestSuite();
		ArrayList<String> classes = new ArrayList<String>();
		ArrayList<String> packages = new ArrayList<String>();
		ArrayList<XMLTestScenario> testScenarios = new ArrayList<XMLTestScenario>();
		
		//get the suite name
		String suiteName = node.getAttribute(XMLNodes.sAttrName);
		testSuite.setTestSuiteName(suiteName);
		
		//get all child nodes of suite
		NodeList childrenOfSuite = node.getChildNodes();
		
		//parse the children of suite
		for (int i = 0;i < childrenOfSuite.getLength(); i++) {
			Node element = childrenOfSuite.item(i);
			String elementName = element.getNodeName();
			
			switch(elementName) {
			case XMLNodes.sElementPackage:
				packages.add(element.getTextContent());
				break;
			case XMLNodes.sElementClass:
				classes.add(element.getTextContent());
				break;
			case XMLNodes.sElementScenario:
				XMLTestScenario testScenario = parseScenario((Element)element);
				testScenario.setTestSuite(testSuite);
				testScenarios.add(testScenario);
				break;
			}
		}
		
		testSuite.setClasses(classes);
		testSuite.setPackages(packages);
		testSuite.setXMLTestScenarios(testScenarios);
		
		return testSuite;
	}
	
	public XMLTestScenario parseScenario(Element node) {
		XMLTestScenario testScenario = new XMLTestScenario();
		ArrayList<String> packages = new ArrayList<String>();
		ArrayList<String> classes = new ArrayList<String>();
		ArrayList<XMLTestMethod> testMethods = new ArrayList<XMLTestMethod>();
		
		//get scenario name
		String scenarioName = node.getAttribute(XMLNodes.sAttrName);//node.getNodeName();
		testScenario.setTestScenarioName(scenarioName);
		
		//get all child nodes under scenario
		NodeList childrenOfScenario = node.getChildNodes();
		
		//parse the children nodes of scenario
		for (int i = 0;i < childrenOfScenario.getLength();i++) {
			Node element = childrenOfScenario.item(i);
			String elementName = element.getNodeName();
			
			switch(elementName) {
			case XMLNodes.sElementPackage:
				packages.add(element.getTextContent());
				break;
			case XMLNodes.sElementClass:
				classes.add(element.getTextContent());
				break;
			case XMLNodes.sElementMethod:
				XMLTestMethod testMethod = parseMethod((Element)element);
				testMethod.setXMLTestSenario(testScenario);
				testMethods.add(testMethod);
				break;
			}
		}
		
		testScenario.setClasses(classes);
		testScenario.setPackages(packages);
		testScenario.setXMLMethods(testMethods);
		
		return testScenario;
	}
	
	public XMLTestMethod parseMethod(Element node) {
		XMLTestMethod testMethod = new XMLTestMethod();
		String className = null;
		Map<String, String> parameters = new HashMap<String, String>();
		
		//get method name
		String methodName = node.getAttribute(XMLNodes.sAttrName);
		testMethod.setTestMethodName(methodName);
		
		//get all child nodes under method
		NodeList childrenOfMethod = node.getChildNodes();
		
		for (int i = 0;i < childrenOfMethod.getLength();i++) {
			Node element = childrenOfMethod.item(i);
			String elementName = element.getNodeName();
			
			switch(elementName) {
			case XMLNodes.sElementClass:
				className = element.getTextContent();
				break;
			case XMLNodes.sElementParameter:
				Element ele = (Element)element;
				String pName = ele.getAttribute(XMLNodes.sAttrName);
				String pValue = ele.getAttribute(XMLNodes.sAttrValue);
				parameters.put(pName, pValue);
				break;
			}
		}
		
		testMethod.setParameters(parameters);
		testMethod.setClassName(className);
		
		return testMethod;
	}
}
