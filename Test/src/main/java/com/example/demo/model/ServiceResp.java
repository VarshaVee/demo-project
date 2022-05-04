package com.example.demo.model;

public class ServiceResp {

	private String status;
	private String message;
	private String errorMessage;
	private int statusCode;
	private Object resp;


	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public Object getResp() {
		return resp;
	}
	public void setResp(Object resp) {
		this.resp = resp;
	}
}
