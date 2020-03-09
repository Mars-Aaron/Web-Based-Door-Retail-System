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
import com.sdsms.ejb.var.OrderStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Aaron@Mars
 */
@Stateless
public class OrderEntityFacade extends AbstractFacade<OrderEntity> implements OrderEntityFacadeLocal {

    @PersistenceContext(unitName = "AaronEPDA-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderEntityFacade() {
        super(OrderEntity.class);
    }

    @Override
    public void create(String doorId, String sizeId, String customerName, String customerAddress, String customerPhoneNumber) {
        CustomerDetailEntity customerDetail = new CustomerDetailEntity(customerName, customerAddress, customerPhoneNumber);
        OrderEntity order = new OrderEntity(new Date(), customerDetail);
        create(order);
    }

    @Override
    public OrderEntity create(CustomerDetailEntity customer) {
        OrderEntity order = new OrderEntity();
        order.setCustomer(customer);
        order.setOrderTimestamp(new Date());
        order.setStatus(OrderStatus.InProgress);
        create(order);
        return order;
    }

    @Override
    public void edit(String orderId, String customerName, String customerAddress, String customerPhoneNumber) {
        OrderEntity order;
        if ((order = find(orderId)) != null) {
            order.getCustomer().setName(customerName);
            order.getCustomer().setAddress(customerAddress);
            order.getCustomer().setPhoneNumber(customerPhoneNumber);
            edit(order);
        }
    }

    @Override
    public void assignInstaller(String orderId, Date installationDate, ProfileEntity installer) {
        OrderEntity order;
        if ((order = find(orderId)) != null) {
            order.setInstallationDate(installationDate);
            order.setInstaller(installer);
            edit(order);
        }
    }

    @Override
    public void unassignInstaller(String orderId) {
        OrderEntity order;
        if ((order = find(orderId)) != null) {
            order.setInstaller(null);
            order.setInstallationDate(null);
            edit(order);
        }
    }

    @Override
    public void complete(String orderId) {
        OrderEntity order;
        if ((order = find(orderId)) != null) {
            order.setStatus(OrderStatus.Completed);
            edit(order);
        }
    }

    @Override
    public void restore(String orderId) {
        OrderEntity order;
        if ((order = find(orderId)) != null) {
            order.setStatus(OrderStatus.InProgress);
            edit(order);
        }
    }

    @Override
    public void cancel(String orderId) {
        OrderEntity order;
        if ((order = find(orderId)) != null) {
            order.setStatus(OrderStatus.Cancelled);
            edit(order);
        }
    }

    @Override
    public List<OrderEntity> filter(String location) {
        List<OrderEntity> orders = findAll();
        orders.removeIf(order -> !order.getCustomer().getAddress().contains(location));
        return orders;
    }

    @Override
    public List<OrderEntity> filter(String from, String to) throws ParseException {
        List<OrderEntity> orders = findAll();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = dateFormat.parse(from);
        Date toDate = dateFormat.parse(to);
        orders.removeIf(order -> !(order.getOrderTimestamp().after(fromDate)
                && order.getOrderTimestamp().before(toDate))
        );
        return orders;
    }

    @Override
    public List<OrderEntity> filter(String location, String from, String to) throws ParseException {
        List<OrderEntity> orders = findAll();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = dateFormat.parse(from);
        Date toDate = dateFormat.parse(to);
        orders.removeIf(order -> !order.getCustomer().getAddress().contains(location));
        orders.removeIf(order -> !(order.getOrderTimestamp().after(fromDate)
                && order.getOrderTimestamp().before(toDate))
        );
        return orders;
    }

    @Override
    public double getRevenueForListOfOrders(Object object) {
        List<OrderEntity> orders = (List<OrderEntity>) object;
        double revenue = 0;
        for (OrderEntity order : orders) {
            revenue += order.getTotalCost();
        }
        return revenue;
    }

    @Override
    public List<String> getLocations() {
        List<OrderEntity> orders = findAll();
        return orders.stream().map(order -> order.getCustomer().getAddress()).collect(Collectors.toList());
    }

}
