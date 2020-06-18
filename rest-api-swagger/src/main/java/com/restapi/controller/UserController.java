package com.restapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.dto.UserDTO;
import com.restapi.entity.User;
import com.restapi.exception.NoSuchUserException;
import com.restapi.repository.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="This  Rest API  provides  CRUD operations on UserDTO")
public class UserController {
	@Autowired
	UserRepository      repo;
	
	@ApiOperation(value="This endpoint returns list of  users", response=List.class)
	@ApiResponses({
		@ApiResponse(code=200, message="List of users returned successfully"),
		@ApiResponse(code=404, message="You have to check the url once"),
		@ApiResponse(code=401, message="You have no access to this endpoint")
	})
	@GetMapping(value="/users/all",  produces="application/json")
	public     ResponseEntity<List<UserDTO>>    findAllUsers() {
		List<User>    usersList = repo.findAll();
		List<UserDTO>  usersList2 = new  ArrayList<>();
		for(User   user :  usersList) {
			UserDTO     dto = new  UserDTO();
			dto.setUserId(user.getUserId());
			dto.setUserName(user.getUserName());
			dto.setPhoneNo(user.getPhoneNo());
			usersList2.add(dto);
		}
		return    new  ResponseEntity<List<UserDTO>>(usersList2, HttpStatus.OK);
	}
	
	@ApiOperation(value="This endpoint returns a specific user", response=UserDTO.class)
	@ApiResponses({
		@ApiResponse(code=200, message=" user is  returned successfully"),
		@ApiResponse(code=404, message="You have to check the url once"),
		@ApiResponse(code=401, message="You have no access to this endpoint")
	})
	@GetMapping(value="/users/{userid}",  produces="application/json")
	public      UserDTO      findUserById(@PathVariable   Integer  userid) {
		Optional<User>      opt = repo.findById(userid);
		User   user=opt.get();
		UserDTO   dto=new  UserDTO();
		dto.setUserId(user.getUserId());
		dto.setUserName(user.getUserName());
		dto.setPhoneNo(user.getPhoneNo());
		return   dto;

	}
	
	@ApiOperation(value="This endpoint creates a new  user", response=String.class)
	@ApiResponses({
		@ApiResponse(code=200, message="User is successfully created"),
		@ApiResponse(code=404, message="You have to check the url once"),
		@ApiResponse(code=401, message="You have no access to this endpoint")
	})
	@PostMapping(value="/create",   consumes="application/json", produces="text/plain")
	public     String     createNewUser(@RequestBody   User  user)  throws  Exception {
		boolean  flag=repo.existsById(user.getUserId());
		if(flag==true) {
			throw   new   Exception();
		}
		repo.save(user);
		return   "User  is   Added   to   Database";
		
	}
	
	@ApiOperation(value="This endpoint updates an existing user", response=String.class)
	@ApiResponses({
		@ApiResponse(code=200, message="user is successfully  updated"),
		@ApiResponse(code=404, message="You have to check the url once"),
		@ApiResponse(code=401, message="You have no access to this endpoint")
	})
	@PutMapping(value="/update",   consumes="application/json",  produces="text/plain")
	public      String      updateUser(@RequestBody   User   user) {
		repo.saveAndFlush(user);
		return    "User  is  Updated   to  Database";
	}
	@ApiOperation(value="This endpoint a specific  user", response=String.class)
	@ApiResponses({
		@ApiResponse(code=200, message="User is deleted successfully"),
		@ApiResponse(code=404, message="You have to check the url once"),
		@ApiResponse(code=401, message="You have no access to this endpoint")
	})
	@DeleteMapping(value="/delete")
	public     String      deleteUser(@RequestParam("userid")   Integer   id) {
		boolean  flag=repo.existsById(id);
		if(flag==true) {
			repo.deleteById(id);
			return   "User  is  Deleted  from   Database";
		}
		else {
			throw   new   NoSuchUserException();
		}
	}
			
	

}