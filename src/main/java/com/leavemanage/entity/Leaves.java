package com.leavemanage.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Leave_management")
public class Leaves {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="leaveId", columnDefinition = "INT(15) UNIQUE KEY auto_increment")
    private int leaveId;
	
	@Id
	private String email;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "From_Date",nullable=false)
	private LocalDate fromDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "To_Date",nullable=false)
	private LocalDate toDate;
	
	
	@Column(name = "Leave_Type")
	private String leaveType;
	

	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	
	
}
