package com.osanda.bankDeposit.util;

import java.util.HashMap;
import java.util.Map;

public class ResponseMessage {

	public static synchronized Map<String, String> createErrorMessage(String message) {

		Map<String, String> response = new HashMap<>();
		response.put("error", message);

		return response;

	}// createErrorMessage

}// ResponseMessage _+
