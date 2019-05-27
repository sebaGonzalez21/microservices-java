package com.test.generic.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;
/**
 * Sebastian Gonzalez
 */

@Entity
@Table(name = "tst_user")
public class User {

    @Id
    @Column(name="tst_seq_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "tst_first_name")
    private String firstName;

    @Column(name = "tst_middle_name")
    private String middleName;

    @NotNull
    @Column(name = "tst_last_name")
    private String lastName;

    @NotNull
    @Column(name = "tst_second_last_name")
    private String secondLastName;

    @NotNull
    @Column(name = "tst_email")
    private String email;

    @NotNull
    @Column(name = "tst_phone_number")
    private int phoneNumber;

    @NotNull
    @Column(name = "tst_password")
    private String password;

    @NotNull
    @Column(name = "tst_dtt_creation")
    private Date creationDate;

    @Column(name = "tst_dtt_update")
    private Date updateDates;

    @NotNull
    @Column(name = "tst_flg_active")
    @ColumnDefault("1")
    private Integer active;

    @NotNull
    @Column(name = "tst_profile")
    @ColumnDefault("1")
    private Integer profile;

    public User(){
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDates() {
        return updateDates;
    }

    public void setUpdateDates(Date updateDates) {
        this.updateDates = updateDates;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getProfile() {
        return profile;
    }

    public void setProfile(Integer profile) {
        this.profile = profile;
    }
}
