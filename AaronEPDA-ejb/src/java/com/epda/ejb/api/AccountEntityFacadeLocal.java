/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epda.ejb.api;

import com.epda.ejb.entity.AccountEntity;
import com.sdsms.ejb.var.AccountRole;
import com.sdsms.ejb.var.AccountStatus;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aaron@Mars
 */
@Local
public interface AccountEntityFacadeLocal {

    void create(AccountEntity accountEntity);

    void edit(AccountEntity accountEntity);

    void remove(AccountEntity accountEntity);

    AccountEntity find(Object id);

    List<AccountEntity> findAll();

    List<AccountEntity> findRange(int[] range);

    int count();

    AccountEntity login(String username, String password);

    void deactivate(String accountId);

    void toggleActivity(String accountId, AccountStatus accountStatus);
    
    AccountEntity create(String username, String password, AccountRole accountRole);
}
