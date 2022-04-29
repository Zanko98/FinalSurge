package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Account {
    String firstName,
            LastName,
            email,
            timeZone,
            password,
            repeatPassword;
}
