package com.appsdeveloperblog.app.ws.ui.model.response;

public enum ErrorMessages {

	INTERNAL_SERVER_ERROR(
			"Some thing went wrong! Plz Contact us"),
	RECORD_ALREADY_EXISTS("Data already exists"), NO_RECORD_FOUND("No record found with given details"),
	BAD_REQUEST("Bad Input made");

	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	private ErrorMessages(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
