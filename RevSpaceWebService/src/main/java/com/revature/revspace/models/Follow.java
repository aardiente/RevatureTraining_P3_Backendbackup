package com.revature.revspace.models;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="follow")
public class Follow {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="follow_id", nullable = false, unique=true)
	private int fId;
	
	@OneToOne
    @JoinColumn(name = "follow_user_id")
	private User userId;

	@ManyToOne
	private Set<User> followingList; 

}
