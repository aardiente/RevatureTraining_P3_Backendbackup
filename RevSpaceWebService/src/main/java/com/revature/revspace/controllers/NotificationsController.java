package com.revature.revspace.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.revspace.models.Notifications;
import com.revature.revspace.services.NotificationService;
import com.revature.revspace.services.UserService;


@RestController
@RequestMapping(value="/notifications")
@CrossOrigin(origins="*")
public class NotificationsController {
	
	
	private NotificationService nServ;
	private UserService uServ;
	public NotificationsController () {
		
		
	}
	
	public NotificationsController (NotificationService nServ, UserService uServ) {
		super();
		this.nServ = nServ;
		this.uServ = uServ;
		
	}
	
	@CrossOrigin(origins="*")
	@GetMapping
	public @ResponseBody List<Notifications> getAllNotifications() {
		return UserController.loginUser.getList();
	}
	
	@GetMapping(value="/{notiId}") 
	public ResponseEntity<Notifications> getNotificationById(@PathVariable("notiId") String notiId) {
		Notifications nmodl = nServ.getNotificationById(notiId);
		return ResponseEntity.status(200).body(nmodl);
		
		
	}
		
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<List<Notifications>> addNotification(@RequestBody Notifications nmodl) {
		if(nServ.getNotificationById(nmodl.getMessage())==null) {
			nServ.addNotification(nmodl);
			return  ResponseEntity.status(201).body(nServ.getAllNotifications());
		}
		return  ResponseEntity.noContent().build();
	}
	
	
	@DeleteMapping("/{notiId}")
	public ResponseEntity<Notifications> deleteNotification(@PathVariable("notId") String notiId) {
		Optional<Notifications> notiOpt = Optional.ofNullable(nServ.getNotificationById(notiId));
		if (notiOpt.isPresent()) {
			nServ.deleteNotification(notiOpt.get());
			return ResponseEntity.status(200).body(notiOpt.get());
		}
		return ResponseEntity.notFound().build();
	}

}
