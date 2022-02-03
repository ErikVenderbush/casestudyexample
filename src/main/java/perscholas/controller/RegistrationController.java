package perscholas.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import perscholas.database.dao.UserDAO;
import perscholas.database.entity.User;
import perscholas.form.RegistrationFormBean;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/registration-url-path")
public class RegistrationController {

    public static final Logger LOG = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    public UserDAO userDao;

    // 1) use the existing request mapping to do a firstname OR lastname search case insensitve

    // 2) implement the ability to search by first name AND last name case insensitive - this is a new form on the jsp page
    // I want you to make a new controller request mapping to handle the first name and last name search

    // 3) in both cases I want you to pass the incoming search parameter back to the jsp page using the model
    // I want to populate the search input with the incoming search parameter

    // 4) get your logback config setup and log out stuff to debug

    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public ModelAndView userList(@RequestParam(required = false) String search) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("registration/userList");

        if (!StringUtils.isEmpty(search)) {
            User user = userDao.findByUsername(search);
            response.addObject("userListKey", user);
        } else {
            List<User> users = userDao.findAll();
            response.addObject("userListKey", users);
        }

        return response;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("registration/register");

        return response;
    }

    @RequestMapping(value = "/registerSubmit", method = RequestMethod.GET)
    public ModelAndView registerSubmit(@Valid RegistrationFormBean form, BindingResult errors) throws Exception {
        ModelAndView response = new ModelAndView();

        System.out.println(form);

        if (errors.hasErrors()) {
            for (FieldError error : errors.getFieldErrors()) {
                form.getErrorMessages().add(error.getDefaultMessage());
                System.out.println("error field = " + error.getField() + "; message = " + error.getDefaultMessage());
            }

            response.addObject("formBeanKey", form);
            response.setViewName("registration/register");
        } else {
            User user = new User();

            user.setUsername(form.getUsername());
            user.setPassword(form.getPassword());
            user.setEmail(form.getEmail());
            user.setFirstName(form.getFirstName());
            user.setLastName(form.getLastName());

            userDao.save(user);

            response.setViewName("redirect:/login");
        }

        return response;
    }
}
