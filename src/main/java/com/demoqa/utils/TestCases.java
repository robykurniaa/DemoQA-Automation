package com.demoqa.utils;

public enum TestCases {

	T1("Testing TextBox");

	private String testName;

	TestCases(String value) {
		this.testName = value;
	}

	public String getTestName() {
		return testName;
	}

}
