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
@Table(name = "doors")
public class DoorEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(min = 1, max = SizeConstraints.CATEGORY_NAME_MAX)
    @Column(name = "category_name")
    private String categoryName;

    @NotNull
    @Size(min = 1, max = SizeConstraints.TYPE_NAME_MAX)
    @Column(name = "type_name")
    private String typeName;

    @NotNull
    @Column(name = "basic_cost")
    private Double basicCost;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "door")
    private List<ProductEntity> products;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Double getBasicCost() {
        return basicCost;
    }

    public void setBasicCost(Double basicCost) {
        this.basicCost = basicCost;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "com.epda.ejb.DoorEntity[ id=" + id + " ]";
    }

}
