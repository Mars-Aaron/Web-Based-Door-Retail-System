/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epda.ejb.api;

import com.epda.ejb.entity.AccountEntity;
import com.epda.ejb.entity.OrderEntity;
import com.epda.ejb.entity.ProfileEntity;
import com.sdsms.ejb.var.AccountRole;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aaron@Mars
 */
@Local
public interface ProfileEntityFacadeLocal {

    void create(ProfileEntity profileEntity);

    void edit(ProfileEntity profileEntity);

    void remove(ProfileEntity profileEntity);

    ProfileEntity find(Object id);

    List<ProfileEntity> findAll();

    List<ProfileEntity> findRange(int[] range);

    int count();

    void create(AccountEntity account, String fullName, Date dateOfBirth, String phoneNumber, String address);

    void edit(String profileId, String password, String fullName, Date dateOfBirth, String phoneNumber, String address);

    void remove(String profileId);
    
    List<OrderEntity> getOrders(String profileId);
}
