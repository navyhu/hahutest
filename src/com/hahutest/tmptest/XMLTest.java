package com.hahutest.tmptest;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.hahutest.exception.XMLParseFailedException;
import com.hahutest.xml.XMLParser;
import com.hahutest.xml.XMLTestSuite;

public class XMLTest {
	public static void main(String[] args) {
		String sXMLpath = "C:\\Users\\Administrator\\workspace2\\HahuTest\\resources\\HahuTest.xml";
		
		try {
			XMLTestSuite testSuite = new XMLParser().parse(sXMLpath);
			System.out.println(testSuite);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (XMLParseFailedException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
