package com.fdmgroup.adventofcodeone.dayfour;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestAdvancedPasswordValidator {

	int example1 = 112333;
	int example2 = 123444;
	int example3 = 111122;
	int example4 = 112222;

	@Test
	void test_AdvancedPasswordValidatorWorksOnExample1() {
		assertTrue(AdvancedPasswordValidator.validatePassword(example1));
	}
	
	@Test
	void test_AdvancedPasswordValidatorWorksOneExample2() {
		assertFalse(AdvancedPasswordValidator.validatePassword(example2));
	}
	
	@Test
	void test_AdvancedPasswordValidatorWorksOnExample3() {
		assertTrue(AdvancedPasswordValidator.validatePassword(example3));
	}
	
	@Test
	void test_AdvancedPasswordValidatorWorksOnExample4() {
		assertTrue(AdvancedPasswordValidator.validatePassword(example4));
	}

}
