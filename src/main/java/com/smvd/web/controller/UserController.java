package com.smvd.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.smvd.pojo.User;
import com.smvd.service.IUserService;

@Controller  
public class UserController {  
	private IUserService iUserService;

	@Resource(name="userServiceImpl")
	public void setIUserService(IUserService ius){
		this.iUserService=ius;
	}

	//跳转界面
	@RequestMapping("/toShowInfo")
	public ModelAndView toShowInfo(HttpServletRequest request) {
		ModelAndView mv=new ModelAndView("success");
		User user = new User();
		user.setUid( Integer.parseInt(request.getParameter("uid")) );
		List<User> list=this.iUserService.getUser(user);
		mv.addObject("user", list.get(0));
		return mv;	
	}
}  