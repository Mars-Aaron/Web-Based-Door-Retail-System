/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epda.ejb.api;

import com.epda.ejb.entity.AccountEntity;
import com.sdsms.ejb.var.AccountRole;
import com.sdsms.ejb.var.AccountStatus;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Aaron@Mars
 */
@Stateless
public class AccountEntityFacade extends AbstractFacade<AccountEntity> implements AccountEntityFacadeLocal {

    @PersistenceContext(unitName = "AaronEPDA-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountEntityFacade() {
        super(AccountEntity.class);
    }

    @Override
    public AccountEntity login(String username, String password) {
        try {
            AccountEntity account = (AccountEntity) em.createNamedQuery("AccountEntity.login")
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
            if (account.getAccountStatus() == AccountStatus.Active) {
                account.setLastLoggedIn(new Date());
                edit(account);
                return account;
            } else {
                return null;
            }
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void deactivate(String accountId) {
        AccountEntity account;
        if ((account = find(accountId)) != null) {
            account.setAccountStatus(AccountStatus.InActive);
            edit(account);
        }
    }

    @Override
    public AccountEntity create(String username, String password, AccountRole accountRole) {
        AccountEntity account = new AccountEntity(username, password, accountRole);
        account.setAccountStatus(AccountStatus.Active);
        create(account);
        return account;
    }

    @Override
    public void toggleActivity(String accountId, AccountStatus accountStatus) {
        AccountEntity account = find(accountId);
        account.setAccountStatus(accountStatus);
        edit(account);
    }

}
