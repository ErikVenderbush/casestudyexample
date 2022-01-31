package perscholas.form;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RegistrationFormBean {

    // Not null AND not empty string (e.g. "")
    @NotEmpty
    private String email;

    @NotEmpty
    @Length(min = 1, max = 10, message = "First Name must be between 1 and 5 characters")
    private String firstName;

    @Min(value = 3, message = "Last Name must be at least 3 characters")
    private String lastName;


    private String password;


    private String confirmPassword;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
