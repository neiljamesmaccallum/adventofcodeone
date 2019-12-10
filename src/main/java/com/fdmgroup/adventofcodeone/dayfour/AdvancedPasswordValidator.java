package com.fdmgroup.adventofcodeone.dayfour;

public class AdvancedPasswordValidator {

	public static boolean validatePassword(int password) {
		char[] passwordString = Integer.toString(password).toCharArray();
		boolean hasDoubleDigit = false;
		int doubleDigit = -1;
		for (int i = 1; i < passwordString.length; i++) {
			if (passwordString[i] < passwordString[i - 1]) {
				return false;
			}
			if (passwordString[i] == passwordString[i - 1] && doubleDigit == -1) {
				doubleDigit = passwordString[i];
				hasDoubleDigit = true;
			}
			if (i > 1) {
				if (passwordString[i] == passwordString[i - 1] && passwordString[i] == passwordString[i - 2]
						&& passwordString[i] == doubleDigit) {
					doubleDigit = -1;
					hasDoubleDigit = false;
				}
			}
		}

		if (!hasDoubleDigit)

		{
			return false;
		}
		return true;
	}

}
