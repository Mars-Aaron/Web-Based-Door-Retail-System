/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epda.ejb.api;

import com.epda.ejb.entity.CustomerDetailEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Aaron@Mars
 */
@Stateless
public class CustomerDetailEntityFacade extends AbstractFacade<CustomerDetailEntity> implements CustomerDetailEntityFacadeLocal {

    @PersistenceContext(unitName = "AaronEPDA-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerDetailEntityFacade() {
        super(CustomerDetailEntity.class);
    }

    @Override
    public void create(String customerName, String customerAddress, String customerPhone) {
        CustomerDetailEntity customerDetail = new CustomerDetailEntity(customerName, customerAddress, customerPhone);
        create(customerDetail);
    }

    @Override
    public void edit(String id, String customerName, String customerAddress, String customerPhone) {
        CustomerDetailEntity customer = find(id);
        if (customer != null) {
            customer.setName(customerName);
            customer.setAddress(customerAddress);
            customer.setPhoneNumber(customerPhone);
            edit(customer);
        }
    }

    @Override
    public void remove(String id) {
        CustomerDetailEntity customerDetail;
        if ((customerDetail = find(id)) != null) {
            remove(customerDetail);
        }
    }

}
