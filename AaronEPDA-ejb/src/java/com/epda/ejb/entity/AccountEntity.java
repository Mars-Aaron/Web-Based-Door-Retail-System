/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epda.ejb.entity;

import com.sdsms.ejb.var.AccountStatus;
import com.sdsms.ejb.var.AccountRole;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aaron@Mars
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountEntity.findByUsername", query = "select u from AccountEntity u where u.username = :username")
    , @NamedQuery(name = "AccountEntity.login", query = "select u from AccountEntity u where u.username = :username and u.password = :password")
})
public class AccountEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(min = 5, max = 20)
    @Column(name = "username", unique = true)
    private String username;

    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "password")
    private String password;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "last_logged_in")
    private Date lastLoggedIn;

    @NotNull
    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "account_status")
    private AccountStatus accountStatus;

    @NotNull
    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "account_role")
    private AccountRole accountRole;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "account")
    private ProfileEntity profile;

    public AccountEntity() {
    }

    public AccountEntity(String username, String password, AccountRole accountRole) {
        this.username = username;
        this.password = password;
        this.accountRole = accountRole;
        this.accountStatus = AccountStatus.Active;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLoggedIn() {
        return lastLoggedIn;
    }

    public void setLastLoggedIn(Date lastLoggedIn) {
        this.lastLoggedIn = lastLoggedIn;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus status) {
        this.accountStatus = status;
    }

    public AccountRole getAccountRole() {
        return accountRole;
    }

    public void setAccountRole(AccountRole accountRole) {
        this.accountRole = accountRole;
    }

    public ProfileEntity getProfile() {
        return profile;
    }

    public void setProfile(ProfileEntity profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "com.epda.ejb.UserEntity[ id=" + id + " ]";
    }

}
