package com.leavemanage;

import static io.restassured.RestAssured.given;

import java.time.LocalDate;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import com.leavemanage.dto.AuthRequest;
import com.leavemanage.entity.Leaves;

import io.restassured.http.ContentType;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class LeavemanageApplicationTests {

	@Test
	void contextLoads() {
	}

// Apply for leave
	@Test
	@Order(1)
	void ApplyLeaveTest() {
		Leaves leaves = new Leaves();
		leaves.setEmail("mohansharma@gmail.com");
		LocalDate from = LocalDate.of(2023, 03, 22);
		leaves.setFromDate(from);
		LocalDate to = LocalDate.of(2023, 03, 24);
		leaves.setToDate(to);
		leaves.setLeaveType("Sick Leave");
		
		given().header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
		   .body(leaves)
		   .when()
		   .post("http://localhost:9193/leave/apply")
		   .then()
		   .assertThat().statusCode(201);
		
	}
	
// Test for Display All Leaves
	@Test
	@Order(2)
	void ShowAllLeavesTest() {
		given().header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
		   .when()
		   .get("http://localhost:9193/leave/all/leave")
		   .then()
		   .assertThat().statusCode(200);
	}
	
// Test for Display leave by email
	@Test
	@Order(3)
	void ShowLeaveByEmailTest() {
		AuthRequest authCheck = new AuthRequest();
		authCheck.setEmail("mohansharma@gmail.com");
		authCheck.setPassword("mohan123");
		authCheck.setRole("Student");
		
	String tokenn = given().header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
		   .body(authCheck)
		   .when()
		   .post("http://localhost:9192/home/login")
		   .then()
		   .assertThat().statusCode(200)
		   .extract().response().asString();
	
	 System.out.println(tokenn);
     
     String token = "Bearer "+tokenn;
     
     given()
	     .header("Authorization",token).contentType(ContentType.JSON).accept(ContentType.JSON)
	     .when()
	     .get("http://localhost:9193/leave/display/leave/mohansharma@gmail.com")
	     .then()
	     .assertThat().statusCode(200);
     
	}
	
}
