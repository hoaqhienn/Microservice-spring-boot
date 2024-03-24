package fit.se.department.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fit.se.department.entity.Department;
import fit.se.department.service.DepartmentService;
import fit.se.department.service.RestTemplateService;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
	@Autowired
	private DepartmentService service;

	@Autowired
	private RestTemplateService restTemplateService;

	@GetMapping("/listDepartment")
	public List<Department> getDepartment() {
		return service.getAllDepartment();
	}

	@GetMapping("/listEmpolyee")
	public List<Map<String, Object>> getAllEmployee() {
		List<Map<String, Object>> employees = restTemplateService.getAllEmployee();
		return employees;
	}
}
