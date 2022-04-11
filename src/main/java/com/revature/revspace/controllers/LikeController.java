package com.revature.revspace.controllers;

import com.revature.revspace.models.Like;
import com.revature.revspace.models.Post;
import com.revature.revspace.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class LikeController {

    @Autowired
    LikeService ls;

    /*************************************************************************************/
    // Get Mappings
    @GetMapping("/likes/{id}")
    public ResponseEntity<Like> getLikeById(@PathVariable("id") int id)
    {
    	ResponseEntity<Like> res = null;
    	Like likeRes = ls.add(null);
    	
    	if(likeRes == null)
    		res = new ResponseEntity<Like>(HttpStatus.NO_CONTENT);
    	else
    		res = new ResponseEntity<Like>(likeRes, HttpStatus.OK);
    	
    	return res;
    }
    
    @GetMapping("/likes")
    public ResponseEntity<List<Like>> getLikes()
    {
    	ResponseEntity<List<Like>> res = null;
    	List<Like> rList = (List<Like>)ls.getAll();
    	
    	
    	if(rList == null)
    		res = new ResponseEntity<List<Like>>(HttpStatus.NO_CONTENT);
    	else
    		res = new ResponseEntity<List<Like>>(rList, HttpStatus.OK);
    	
    	return res;
    }
    /*************************************************************************************/
    // Post Mappings
    @PostMapping("/likes")
    public ResponseEntity<Like> addLike(@RequestBody Like like)
    {
    	ResponseEntity<Like> res = null;
    	Like temp = (Like)ls.add(like);
    	
    	if(temp == null)
    		res = new ResponseEntity<Like>(HttpStatus.NO_CONTENT);
    	else
    		res = new ResponseEntity<Like>(temp, HttpStatus.OK);
    	
    	return res;
    }
    
    
    /*************************************************************************************/
    // Put Mappings
    //Update Like By ID
    @PutMapping(value = "/likes", consumes = "application/json", produces = "application/json")
    public Like updateLike(@RequestBody Like like)
    {
        return ls.update(like);
    }
    
    /*************************************************************************************/
    // Delete Mappings
    //Delete Post By ID
    @DeleteMapping(value = "/likes/{id}")
    public ResponseEntity<Boolean> deletePost(@PathVariable("id") int id)
    {
    	ResponseEntity<Boolean> res = null;
    	boolean serRes = ls.delete(id);
    	
    	if(serRes)
    		res = new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
    	else
    		res = new ResponseEntity<Boolean>(serRes, HttpStatus.OK);
    	
    	return res;
    }
//    @GetMapping(value = "/likes/{id}")
//    public Like getLikeById(@PathVariable(name = "id") String id){
//        int safeId;
//        try{
//            safeId = Integer.parseInt(id);
//        } catch(NumberFormatException e)
//        {
//            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
//        }
//        return ls.get(safeId);
//    }
//
//    @GetMapping(value = "/likes")
//    public List<Like> getAllLikes(){
//        return ls.getAll();
//    }
//
//    @PostMapping(value="/likes", consumes = "application/json", produces = "application/json")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Like addLike(@RequestBody Like like)
//    {
//        return ls.add(like);
//    }

//    //Update Like By ID
//    @PutMapping(value = "/likes", consumes = "application/json", produces = "application/json")
//    public Like updateLike(@RequestBody Like like)
//    {
//        return ls.update(like);
//    }



//    //Delete Post By ID
//    @DeleteMapping(value = "/likes/{id}")
//    public boolean deletePost(@PathVariable("id") String id)
//    {
//        int safeId;
//        try
//        {
//            safeId = Integer.parseInt(id);
//        }catch (NumberFormatException e)
//        {
//            safeId = 0;
//        }
//        return ls.delete(safeId);
//    }
}
