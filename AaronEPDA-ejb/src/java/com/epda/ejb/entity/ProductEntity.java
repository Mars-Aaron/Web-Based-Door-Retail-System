/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epda.ejb.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Aaron@Mars
 */
@Entity
@Table(name = "products")
public class ProductEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "door_id")
    private DoorEntity door;

    @ManyToOne
    @JoinColumn(name = "size_id")
    private DoorSizeEntity size;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    public DoorEntity getDoor() {
        return door;
    }

    public void setDoor(DoorEntity door) {
        this.door = door;
    }

    public DoorSizeEntity getSize() {
        return size;
    }

    public void setSize(DoorSizeEntity size) {
        this.size = size;
    }
    
    public void setOrder(OrderEntity order) {
        this.order = order;
    }
    
    public OrderEntity getOrder() {
        return order;
    }

    public double getCost() {
        return door.getBasicCost() * size.getCostMultiplier();
    }

    @Override
    public String toString() {
        return "com.epda.ejb.ProductEntity[ id=" + id + " ]";
    }

}
