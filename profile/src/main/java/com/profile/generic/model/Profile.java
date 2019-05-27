package com.profile.generic.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Sebastian Gonzalez
 */

@Entity
@Table(name = "tst_profile")
public class Profile {

    @Id
    @Column(name="tst_seq_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="tst_name")
    @NotNull
    private String name;

    @Column(name="tst_flg")
    @ColumnDefault("1")
    @NotNull
    private Integer flagActivate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFlagActivate() {
        return flagActivate;
    }

    public void setFlagActivate(Integer flagActivate) {
        this.flagActivate = flagActivate;
    }

}
