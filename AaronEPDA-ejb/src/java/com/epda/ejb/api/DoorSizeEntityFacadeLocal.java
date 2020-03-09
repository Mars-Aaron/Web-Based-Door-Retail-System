/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epda.ejb.api;

import com.epda.ejb.entity.DoorSizeEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aaron@Mars
 */
@Local
public interface DoorSizeEntityFacadeLocal {

    void create(DoorSizeEntity doorSizeEntity);

    void edit(DoorSizeEntity doorSizeEntity);

    void remove(DoorSizeEntity doorSizeEntity);

    DoorSizeEntity find(Object id);

    List<DoorSizeEntity> findAll();

    List<DoorSizeEntity> findRange(int[] range);

    int count();
    
}
