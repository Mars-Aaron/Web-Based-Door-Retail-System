/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epda.ejb.entity;

import com.sdsms.ejb.var.SizeConstraints;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Aaron@Mars
 */
@Entity
@Table(name = "door_sizes")
public class DoorSizeEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(min = 1, max = SizeConstraints.SIZE_NAME_MAX)
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "cost_multiplier")
    private Double costMultiplier;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "size")
    private List<ProductEntity> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCostMultiplier() {
        return costMultiplier;
    }

    public void setCostMultiplier(Double costMultiplier) {
        this.costMultiplier = costMultiplier;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "com.epda.ejb.DoorSizeEntity[ id=" + id + " ]";
    }

}
