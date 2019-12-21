package com.tyss.mailsimulation.dto;

import java.util.List;

public class Response {

	private int status;
	private String message;
	private String description;
	private List<MailInfo> mails;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<MailInfo> getMails() {
		return mails;
	}
	public void setMails(List<MailInfo> mails) {
		this.mails = mails;
	}
	
}
