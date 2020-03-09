/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epda.ejb.entity;

import com.sdsms.ejb.var.SizeConstraints;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Aaron@Mars
 */
@Entity
@Table(name = "profiles")
public class ProfileEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(min = 1, max = SizeConstraints.FULL_NAME_MAX)
    @Column(name = "full_name")
    private String fullName;

    @NotNull
    @Temporal(value = TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @NotNull
    @Size(max = SizeConstraints.PHONE_MAX)
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotNull
    @Size(max = SizeConstraints.ADDRESS_MAX)
    @Column(name = "address")
    private String address;

    @OneToOne
    @JoinColumn(name = "account_id")
    private AccountEntity account;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "installer")
    private List<OrderEntity> assignedJobs;

    public ProfileEntity() {
    }

    public ProfileEntity(String fullName, Date dateOfBirth, String phoneNumber, String address) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public ProfileEntity(String fullName, Date dateOfBirth, String phoneNumber, String address, AccountEntity account) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.account = account;
    }

    public List<OrderEntity> getAssignedJobs() {
        return assignedJobs;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccountEntity(AccountEntity account) {
        this.account = account;
    }

    public String getFormattedDateOfBirth() {
        return new SimpleDateFormat("yyyy MMMM, dd").format(dateOfBirth);
    }

    public String getHtmlSafeDOB() {
        return new SimpleDateFormat("yyyy-MM-dd").format(dateOfBirth);
    }

    @Override
    public String toString() {
        return "com.epda.ejb.ProfileEntity[ id=" + id + " ]";
    }

}
