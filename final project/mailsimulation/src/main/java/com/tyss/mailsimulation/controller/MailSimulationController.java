package com.tyss.mailsimulation.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.mailsimulation.dto.MailInfo;
import com.tyss.mailsimulation.dto.Response;
import com.tyss.mailsimulation.service.MailSimulationService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MailSimulationController {

	@Autowired
	private MailSimulationService service;
	
	@DeleteMapping(path="/delete/{id}",
	 consumes=MediaType.APPLICATION_JSON_VALUE,
	 produces=MediaType.APPLICATION_JSON_VALUE)
	public Response deletePage(@PathVariable("id") int id) {
		Response response = new Response();
		if(service.deletePage(id)) {
			response.setStatus(201);
			response.setMessage("success");
			response.setDescription("mail deleted successfully");
			}else {
				response.setStatus(401);
				response.setMessage("failed");
				response.setDescription("mail is not deleted");
			}
		return response;
	}
	
	@PostMapping(path="/compose",consumes=MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Response composeEmail(@RequestBody MailInfo info) {
		Response response = new Response();
		MailInfo info1 =  service.composeEmail(info);
		if(info1!=null) {
			response.setStatus(201);
			response.setMessage("success");
			response.setDescription("mail composed");
			
		}else {
			response.setStatus(401);
			response.setMessage("failed");
			response.setDescription("mail not composing");
			
		}
		return response;
	}
	
	
	@PostMapping(path = "/sendmail" ,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
	public Response sendingMail(@RequestBody MailInfo info) {
	Response response = new Response();
	if(service.sendMail(info)) {
	response.setStatus(201);
	response.setMessage("success");
	response.setDescription("mail sent");
	}else {
	response.setStatus(401);
	response.setMessage("Failure");
	response.setDescription("send to fail");
	}
	return response;
	}

	@GetMapping(path = "/getallmails", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getAllMails(){
	Response response = new Response();
	List<MailInfo> mailInfo = service.getAllMails();
	if(!mailInfo.isEmpty()) {
	response.setStatus(201);
	response.setMessage("success");
	response.setDescription("Mails found");
	response.setMails(mailInfo);
	
	}else {
	response.setStatus(401);
	response.setMessage("Failure");
	response.setDescription("Data not found");
	}

	return response;
	}

	@GetMapping(path = "/getmail" , produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getMail(@RequestParam("id")int id) {
	Response response = new Response();
	MailInfo mailInfo = service.receiveMail(id);
	if(mailInfo != null) {
	response.setStatus(201);
	response.setMessage("success");
	response.setDescription("Mail found");
	response.setMails(Arrays.asList(mailInfo));
	}else {
	response.setStatus(401);
	response.setMessage("Failure");
	response.setDescription("Mail not found");
	}

	return response;
	}

	@GetMapping(path = "/sentmails", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getAllSentMails(){
	Response response = new Response();
	List<MailInfo> mailInfo = service.sentMails();
	if(!mailInfo.isEmpty()) {
	response.setStatus(201);
	response.setMessage("success");
	response.setDescription("sent mails found");
	response.setMails(mailInfo);
	}else {
	response.setStatus(401);
	response.setMessage("Failure");
	response.setDescription("Data not found");
	}

	return response;
	}

	@GetMapping(path = "/draftmails", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getAllDraftMails(){
	Response response = new Response();
	List<MailInfo> mailInfo = service.draftMails();
	if(!mailInfo.isEmpty()) {
	response.setStatus(201);
	response.setMessage("success");
	response.setDescription("draft mails found");
	response.setMails(mailInfo);
	}else {
	response.setStatus(401);
	response.setMessage("Failure");
	response.setDescription("Data not found");
	}

	return response;
	}

	@GetMapping(path = "/inbox", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response inbox(){
	Response response = new Response();
	List<MailInfo> mailInfo = service.inboxMails();
	if(!mailInfo.isEmpty()) {
	response.setStatus(201);
	response.setMessage("success");
	response.setDescription("mails in inbox found");
	response.setMails(mailInfo);
	}else {
	response.setStatus(401);
	response.setMessage("Failure");
	response.setDescription("Data not found");
	}

	return response;
	}

}
