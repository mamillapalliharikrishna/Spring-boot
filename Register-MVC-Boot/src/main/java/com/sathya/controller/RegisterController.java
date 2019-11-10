package com.sathya.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sathya.bean.RegisterBean;

@Controller
public class RegisterController {
	@InitBinder
	public  void  initBinder(WebDataBinder  webDataBinder)
	{
		SimpleDateFormat  sdf=new SimpleDateFormat("dd/MM/yyyy");
		CustomDateEditor editor=new CustomDateEditor(sdf, true);
		webDataBinder.registerCustomEditor(Date.class, editor);
	}
	
	@GetMapping("/registerPage")
	public  String  returnRegisterPage(ModelMap  modelMap) {
		RegisterBean  registerBean  =new  RegisterBean();
		modelMap.addAttribute("register",registerBean);
		return  "register";
	}
	
	@PostMapping("/registerUser")
	public  String  registerUser(@Valid @ModelAttribute("register")RegisterBean  registerBean,BindingResult result) {
		if(result.hasErrors()) {
			return  "register";
		}
		else {
			return  "display";
		}
	}

}
