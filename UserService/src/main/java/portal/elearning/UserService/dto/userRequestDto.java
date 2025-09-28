package portal.elearning.UserService.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class userRequestDto {

    @NotBlank(message="Please enter name.It is mandatory!")
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;
}
