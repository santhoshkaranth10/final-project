package com.tyss.mailsimulation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.mailsimulation.dao.MailSimulationDAO;
import com.tyss.mailsimulation.dto.MailInfo;
import com.tyss.mailsimulation.dto.UserInfo;

@Service
public class MailSimulationServiceImpl implements MailSimulationService {

	@Autowired
	private MailSimulationDAO dao;
	
	@Override
	public boolean deletePage(int id) {
		
		return dao.deletePage(id);
	}

	@Override
	public MailInfo composeEmail(MailInfo info) {

		return dao.composeEmail(info);
	}
	@Override
	public boolean userRegistration(UserInfo userinfo) {

	return dao.userRegistration(userinfo);
	}

	@Override
	public UserInfo login(String email, String password) {

	return dao.login(email, password);
	}

	@Override
	public boolean changePassword(UserInfo info) {

	return dao.changePassword(info);
	}
	
	 @Override
	 public boolean sendMail(MailInfo info) {
	 return dao.sendMail(info);
	 }

	 @Override
	 public MailInfo receiveMail(int id) {
	 return dao.receiveMail(id);
	 }

	 @Override
	 public List<MailInfo> getAllMails() {
	 return dao.getAllMails();
	 }

	 @Override
	 public List<MailInfo> sentMails() {
	 return dao.sentMails();
	 }

	 @Override
	 public List<MailInfo> draftMails() {
	 return dao.draftMails();
	 }

	 @Override
	 public List<MailInfo> inboxMails() {
	 return dao.inboxMails();
	 }


}
