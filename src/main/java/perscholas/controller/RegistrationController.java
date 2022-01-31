package perscholas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import perscholas.form.RegistrationFormBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/registration-url-path")
public class RegistrationController {

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
            response.setViewName("redirect:/login");
        }

        return response;
    }
}
