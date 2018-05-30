package com.cwp.alice.dto;

public class AliceConversationDetails {
	private String message;
	private String messageType;
	private String messageDataType;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public String getMessageDataType() {
		return messageDataType;
	}
	public void setMessageDataType(String messageDataType) {
		this.messageDataType = messageDataType;
	}
	
}
