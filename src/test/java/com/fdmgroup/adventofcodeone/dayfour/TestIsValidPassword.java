package com.fdmgroup.adventofcodeone.dayfour;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestIsValidPassword {

	int example2 = 223450;
	int example3 = 123789;
		
	@Test
	void test_SimpleValidPasswordIsRecognised(){
		int input = 111111;
		assertTrue(PasswordValidator.isValidPassword(input));
	}
	
	@Test
	void test_SimpleInvalidPasswordIsRecognised() {
		int input = 900000;
		assertFalse(PasswordValidator.isValidPassword(input));
	}
	
	@Test
	void test_CorrectlyIdentifiesPasswordValidity_One() {
		assertFalse(PasswordValidator.isValidPassword(example2));
	}
	
	@Test
	void test_CorrectlyIdentifiesPasswordValidity_Two() {
		assertFalse(PasswordValidator.isValidPassword(example3));
	}
}