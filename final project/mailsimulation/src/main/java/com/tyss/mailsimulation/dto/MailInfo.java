package com.tyss.mailsimulation.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Mail_Info")
public class MailInfo {
	@Column
	@Id
	@GeneratedValue
	private int id;
	@Column
	private int from_id;
	@Column
	private int to_id;
	@Column
	private String subject;
	@Column
	private String message;
	@Column
	private String status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFrom_id() {
		return from_id;
	}
	public void setFrom_id(int from_id) {
		this.from_id = from_id;
	}
	public int getTo_id() {
		return to_id;
	}
	public void setTo_id(int to_id) {
		this.to_id = to_id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	}
