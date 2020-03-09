/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epda.ejb.api;

import com.epda.ejb.entity.ProductEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aaron@Mars
 */
@Local
public interface ProductEntityFacadeLocal {

    void create(ProductEntity productEntity);

    void edit(ProductEntity productEntity);

    void remove(ProductEntity productEntity);

    ProductEntity find(Object id);

    List<ProductEntity> findAll();

    List<ProductEntity> findRange(int[] range);

    int count();
    
}
