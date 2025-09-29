package portal.elearning.UserService.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Data
public class userRequestDto {

    @NotBlank(message="Please enter name.It is mandatory!")
    @NotNull
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@gmail\\.com$", message = "Only Gmail addresses are allowed")
    private String email;

    @NotBlank(message = "Password is required")
    @NotNull
    private String password;
}
//regex for stricter validation of email
//basic validation using @valid+@notnull