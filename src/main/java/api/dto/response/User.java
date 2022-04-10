package api.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("unused")
@Builder
public class User {

    @JsonProperty("email")
    private String email;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("id")
    private BigDecimal id;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("password")
    private String password;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("userStatus")
    private BigDecimal userStatus;
    @JsonProperty("username")
    private String username;

}
