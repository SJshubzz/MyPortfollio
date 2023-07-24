package com.validation;

public class Validation {
	private String result;

	public String validate(String name, String email, String message) {
		int nameLength = name.length();
		int emailLength = email.length();
		int messegeLength = message.length();

		if (nameLength < 2 || nameLength > 30)
			result = "Invalid name...";
		else if (emailLength < 5 || emailLength > 50) {
			result = "Invalid email";
		} else if (messegeLength < 10) {
			result = "Message is to short...";
		} else if (messegeLength > 500) {
			result = "Message is to long...";
		} else {
			result = "Valid";
		}
		return result;
	}

}
