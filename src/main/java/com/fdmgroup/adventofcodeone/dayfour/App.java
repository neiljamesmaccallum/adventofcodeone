package com.fdmgroup.adventofcodeone.dayfour;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		List<Integer> validPasswords = new ArrayList<>();
		for (int i = 271973; i <= 785961; i++) {
			if(PasswordValidator.isValidPassword(i)) {
				validPasswords.add(i);
			}
		}
		System.out.println(validPasswords.size());
		validPasswords = new ArrayList<>();
		for (int i = 271974; i < 785961; i++) {
			if(AdvancedPasswordValidator.validatePassword(i)) {
				validPasswords.add(i);
			}
		}
		System.out.println(validPasswords.size());
	}
}
