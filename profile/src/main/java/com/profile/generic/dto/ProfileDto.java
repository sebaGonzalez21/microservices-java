package com.profile.generic.dto;

import java.io.Serializable;

/**
 * Sebastian Gonzalez
 */
public class ProfileDto implements Serializable {
    private static final long serialVersionUID = 3799817052022778347L;

    private Long idDto;
    private String nameDto;
    private Integer flagActivateDto;

    public Long getIdDto() {
        return idDto;
    }

    public void setIdDto(Long idDto) {
        this.idDto = idDto;
    }

    public String getNameDto() {
        return nameDto;
    }

    public void setNameDto(String nameDto) {
        this.nameDto = nameDto;
    }

    public Integer getFlagActivateDto() {
        return flagActivateDto;
    }

    public void setFlagActivateDto(Integer flagActivateDto) {
        this.flagActivateDto = flagActivateDto;
    }
}
