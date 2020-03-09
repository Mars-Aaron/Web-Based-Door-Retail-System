/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epda.ejb.api;

import com.epda.ejb.entity.DoorEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aaron@Mars
 */
@Local
public interface DoorEntityFacadeLocal {

    void create(DoorEntity doorEntity);

    void edit(DoorEntity doorEntity);

    void remove(DoorEntity doorEntity);

    DoorEntity find(Object id);

    List<DoorEntity> findAll();

    List<DoorEntity> findRange(int[] range);

    int count();
    
}
