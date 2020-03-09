/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epda.ejb.entity;

import com.sdsms.ejb.var.OrderStatus;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Aaron@Mars
 */
@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "order_timestamp")
    private Date orderTimestamp;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "installation_date")
    private Date installationDate;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "completion_timestamp")
    private Date completionTimestamp;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "status")
    private OrderStatus status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<ProductEntity> products;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerDetailEntity customer;

    @ManyToOne
    @JoinColumn(name = "installer_id")
    private ProfileEntity installer;

    public OrderEntity() {
    }

    public OrderEntity(Date orderTimestamp, CustomerDetailEntity customerDetail) {
        this.orderTimestamp = orderTimestamp;
        this.status = OrderStatus.InProgress;
        this.customer = customerDetail;
    }

    public Double getServiceCost() {
        return 10.0;
    }

    public Date getOrderTimestamp() {
        return orderTimestamp;
    }

    public void setOrderTimestamp(Date orderTimestamp) {
        this.orderTimestamp = orderTimestamp;
    }

    public Date getInstallationDate() {
        return installationDate;
    }

    public void setInstallationDate(Date installationDate) {
        this.installationDate = installationDate;
    }

    public Date getCompletionTimestamp() {
        return completionTimestamp;
    }

    public void setCompletionTimestamp(Date completionTimestamp) {
        this.completionTimestamp = completionTimestamp;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    public CustomerDetailEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDetailEntity customer) {
        this.customer = customer;
    }

    public ProfileEntity getInstaller() {
        return installer;
    }

    public void setInstaller(ProfileEntity installer) {
        this.installer = installer;
    }

    public String getFormattedOrderTimestamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
        return dateFormat.format(orderTimestamp);
    }

    public String getSimpleOrderTimestamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(orderTimestamp);
    }

    public String getFormattedInstallationDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(installationDate);
    }

    public String getFormattedCompletionTimestamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
        return dateFormat.format(completionTimestamp);
    }

    public double getTotalCost() {
        double totalCost = 0;
        totalCost = products.stream()
                .map((product) -> product.getCost())
                .reduce(totalCost, (accumulator, _item) -> accumulator + _item);
        return totalCost;
    }

    @Override
    public String toString() {
        return "com.epda.ejb.OrderEntity[ id=" + id + " ]";
    }

}
