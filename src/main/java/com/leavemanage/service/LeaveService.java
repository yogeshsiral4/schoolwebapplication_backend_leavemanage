package com.leavemanage.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leavemanage.entity.Leaves;
import com.leavemanage.repository.LeaveRepository;

@Service
public class LeaveService {
	@Autowired
	private LeaveRepository leaveRepository;
	
	public List<Leaves> showAllLeavesByEmail(String email){
		return leaveRepository.findByEmail(email);
	}
	
	public List<Leaves> showAllLeavesByLeaveId(int leaveId){
		return leaveRepository.findByLeaveId(leaveId);
	}
	
public ResponseEntity<Leaves> applyLeave(Leaves leaves) {
		return new ResponseEntity<Leaves>(leaveRepository.save(leaves),HttpStatus.CREATED);
	}
	
	public List<Leaves> getAllLeaves(){
		return leaveRepository.findAll();
	}

	
}
