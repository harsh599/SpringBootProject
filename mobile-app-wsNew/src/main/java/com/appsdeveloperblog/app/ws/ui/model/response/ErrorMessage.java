package com.appsdeveloperblog.app.ws.ui.model.response;

import java.util.Date;

public class ErrorMessage {

	private String statusMessage;
	private String statusCode;
	private Date timeStamp;

	public ErrorMessage() {
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public ErrorMessage(String statusMessage, String statusCode, Date timeStamp) {
		super();
		this.statusMessage = statusMessage;
		this.statusCode = statusCode;
		this.timeStamp = timeStamp;
	}

}
