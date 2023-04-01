package com.leavemanage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leavemanage.entity.Leaves;

public interface LeaveRepository extends JpaRepository<Leaves, String>{
	List<Leaves> findByEmail(String email);
	List<Leaves> findByLeaveId(int leaveId);
}
