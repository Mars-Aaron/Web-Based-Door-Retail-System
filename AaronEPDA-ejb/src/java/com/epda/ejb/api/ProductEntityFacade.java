/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epda.ejb.api;

import com.epda.ejb.entity.ProductEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Aaron@Mars
 */
@Stateless
public class ProductEntityFacade extends AbstractFacade<ProductEntity> implements ProductEntityFacadeLocal {

    @PersistenceContext(unitName = "AaronEPDA-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductEntityFacade() {
        super(ProductEntity.class);
    }
    
}
