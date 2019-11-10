package com.satya.ems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.satya.ems.entity.Employee;
import com.satya.ems.repository.EmployeeRepository;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeRepository      repository;
	
	@GetMapping("/getEmployeePage")
	public   String     getEmployeePage() {
		return   "addEmployee";
	}
	
	@PostMapping("/registerEmployee")
	public    ModelAndView    registerEmployee(@RequestParam   int  empid, @RequestParam String  empname, @RequestParam  int  age, @RequestParam  double  salary) {
			Employee    employee=new  Employee();
		    employee.setEmpid(empid);
		    employee.setEmpname(empname);
		    employee.setSalary(salary);
		    employee.setAge(age);
		    boolean   flag = repository.existsById(empid);
		    if(flag==true) {
		    	return     new  ModelAndView("index",  "message","Sorry, employee already exists!!!");
		    }
		    else {
		    	repository.save(employee);
		    	return    new   ModelAndView("index",  "message",  "Employee  added to Database");
		    }
	}
	
	@GetMapping("/listEmployees")
	public   String     listEmployees(ModelMap   modelMap) {
		List<Employee>  empList = repository.findAll();
		modelMap.addAttribute("employees", empList);
		return   "employeesList";
	}
	
	@GetMapping("/editEmployeePage")
	public   String    getEditEmployeePage(@RequestParam("empid")Integer  id,ModelMap   modelMap) {
		Optional<Employee>   opt = repository.findById(id);
		Employee    employee=opt.get();
		modelMap.addAttribute("e",employee);
		return   "editEmployee";
	}
	
	@PostMapping("/updateEmployee")
	public    String    updateEmployee(@ModelAttribute("e")Employee  employee, ModelMap  modelMap) {
		repository.save(employee);
		List<Employee>  empList = repository.findAll();
		modelMap.addAttribute("employees", empList);
		return   "employeesList";
		 
	}
	
	@GetMapping("/deleteEmployee")
	public    String    deleteEmployee(@RequestParam("empid")Integer  id, ModelMap   modelMap) {
		repository.deleteById(id);
		List<Employee>  empList = repository.findAll();
		modelMap.addAttribute("employees", empList);
		return   "employeesList";
	
	}
	
	/*@GetMapping("/login")
	public   String   getLoginPage(@RequestParam(value="error", required=false) String  err, ModelMap  model)
	{
		String  errorMessage="";
		if("yes".equals(err))
		{
			errorMessage="Your Username or Password is not valid!!!!!!";
			model.addAttribute("errorMessage", errorMessage);
		}
		
		return  "login";
	}*/
	
	
	
}





