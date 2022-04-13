package com.revature.revspace.models;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Table(name = "groupinfo")
public class GroupInfo 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int infoId;
	
	private String groupName;
	private String description;
	private String interests;
	private String dateCreated;
	
	@OneToOne
	@JoinColumn(name="userId")
	private User owner;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=true, cascade=CascadeType.ALL)
	@JoinColumn(name="post_id", nullable = true)
	private Post postHead; // I just realized its a linked list lol.
}
