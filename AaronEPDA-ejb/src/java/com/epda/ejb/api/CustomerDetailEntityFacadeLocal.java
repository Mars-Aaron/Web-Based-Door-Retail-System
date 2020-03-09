/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epda.ejb.api;

import com.epda.ejb.entity.CustomerDetailEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aaron@Mars
 */
@Local
public interface CustomerDetailEntityFacadeLocal {

    void create(CustomerDetailEntity customerDetailEntity);

    void edit(CustomerDetailEntity customerDetailEntity);

    void remove(CustomerDetailEntity customerDetailEntity);

    CustomerDetailEntity find(Object id);

    List<CustomerDetailEntity> findAll();

    List<CustomerDetailEntity> findRange(int[] range);

    int count();

    void create(String customerName, String customerAddress, String customerPhone);

    void edit(String id, String customerName, String customerAddress, String customerPhone);

    void remove(String id);
}
