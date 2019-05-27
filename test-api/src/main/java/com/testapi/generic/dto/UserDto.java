package com.testapi.generic.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Sebastian Gonzalez
 */
public class UserDto implements Serializable {

    private static final long serialVersionUID = 6541581638249590407L;

    private Long idDto;
    private String firstNameDto;
    private String middleNameDto;
    private String lastNameDto;
    private String secondLastNameDto;
    private String emailDto;
    private int phoneNumberDto;
    private String passwordDto;
    private Date creationDateDto;
    private Date updateDatesDto;
    private Integer activeDto;

    public Integer getProfileDto() {
        return profileDto;
    }

    public void setProfileDto(Integer profileDto) {
        this.profileDto = profileDto;
    }

    private Integer profileDto;

    public UserDto(){

    }

    public Long getIdDto() {
        return idDto;
    }

    public void setIdDto(Long idDto) {
        this.idDto = idDto;
    }

    public String getFirstNameDto() {
        return firstNameDto;
    }

    public void setFirstNameDto(String firstNameDto) {
        this.firstNameDto = firstNameDto;
    }

    public String getMiddleNameDto() {
        return middleNameDto;
    }

    public void setMiddleNameDto(String middleNameDto) {
        this.middleNameDto = middleNameDto;
    }

    public String getLastNameDto() {
        return lastNameDto;
    }

    public void setLastNameDto(String lastNameDto) {
        this.lastNameDto = lastNameDto;
    }

    public String getSecondLastNameDto() {
        return secondLastNameDto;
    }

    public void setSecondLastNameDto(String secondLastNameDto) {
        this.secondLastNameDto = secondLastNameDto;
    }

    public String getEmailDto() {
        return emailDto;
    }

    public void setEmailDto(String emailDto) {
        this.emailDto = emailDto;
    }

    public int getPhoneNumberDto() {
        return phoneNumberDto;
    }

    public void setPhoneNumberDto(int phoneNumberDto) {
        this.phoneNumberDto = phoneNumberDto;
    }

    public String getPasswordDto() {
        return passwordDto;
    }

    public void setPasswordDto(String passwordDto) {
        this.passwordDto = passwordDto;
    }

    public Date getCreationDateDto() {
        return creationDateDto;
    }

    public void setCreationDateDto(Date creationDateDto) {
        this.creationDateDto = creationDateDto;
    }

    public Date getUpdateDatesDto() {
        return updateDatesDto;
    }

    public void setUpdateDatesDto(Date updateDatesDto) {
        this.updateDatesDto = updateDatesDto;
    }

    public Integer getActiveDto() {
        return activeDto;
    }

    public void setActiveDto(Integer activeDto) {
        this.activeDto = activeDto;
    }

}
