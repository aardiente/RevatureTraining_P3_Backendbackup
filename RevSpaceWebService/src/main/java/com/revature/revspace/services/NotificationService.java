package com.revature.revspace.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.revspace.models.Notifications;
import com.revature.revspace.repositories.NotificationsRepo;

@Service
public class NotificationService {
	
	private NotificationsRepo nRepo;
	
	public NotificationService () {
		
	}

	@Autowired
	public NotificationService (NotificationsRepo nRepo) {
		super ();
		this.nRepo = nRepo;
		
	}

	public List<Notifications> getAllNotifications() {
		// TODO Auto-generated method stub
		return this.nRepo.findAll();
	}
	
	public Notifications getNotificationById(String notiId) {
		// TODO Auto-generated method stub
		List<Notifications> nList = this.nRepo.findAll();
		int notificationId = Integer.parseInt(notiId);
		for (Notifications noti: nList) {
			if (noti.getNotiId() == notificationId) {
				return noti;
			}
		}
		return null;
	}

	public void addNotification(Notifications nmodl) {
		nmodl.setDateAndTime(LocalDate.now());
		// TODO Auto-generated method stub
		nRepo.save(nmodl);
		
	}


	public void deleteNotification(Notifications notifications) {
		// TODO Auto-generated method stub
		nRepo.delete(notifications);
		
	}

	
}
