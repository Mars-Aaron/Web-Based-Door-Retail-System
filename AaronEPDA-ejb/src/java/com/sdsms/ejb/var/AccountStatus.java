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
public enum AccountStatus {
    Active {
        @Override
        public String toString() {
            return "Active";
        }

    },
    InActive {
        @Override
        public String toString() {
            return "In-Active";
        }
    }
}
