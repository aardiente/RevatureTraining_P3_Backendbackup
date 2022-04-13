package com.revature.revspace.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.revspace.models.GroupThread;
import com.revature.revspace.models.Post;
import com.revature.revspace.services.GroupThreadService;
import com.revature.revspace.services.PostService;

@RestController
@CrossOrigin(origins = "http//localhost:4200")
@RequestMapping("/group")
public class GroupPostController 
{
	@Autowired
	private PostService pServe;
	
	@PostMapping("{groupId}")
	public ResponseEntity<String> addGroupPost(@PathVariable("groupId") int groupId,@RequestBody Post post)
	{
		ResponseEntity<String> res = null;
		
		if(post == null)
			res = new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		else
			res = new ResponseEntity<String>("Adding Post for group: " + groupId + "in GroupPostController |\nResult ->" + pServe.add(post) , HttpStatus.OK); 
		
		return res;
	}
}
