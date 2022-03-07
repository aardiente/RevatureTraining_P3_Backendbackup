package com.revature.revspace.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="notifications")
public class Notifications {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notiId", updatable = false)
	private int notiId;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "dateAndTime")
	private LocalDate dateAndTime;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="receiver")
	@JsonManagedReference
	private User userReceive;


	
	public Notifications() {
		// TODO Auto-generated constructor stub
	}

	public Notifications(int notiId, String message, LocalDate dateAndTime, User userReceive) {
		super();
		this.notiId = notiId;
		this.message = message;
		this.dateAndTime = dateAndTime;
		this.userReceive = userReceive;
	}

	public Notifications(String message, LocalDate dateAndTime, User userReceive) {
		super();
		this.message = message;
		this.dateAndTime = dateAndTime;
		this.userReceive = userReceive;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDate getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(LocalDate dateAndTime) {
		this.dateAndTime = dateAndTime;
	}


	public User getUserReceive() {
		return userReceive;
	}

	public void setUserReceive(User userReceive) {
		this.userReceive = userReceive;
	}

	public int getNotiId() {
		return notiId;
	}

	@Override
	public String toString() {
		return "NotificationsModel [notiId=" + notiId + ", message=" + message + ", dateAndTime=" + dateAndTime  + ", userReceive=" + userReceive + "]";
	}
	
}
