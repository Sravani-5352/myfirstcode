package com.example.springbootdemoapp02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootdemoapp02.dao.ApplicationEmployee;
import com.example.springbootdemoapp02.dto.Employee;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	ApplicationEmployee applicationemp;

	@PostMapping("/create")
	public Employee createEmployee(@RequestBody Employee employee) {
		return applicationemp.save(employee);

	}

	@GetMapping("/getemployee")
	public List<Employee> getAllEmployees() {
		return applicationemp.findAll();
	}

	@GetMapping("/getemployee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = applicationemp.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :" + employeeId));

		return ResponseEntity.ok().body(employee);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long employeeId,
			@RequestBody Employee employeeDetails) throws ResourceNotFoundException {

		Employee employee = applicationemp.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :" + employeeId));

		employee.setFname(employeeDetails.getFname());
		employee.setEmail(employeeDetails.getEmail());


		Employee updateEmployee = applicationemp.save(employee);
		return ResponseEntity.ok(updateEmployee);

	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>deleteEmployee(@PathVariable("id") Long employeeId) throws ResourceNotFoundException{
		
		Employee employee = applicationemp.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :" + employeeId));
		
		applicationemp.deleteById(employeeId);
		return ResponseEntity.ok("Deleted SuccessFully ");
	}

}
