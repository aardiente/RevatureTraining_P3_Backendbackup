package com.revature.revspace.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.revspace.models.GroupInfo;
import com.revature.revspace.models.GroupThread;
import com.revature.revspace.models.User;
import com.revature.revspace.services.GroupInfoService;
import com.revature.revspace.services.GroupThreadService;

@RestController
@CrossOrigin(origins = "http//localhost:4200")
@RequestMapping("/groups")
public class GroupController 
{
	@Autowired
	private GroupThreadService service;
	
	
	@PostMapping
	public ResponseEntity<String> addGroupThread(@RequestBody GroupThread obj)
	{
		ResponseEntity<String> res = null;
		
		if(obj == null)
			res = new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		else
			res = new ResponseEntity<String>( "Adding GroupThread in GroupController |\nResult ->" + service.addGroupThread(obj) , HttpStatus.OK); 
		
		return res;
	}
	
	@GetMapping("/GetAll")
	public ResponseEntity<List<GroupThread>> getAllGroupThreads()
	{
		ResponseEntity<List<GroupThread>> res = null;
		List<GroupThread> gList = service.getAllGroupThreads();
		
		if(gList == null)
			res = new ResponseEntity<List<GroupThread>>(HttpStatus.NO_CONTENT);
		else
			res = new ResponseEntity<List<GroupThread>>(gList, HttpStatus.OK); 
		
		return res;
	}
	
	@GetMapping("/ByOwner")
	public ResponseEntity<List<GroupThread>> getGroupThreadsByOwner(@RequestBody User owner)
	{
		ResponseEntity<List<GroupThread>> res = null;
		List<GroupThread> gList = service.getGroupThreadsByOwner(owner);
		
		if(gList == null)
			res = new ResponseEntity<List<GroupThread>>(HttpStatus.NO_CONTENT);
		else
			res = new ResponseEntity<List<GroupThread>>(gList, HttpStatus.OK); 
		
		return res;
	}
	
	@GetMapping("/ByMembership/{id}")
	public ResponseEntity<List<GroupInfo>> getGroupThreadsByUser(@PathVariable("id") int id)
	{
		ResponseEntity<List<GroupInfo>> res = null;
		List<GroupInfo> gList = service.getGroupThreadsByUser(id);
		
		if(gList == null)
			res = new ResponseEntity<List<GroupInfo>>(HttpStatus.NO_CONTENT);
		else
			res = new ResponseEntity<List<GroupInfo>>(gList, HttpStatus.OK); 
		
		return res;
	}
	
	@GetMapping("/ByUnique")
	public ResponseEntity<List<GroupThread>> getUniqueGroupThreads()
	{
		ResponseEntity<List<GroupThread>> res = null;
		List<GroupThread> gList = service.getAllUniqueThreads();
		
		if(gList == null)
			res = new ResponseEntity<List<GroupThread>>(HttpStatus.NO_CONTENT);
		else
			res = new ResponseEntity<List<GroupThread>>(gList, HttpStatus.OK); 
		
		return res;
	}
	
	@GetMapping("/GetOthers/{id}")
	public ResponseEntity<List<GroupInfo>> getOthers(@PathVariable("id") int id)
	{
		ResponseEntity<List<GroupInfo>> res = null;
		List<GroupInfo> gList = service.getOtherGroups(id);
		
		if(gList == null)
			res = new ResponseEntity<List<GroupInfo>>(HttpStatus.NO_CONTENT);
		else
			res = new ResponseEntity<List<GroupInfo>>(gList, HttpStatus.OK); 
		
		return res;
	}
}
