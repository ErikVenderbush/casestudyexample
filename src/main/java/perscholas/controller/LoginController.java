package perscholas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    // Connects to login.jsp
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/login");

        // these 3 are the same name as on the html form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("/login: Username = " + username);
        System.out.println("/login: password = " + password);

        // if there is a value in the session print it
        Object userSession = session.getAttribute("username");
        System.out.println("/login: Trying to get username and got: " + userSession);

        if (userSession != null) {
            if (userSession.equals("tom")) {
                response.setViewName("login/success");
            } else {
                System.out.println("User not found");
            }
        }

        return response;
    }

    @RequestMapping(value = "/loginSubmit", method = RequestMethod.GET)
    public ModelAndView loginSubmit(HttpServletRequest request, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();

        // these 3 are the same name as on the html form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("/loginSubmit: Username = " + username);
        System.out.println("/loginSubmit: Password = " + password);

        if (username.equals("tom") && password.equals("jerry")) {
            // put a value in the session
            System.out.println("/loginSubmit: adding user to session = " + username);
            session.setAttribute("username", username);

            // this is going to the JSP page
            response.addObject("username", username);

            response.setViewName("login/success");
        } else {
            System.out.println("/loginSubmit: Incorrect Credentials");
            response.setViewName("login/login");
        }

        return response;
    }

}