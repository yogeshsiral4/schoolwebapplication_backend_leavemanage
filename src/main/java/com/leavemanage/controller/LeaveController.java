package com.leavemanage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leavemanage.entity.Leaves;
import com.leavemanage.service.LeaveService;

@RestController
@RequestMapping(path = "/leave")
@CrossOrigin(origins = "*")
public class LeaveController {
	
	@Autowired
	private LeaveService leaveService;
	
	@GetMapping("/display/leave/{email}")
	public List<Leaves> showAllLeavesByEmail(@PathVariable String email){
		return leaveService.showAllLeavesByEmail(email);
	}
	
	@GetMapping("/display/{leaveId}")
	public List<Leaves> showLeavesByLeaveId(@PathVariable int leaveId){
		return leaveService.showAllLeavesByLeaveId(leaveId);
	}
	
	@GetMapping("/all/leave")
	public List<Leaves> getAllLeaves(){
		return leaveService.getAllLeaves();
	}
	
	@PostMapping("/apply")
	public ResponseEntity<Leaves> applyLeave(@RequestBody Leaves leaves) {		
		return leaveService.applyLeave(leaves) ;
	}
	
	

}
