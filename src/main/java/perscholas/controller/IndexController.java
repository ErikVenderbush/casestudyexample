package perscholas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
	
	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, HttpSession session) throws Exception {
		ModelAndView response = new ModelAndView();
		response.setViewName("home");
		return response;
	}
	
	// Connects to index.jsp
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpSession session) throws Exception {
		ModelAndView response = new ModelAndView();
		response.setViewName("index");
		
		// these 3 are the same name as on the html form
		String username = request.getParameter("username");
		String firstName = request.getParameter("firstName");
		String dropdown = request.getParameter("dropdown");
		
		System.out.println("/index: Username = " + username);
		System.out.println("/index: First Name = " + firstName);
		System.out.println("/index: Dropdown = " + dropdown);
		
		// if there is a value in the session print it
		Object userSession = session.getAttribute("username");
		System.out.println("/index: Trying to get username and got: " + userSession);
		
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				String value = cookie.getValue();
				System.out.println("Cookie: " + name + " = " + value);
			}
		} else {
			System.out.println("/index: No cookies on request");
		}
		
		return response;
	}
	
	// Connects to form action & submit
	@RequestMapping(value = "/indexSubmit", method = RequestMethod.GET)
	public ModelAndView indexSubmit(HttpServletRequest request, HttpSession session) throws Exception {
		
		// these 3 are the same name as on the html form
		String username = request.getParameter("username");
		String firstName = request.getParameter("firstName");
		String dropdown = request.getParameter("dropdown");
		
		System.out.println("/indexSubmit: Username = " + username);
		System.out.println("/indexSubmit: First Name = " + firstName);
		System.out.println("/indexSubmit: Dropdown = " + dropdown);
		
		// put a value in the session
		System.out.println("/indexSubmit: adding user to session = " + username);
		session.setAttribute("username", username);
		
		// this is going to the JSP page
		ModelAndView response = new ModelAndView();
		response.addObject("username", username);
		response.addObject("firstName", firstName);
		
		response.setViewName("indexSubmit");
		
		return response;
	}
	
}