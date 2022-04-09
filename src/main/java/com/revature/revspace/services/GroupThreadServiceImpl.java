package com.revature.revspace.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.revspace.models.GroupThread;
import com.revature.revspace.models.User;
import com.revature.revspace.repositories.GroupInfoRepository;
import com.revature.revspace.repositories.GroupThreadRepository;

@Service
public class GroupThreadServiceImpl implements GroupThreadService 
{
	@Autowired
	GroupThreadRepository repo;
	
	@Autowired
	GroupInfoRepository infoRepo;
	
	@Override
	public GroupThread addGroupThread(GroupThread obj) 
	{
		GroupThread res = null;
		if(obj != null)
		{
			infoRepo.save(obj.getGroupInfo());
			res = repo.save(obj);
		}
		return res;
	}

	@Override
	public GroupThread updateGroupThread(GroupThread obj) 
	{

		return null;
	}

	@Override
	public List<GroupThread> getAllGroupThreads() 
	{

		List<GroupThread> gList = null; // Result list
		
		try
		{
			gList = (List<GroupThread>)repo.findAll();
		}catch(Exception e)
		{
			// Add custom exceptions and actually do something with them.
		}
		
		return gList;
	}

	@Override
	public List<GroupThread> getGroupThreadsByOwner(User obj) // change me when you do the custom search. Placeholder...
	{
		List<GroupThread> gList = null; // Result list
		List<GroupThread> tList = null; // temp list, iterating through it to find owner by email 
		
		try
		{
			tList = (List<GroupThread>)repo.findAll();
			
			if(tList != null || tList.isEmpty())
				gList = new ArrayList<GroupThread>();
			
			for(GroupThread g : tList)
			{
				if(g.getGroupInfo().getOwner().getEmail().equals(obj.getEmail())) // thread.info.owner.email == owner.email
				{
					gList.add(g);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage()); // change to logging.
		}
				
		return gList;
	}

}
