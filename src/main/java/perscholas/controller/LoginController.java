package perscholas.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import perscholas.database.dao.UserDAO;
import perscholas.database.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
	private static final String SESSION_KEY = "sessionUser";
	private static final String SESSION_ERROR = "errorMessageKey";
	private static final String INVALID_CRED_ERROR = "Invalid Credentials<br>Please try again";
	
	@Autowired
	public UserDAO userDAO;
	
	public User user;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, HttpSession session) throws Exception {
		ModelAndView response = new ModelAndView();
		response.setViewName("login/login");
		
		return response;
	}
	// @RequestMapping(value = "/loginSecurityPost", method = RequestMethod.GET)
	// public ModelAndView login(HttpServletRequest request, HttpSession session) throws Exception {
	// 	ModelAndView response = new ModelAndView();
	//
	// 	// If there is a value in the session print it
	// 	String sessionUser = (String) session.getAttribute(SESSION_KEY);
	// 	if (sessionUser != null) {
	// 		System.out.println("/login: Trying to get session user and got: " + sessionUser);
	//
	// 		// Check if username matches
	// 		if (StringUtils.equals(sessionUser, user.getUsername())) {
	// 			response.setViewName("redirect:/success"); // redirects to URL
	// 		} else {
	// 			System.out.println("User not found");
	// 			String errorM;
	// 		}
	// 	} else {
	// 		response.setViewName("login/login"); // sets view to JSP
	// 	}
	//
	// 	return response;
	// }
}
