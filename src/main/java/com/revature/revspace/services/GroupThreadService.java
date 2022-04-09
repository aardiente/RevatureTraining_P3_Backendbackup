package com.revature.revspace.services;

import java.util.List;

import com.revature.revspace.models.GroupThread;
import com.revature.revspace.models.User;

public interface GroupThreadService 
{
	public GroupThread addGroupThread(GroupThread obj);
	public GroupThread updateGroupThread(GroupThread obj);
	
	public List<GroupThread> getAllGroupThreads();
	public List<GroupThread> getGroupThreadsByOwner(User obj);
}
