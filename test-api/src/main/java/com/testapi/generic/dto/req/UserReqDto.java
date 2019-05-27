package com.testapi.generic.dto.req;

import java.io.Serializable;

/**
 * Sebastian Gonzalez
 */

public class UserReqDto implements Serializable {

    private static final long serialVersionUID = 4457792822963157284L;
    private String emailDto;
    private String passwordDto;

    public String getEmailDto() {
        return emailDto;
    }

    public void setEmailDto(String emailDto) {
        this.emailDto = emailDto;
    }

    public String getPasswordDto() {
        return passwordDto;
    }

    public void setPasswordDto(String passwordDto) {
        this.passwordDto = passwordDto;
    }

}
