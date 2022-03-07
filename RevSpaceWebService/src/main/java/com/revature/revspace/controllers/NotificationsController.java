package com.revature.revspace.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.revspace.models.Notifications;
import com.revature.revspace.services.NotificationService;
import com.revature.revspace.services.UserService;


@RestController
public class NotificationsController {
	
	
	private NotificationService nServ;
	private UserService uServ;
	public NotificationsController () {
		
		
	}
	
	@Autowired
	public NotificationsController (NotificationService nServ, UserService uServ) {
		super();
		this.nServ = nServ;
		this.uServ = uServ;
		
	}
	
	@CrossOrigin(origins="*")
	@GetMapping(value="/notifications")
	public @ResponseBody List<Notifications> getAllNotifications() {
		return UserController.loginUser.getList();
	}
	
	@GetMapping(value="/notifications/{notiId}") 
	public ResponseEntity<Notifications> getNotificationById(@PathVariable("notiId") String notiId) {
		Notifications nmodl = nServ.getNotificationById(notiId);
		return ResponseEntity.status(200).body(nmodl);
		
		
	}
		
	@PostMapping(value="/notifications", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Notifications> addNotification(@RequestBody Notifications nmodl) {
		System.out.println("this");
		System.out.println(nmodl);
			nServ.addNotification(nmodl);
			return  ResponseEntity.status(201).body(nmodl);
	}
	
	
	@DeleteMapping("/notifications/{notiId}")
	public ResponseEntity<Notifications> deleteNotification(@PathVariable("notId") String notiId) {
		Optional<Notifications> notiOpt = Optional.ofNullable(nServ.getNotificationById(notiId));
		if (notiOpt.isPresent()) {
			nServ.deleteNotification(notiOpt.get());
			return ResponseEntity.status(200).body(notiOpt.get());
		}
		return ResponseEntity.notFound().build();
	}

}
