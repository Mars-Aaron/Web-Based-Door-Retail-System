/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epda.ejb.api;

import com.epda.ejb.entity.AccountEntity;
import com.epda.ejb.entity.OrderEntity;
import com.epda.ejb.entity.ProfileEntity;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Aaron@Mars
 */
@Stateless
public class ProfileEntityFacade extends AbstractFacade<ProfileEntity> implements ProfileEntityFacadeLocal {

    @PersistenceContext(unitName = "AaronEPDA-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProfileEntityFacade() {
        super(ProfileEntity.class);
    }

    @Override
    public void create(AccountEntity account, String fullName, Date dateOfBirth, String phoneNumber, String address) {
        ProfileEntity profile = new ProfileEntity(fullName, dateOfBirth, phoneNumber, address, account);
        create(profile);
    }

    @Override
    public void edit(String profileId, String password, String fullName, Date dateOfBirth, String phoneNumber, String address) {
        ProfileEntity profile = find(profileId);
        if (profile != null) {
            profile.setFullName(fullName);
            profile.setDateOfBirth(dateOfBirth);
            profile.setPhoneNumber(phoneNumber);
            profile.setAddress(address);
            profile.getAccount().setPassword(password);
            edit(profile);
        }
    }

    @Override
    public void remove(String profileId) {
        ProfileEntity profile;
        if ((profile = find(profileId)) != null) {
            remove(profile);
        }
    }

    @Override
    public List<OrderEntity> getOrders(String profileId) {
        ProfileEntity profile;
        if ((profile = find(profileId)) != null) {
            return profile.getAssignedJobs();
        }
        return null;
    }

}
