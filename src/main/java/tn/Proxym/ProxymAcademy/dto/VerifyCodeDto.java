package tn.Proxym.ProxymAcademy.dto;

import tn.Proxym.ProxymAcademy.validator.user_verify.ValidVerifyCode;

public class VerifyCodeDto {
    @ValidVerifyCode
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;

    }

}
