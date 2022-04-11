package api.dto.request.user;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;

public class CreateUser {

    @JsonProperty("code")
    private Long mCode;
    @JsonProperty("message")
    private String mMessage;
    @JsonProperty("type")
    private String mType;

    public Long getCode() {
        return mCode;
    }

    public void setCode(Long code) {
        mCode = code;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

}
