package com.revature.revspace.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.revature.revspace.models.GroupInfo;
import com.revature.revspace.models.User;

public interface GroupInfoRepository extends CrudRepository<GroupInfo, Integer>
{

}
