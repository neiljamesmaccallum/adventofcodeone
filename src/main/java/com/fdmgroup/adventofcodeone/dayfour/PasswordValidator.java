package com.fdmgroup.adventofcodeone.dayfour;

public class PasswordValidator {

	public static boolean isValidPassword(int password) {
		char[] passwordString = Integer.toString(password).toCharArray();
		boolean hasDoubleDigit = false;
		for(int i=1; i<passwordString.length;i++) {
			if(passwordString[i]<passwordString[i-1]) {
				return false;
			}
			if(passwordString[i]==passwordString[i-1]) {
				hasDoubleDigit=true;
			}
		}
		if(!hasDoubleDigit) {
			return false;
		}
		return true;
	}

}
