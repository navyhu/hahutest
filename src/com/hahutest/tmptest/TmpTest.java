package com.hahutest.tmptest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import com.hahutest.annotation.Test;
import com.hahutest.testcontainer.HahuTestMethod;

public class TmpTest {
	
	@Test
	public void testMethod() {
		System.out.println("Let's rock!");
	}
	
	public static void main(String[] args) {
		HahuTestMethod myTest = new HahuTestMethod();
		Class<?> testClass = TmpTest.class;
		Method testMethod = null;
		
		Class testAnnotation = Test.class;
		
		Method[] testMethods = testClass.getDeclaredMethods();
		for (Method method : testMethods) {
			 if (method.isAnnotationPresent(testAnnotation)) {
				 testMethod = method;
				 break;
			 }
		}
		
		myTest.setTestClass(testClass);
		myTest.setTestMethod(testMethod);
		
		myTest.invokeTestMethod();
	}
}
