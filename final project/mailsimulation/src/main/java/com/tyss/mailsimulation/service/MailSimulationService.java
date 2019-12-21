package com.tyss.mailsimulation.service;

import java.util.List;

import com.tyss.mailsimulation.dto.MailInfo;
import com.tyss.mailsimulation.dto.UserInfo;

public interface MailSimulationService {

	public boolean deletePage(int id); 
	public MailInfo composeEmail(MailInfo info);
	public boolean userRegistration(UserInfo userinfo);
	public UserInfo login(String email,String password);
	public boolean changePassword(UserInfo info);
	public boolean sendMail(MailInfo info);
	public MailInfo receiveMail(int id);
	public List<MailInfo> getAllMails();
	public List<MailInfo> sentMails();
	public List<MailInfo> draftMails();
	public List<MailInfo> inboxMails();
	
}
