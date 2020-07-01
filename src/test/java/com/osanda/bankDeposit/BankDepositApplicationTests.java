package com.osanda.bankDeposit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class BankDepositApplicationTests {

	private @Autowired MockMvc mockMvc;
	
	private @Autowired ObjectMapper objectMapper;

	
	/***
	 * test case to create new student and check for the
	 * creation is correct by comparing values
	 * 
	 * @author Osanda Wedamulla
	 * @throws Exception
	 */
	@Test
	public void createNewStudent() throws Exception {

//		Student student = new Student();
//		student.setActive(true);
//		student.setName("Alex Mistigue");
//		student.setAge(22);
//		student.setGrade("Grade 12");
//
//		this.mockMvc
//				.perform(post("/api/students")
//				.contentType("application/json")
//				.content(objectMapper.writeValueAsString(student)))
//				.andDo(print())
//				.andExpect(status().isCreated());
//
//		Optional<Student> newStudent = studentRepository.findById(2l);
//
//		assertThat(newStudent.get().getName()).isEqualTo("Alex Mistigue");

	}// createNewStudent()

}// StudentGradeApplicationTests {}
