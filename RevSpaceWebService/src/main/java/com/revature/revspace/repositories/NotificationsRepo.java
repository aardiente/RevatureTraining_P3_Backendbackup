package com.revature.revspace.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.revspace.models.Notifications;

public interface NotificationsRepo extends JpaRepository<Notifications, Integer> {

	public List<Notifications> getAllNotifications();
	public Notifications getNotificationById (String notiId);
}
