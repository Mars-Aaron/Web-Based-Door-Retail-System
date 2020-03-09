/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdsms.ejb.var;

/**
 *
 * @author Aaron@Mars
 */
public enum AccountRole {
    SalesManager {
        @Override
        public String toString() {
            return "Sales Manager";
        }

        @Override
        public ServicePermission[] getPermissions() {
            return new ServicePermission[]{
                ServicePermission.CREATE_ACCOUNT, ServicePermission.CREATE_CUSTOMER,
                ServicePermission.CREATE_DOOR, ServicePermission.CREATE_ORDER,
                ServicePermission.CREATE_PRODUCT, ServicePermission.CREATE_PROFILE,
                ServicePermission.CREATE_SIZE, ServicePermission.DELETE_DOOR,
                ServicePermission.DELETE_SIZE, ServicePermission.READ_ACCOUNT,
                ServicePermission.READ_CUSTOMER, ServicePermission.READ_DOOR,
                ServicePermission.READ_ORDER, ServicePermission.READ_PRODUCT,
                ServicePermission.READ_PROFILE, ServicePermission.READ_SIZE,
                ServicePermission.UPDATE_ACCOUNT, ServicePermission.UPDATE_DOOR,
                ServicePermission.UPDATE_PROFILE, ServicePermission.UPDATE_SIZE
            };
        }
    },
    SalesAssistant {
        @Override
        public String toString() {
            return "Sales Assistant";
        }

        @Override
        public ServicePermission[] getPermissions() {
            return new ServicePermission[]{
                ServicePermission.READ_ACCOUNT, ServicePermission.READ_CUSTOMER,
                ServicePermission.READ_PROFILE, ServicePermission.READ_ORDER,
                ServicePermission.READ_PRODUCT, ServicePermission.UPDATE_CUSTOMER,
                ServicePermission.UPDATE_ORDER, ServicePermission.UPDATE_PROFILE,
                ServicePermission.UPDATE_ACCOUNT
            };
        }
    },
    TechnicalInstaller {
        @Override
        public String toString() {
            return "Technical Installer";
        }

        @Override
        public ServicePermission[] getPermissions() {
            return new ServicePermission[]{
                ServicePermission.READ_ORDER, ServicePermission.READ_CUSTOMER,
                ServicePermission.READ_ACCOUNT, ServicePermission.READ_PRODUCT,
                ServicePermission.READ_PROFILE, ServicePermission.UPDATE_ACCOUNT,
                ServicePermission.UPDATE_ORDER, ServicePermission.UPDATE_PROFILE
            };
        }
    };

    public abstract ServicePermission[] getPermissions();
}
