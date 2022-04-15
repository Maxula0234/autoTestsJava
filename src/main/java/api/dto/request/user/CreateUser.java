package api.dto.request.user;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;

public class CreateUser {

    @JsonProperty("code")
    private Long code;
    @JsonProperty("message")
    private String message;
    @JsonProperty("type")
    private String type;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
