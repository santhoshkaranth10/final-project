package com.tyss.mailsimulation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.mailsimulation.dto.MailInfo;
import com.tyss.mailsimulation.dto.UserInfo;

@Repository
public class MailSimulationDAOImpl implements MailSimulationDAO{

	@Autowired
	public EntityManagerFactory factory;
	
	@Override
	public boolean deletePage(int id) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
        transaction.begin();
        MailInfo info = manager.find(MailInfo.class, id);
        manager.remove(info);
        transaction.commit();
        return true;
        
	}catch(Exception e) {
		e.printStackTrace();
		return false;
	}

	}

	@Override
	public MailInfo composeEmail(MailInfo info) {
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	transaction.begin();
	manager.persist(info);
	transaction.commit();
	return info;
	}
	
	@Override
	public boolean userRegistration(UserInfo userInfo) {
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transection=manager.getTransaction();
	try {
	transection.begin();
	manager.persist(userInfo);
	transection.commit();
	return true;
	} catch (Exception e) {
	e.printStackTrace();
	return false;
	}
	}//end of registration() method

	@Override
	public UserInfo login(String email, String password) {
	   String jpql="from UserInfo where email=:email and password=:password";
	   EntityManager manager=factory.createEntityManager();
	   TypedQuery<UserInfo>query=manager.createQuery(jpql,UserInfo.class);
	   query.setParameter("email", email);
	   query.setParameter("password", password);
	   try {
	UserInfo info=query.getSingleResult();
	return info;
	} catch (Exception e) {
	e.printStackTrace();
	return null;
	}
	   
	}//end of login() method

	@Override
	public boolean changePassword(UserInfo info) {
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transection=manager.getTransaction();
	try {
	transection.begin();
	UserInfo info1=manager.find(UserInfo.class, info.getId());
	info1.setPassword(info.getPassword());
	transection.commit();
	return true;
	}catch (Exception e) {
	e.printStackTrace();
	return false;
	}

	}
	
	
	@Override
	public boolean sendMail(MailInfo info) {
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	try {
	transaction.begin();
	manager.persist(info);
	transaction.commit();
	return true;

	}catch(Exception e) {
	e.printStackTrace();
	return false;
	}

	}


	@Override
	public MailInfo receiveMail(int id)
	{
	EntityManager manager = factory.createEntityManager();
	MailInfo info = manager.find(MailInfo.class, id);

	return info;
	}


	@Override
	public List<MailInfo> getAllMails() {
	String jpql = "from MailInfo";
	EntityManager manager = factory.createEntityManager();
	TypedQuery<MailInfo> query = manager.createQuery(jpql, MailInfo.class);
	List<MailInfo> info = query.getResultList();
	return info;

	}


	@Override
	public List<MailInfo> sentMails() {
	String jpql = "from MailInfo where status='sent'";
	EntityManager manager = factory.createEntityManager();
	TypedQuery<MailInfo> query = manager.createQuery(jpql, MailInfo.class);
	List<MailInfo> info = query.getResultList();
	return info;

	}


	@Override
	public List<MailInfo> draftMails() {

	String jpql = "from MailInfo where status='draft'";
	EntityManager manager = factory.createEntityManager();
	TypedQuery<MailInfo> query = manager.createQuery(jpql, MailInfo.class);
	List<MailInfo> info = query.getResultList();
	return info;
	}


	@Override
	public List<MailInfo> inboxMails() {
	String jpql = "from MailInfo where uid='from_id'";
	EntityManager manager = factory.createEntityManager();
	TypedQuery<MailInfo> query = manager.createQuery(jpql, MailInfo.class);
	List<MailInfo> info = query.getResultList();
	return info;

	}


}
