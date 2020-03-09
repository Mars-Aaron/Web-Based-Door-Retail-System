/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epda.ejb.api;

import com.epda.ejb.entity.CustomerDetailEntity;
import com.epda.ejb.entity.OrderEntity;
import com.epda.ejb.entity.ProductEntity;
import com.epda.ejb.entity.ProfileEntity;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aaron@Mars
 */
@Local
public interface OrderEntityFacadeLocal {

    void create(OrderEntity orderEntity);

    void edit(OrderEntity orderEntity);

    void remove(OrderEntity orderEntity);

    OrderEntity find(Object id);

    List<OrderEntity> findAll();

    List<OrderEntity> findRange(int[] range);

    int count();

    void create(String doorId, String sizeId, String customerName, String customerAddress, String customerPhoneNumber);

    OrderEntity create(CustomerDetailEntity customer);

    void edit(String orderId, String customerName, String customerAddress, String customerPhoneNumber);

    void assignInstaller(String orderId, Date installationDate, ProfileEntity installer);
    
    void unassignInstaller(String orderId);

    void complete(String orderId);
    
    void restore(String orderId);

    void cancel(String orderId);
    
    List<OrderEntity> filter(String location);
    
    List<OrderEntity> filter(String String, String to) throws ParseException;
    
    List<OrderEntity> filter(String location, String from, String to) throws ParseException;
    
    double getRevenueForListOfOrders(Object object);
    
    List<String> getLocations();
}
