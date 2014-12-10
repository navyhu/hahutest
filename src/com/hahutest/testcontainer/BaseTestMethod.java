package com.hahutest.testcontainer;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;

public abstract class BaseTestMethod {
	protected Class<?> mTestClass;
	protected Method mTestMethod;
	protected Map<String, String> mParameters;
	protected ArrayList<String> mParameterValues = null;
	protected ArrayList<String> mParameterNames;
}
