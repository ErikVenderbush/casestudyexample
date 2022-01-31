package perscholas.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import perscholas.form.LoginFormBean;

@Controller
public class LoginController {
    private static final String SESSION_KEY = "sessionUser";
    private static final String SESSION_ERROR = "errorMessageKey";
    private static final String INVALID_CRED_ERROR = "Invalid Credentials<br>Please try again";

    // this method is checking to see if the user is logged in by looking at the session
    // if logged in ( user is in the session ) then show the success page.
    // if not logged in ( user is not in the session ) then show the login page
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();

        // If there is a value in the session print it
        String sessionUser = (String) session.getAttribute(SESSION_KEY);
        if (sessionUser != null) {
            System.out.println("/login: Trying to get session user and got: " + sessionUser);

            // Check if username matches
            if (StringUtils.equals(sessionUser, "tom")) {
                response.setViewName("redirect:/success"); // redirects to URL
            } else {
                System.out.println("User not found");
                String errorM;
            }
        } else {
            response.setViewName("login/login"); // sets view to JSP
        }

        return response;
    }

    // this method is checking to see if the user is logged in by looking at the session
    // if logged in ( user is in the session ) then show the success page.
    // if not logged in ( user is not in the session ) then show the login page
    @RequestMapping(value = "/loginSubmit", method = RequestMethod.GET)
    public ModelAndView loginSubmit1(LoginFormBean form, @RequestParam String usernameFromForm, @RequestParam String passwordFromForm,
                                    HttpServletRequest request, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();

        System.out.println("usernameFromFrom using @RequestParam = " + usernameFromForm);
        System.out.println("usernameFromFrom using LoginFormBean = " + form.getUsernameFromForm());

        // These are the same as on the html form
        String username = request.getParameter("usernameFromForm");
        String password = request.getParameter("passwordFromForm");

        // Checks credentials against expected
        if (StringUtils.equals(username, "tom") && StringUtils.equals(password, "jerry")) {
            // put a value in the session
            System.out.println("/loginSubmit: adding user to session = " + username);
            session.setAttribute(SESSION_KEY, username);

            // This redirects to success method/URL
            response.setViewName("redirect:/success"); // redirects to URL
        } else {
            // This goes back to login method/URL
            session.setAttribute(SESSION_KEY, null);
            System.out.println("/loginSubmit: Incorrect Credentials");
            response.setViewName("redirect:/login"); // redirects to URL
        }

        return response;
    }

    // use setAttribute to set an error message in the session.   In the formSubmit2 method
    // getAttribute to get the error message from the session in the login method.
    // response (model) .addObject to make the error message available to the JSP
    // alter the login.jsp to show the error message from the model using ${ } notation

    // this method is checking to see if the user is logged in by looking at the session
    // it uses Lombok & a bean instead of grabbing directly from the form
    @RequestMapping(value = "/loginSubmit2", method = RequestMethod.GET)
    public ModelAndView loginSubmit2(LoginFormBean form, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();

        String username = form.getUsernameFromForm();
        String password = form.getPasswordFromForm();

        // Checks credentials against expected
        if (StringUtils.equals(username, "tom") && StringUtils.equals(password, "jerry")) {
            session.setAttribute(SESSION_KEY, username);
            session.setAttribute(INVALID_CRED_ERROR, null);
            // This redirects to success method/URL
            response.setViewName("redirect:/success"); // redirects to URL
        } else {
            // This goes back to login method/URL
            System.out.println("/loginSubmit: Incorrect Credentials");
            session.setAttribute(SESSION_KEY, null);
            session.setAttribute(INVALID_CRED_ERROR, "Invalid Credentials<br>Please try again");
            response.setViewName("redirect:/login"); // redirects to URL
        }

        return response;
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public ModelAndView success(HttpServletRequest request, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();

        // these are the same name as on the html form
        String sessionUser = (String) session.getAttribute(SESSION_KEY);

        // Checks
        if (StringUtils.equals(sessionUser, "tom")) {
            // This is going to the JSP page
            response.addObject("user", sessionUser);
            response.setViewName("login/success"); // sets view to JSP
        } else {
            // This goes back to login method/URL
            System.out.println("/loginSubmit2: Incorrect Credentials");
            response.setViewName("redirect:/login"); // redirects to URL
        }

        return response;
    }
}