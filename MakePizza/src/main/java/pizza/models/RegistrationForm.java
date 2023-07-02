package pizza.models;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {
    private String username;
    private String fullname;
    private String password;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public User toUser(PasswordEncoder encoder) {
        return new User(1L,
                username, fullname, encoder.encode(password),
                street, city, state, zip, phone
        );
    }
}
