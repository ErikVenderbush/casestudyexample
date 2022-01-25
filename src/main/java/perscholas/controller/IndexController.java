package perscholas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;

@Controller
public class IndexController {

    // Connects to index.jsp
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("index");

        return response;
    }

    // Connects to form action & submit
    @RequestMapping(value = {"/indexSubmit"}, method = RequestMethod.GET)
    public ModelAndView indexSubmit(ServletRequest request) throws Exception {

        System.out.println("Username = " + request.getParameter("username"));

        ModelAndView response = new ModelAndView();
        response.setViewName("index");

        return response;
    }
}
