package com.hahutest.exception;

public class XMLParseFailedException extends Exception {
	@Override
	public String toString() {
		return "Failed to parse xml file";
	}
}
