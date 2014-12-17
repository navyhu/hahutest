package com.hahutest.xml.dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.hahutest.xml.XMLHahuTest;
import com.hahutest.xml.XMLTestSuite;

public class DomUtil {
	
	public static XMLHahuTest parse(String filePath) throws ParserConfigurationException {
		XMLHahuTest hahuTest = new XMLHahuTest();
		File xmlFile = new File(filePath);
		
		DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		
		try {
			Document xmlDoc = docBuilder.parse(xmlFile);
			Element root = xmlDoc.getDocumentElement(); 
			System.out.println(root.getNodeName());
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		
		return hahuTest;
	}
	
	public XMLTestSuite parse(Document doc) {
		XMLTestSuite testSuite = new XMLTestSuite();
		
		return testSuite;
	}
}
