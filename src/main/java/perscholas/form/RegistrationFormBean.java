package perscholas.form;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;
import perscholas.validation.EmailUnique;

import javax.validation.constraints.*;
import java.util.*;

@Getter
@Setter

public class RegistrationFormBean {

    @NotEmpty
    private String username;

    // Not null AND not empty string (e.g. "")
    @NotEmpty(message = "Email is required")
    @Pattern(regexp = "^.+@.+$" , message = "Invalid email format")
    @EmailUnique(message = "Email must be unique")
    private String email;

    @NotEmpty(message = "First Name is required")
    @Length(min = 1, max = 10, message = "First Name must be between 1 and 5 characters")
    private String firstName;

    @NotEmpty(message = "Last Name is required")
    private String lastName;

    // these annotations work on integer values only
    @Min(value=3, message="Age must be at least 3")
    @Max(value=10, message="Age must be at most 10")
    private Integer age;

    private String password;
    private String confirmPassword;

    private List<String> errorMessages = new ArrayList<>();

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
