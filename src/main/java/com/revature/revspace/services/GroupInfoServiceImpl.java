package com.revature.revspace.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.revspace.models.GroupInfo;
import com.revature.revspace.models.User;
import com.revature.revspace.repositories.GroupInfoRepository;

@Service
public class GroupInfoServiceImpl implements GroupInfoService 
{
	@Autowired
	GroupInfoRepository infoRepo;
	
	@Override
	public List<GroupInfo> getGroupsByOwner(User obj)
	{
		List<GroupInfo> rList = null;
		List<GroupInfo> gList = null;
		
		try
		{
			gList = (List<GroupInfo>) infoRepo.findAll();
			rList = new ArrayList<GroupInfo>();
			for(GroupInfo g : gList)
			{
				if(g.getOwner().equals(obj))
					rList.add(g);
			}
		}catch(Exception e)
		{
			
		}
		
		
		return rList;
	}

	@Override
	public List<GroupInfo> getGroupsByOther(int id) 
	{
		List<GroupInfo> rList = null;
		List<GroupInfo> gList = null;
		
		try
		{
			gList = (List<GroupInfo>) infoRepo.findAll();
			rList = new ArrayList<GroupInfo>();
			for(GroupInfo g : gList)
			{
				if(g.getOwner().getUserId() != id)
					rList.add(g);
			}
		}catch(Exception e)
		{
			
		}
		
		
		return rList;
	}

}
