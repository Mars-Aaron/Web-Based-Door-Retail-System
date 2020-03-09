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
public enum OrderStatus {

    InProgress {
        @Override
        public String toString() {
            return "In Progress";
        }
    },
    Completed {
        @Override
        public String toString() {
            return "Completed";
        }
    },
    Cancelled {
        @Override
        public String toString() {
            return "Cancelled";
        }
    }
}
