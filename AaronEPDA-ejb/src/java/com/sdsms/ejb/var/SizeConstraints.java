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
public class SizeConstraints {

    /*
     * Account Entity
     */
    public static final int USERNAME_MAX = 20;
    public static final int PASSWORD_MAX = 20;

    /*
     * Profile Entity
     */
    public static final int FULL_NAME_MAX = 50;
    public static final int ADDRESS_MAX = 300;
    public static final int PHONE_MAX = 30;

    /*
     * Door Entity
     */
    public static final int CATEGORY_NAME_MAX = 100;
    public static final int TYPE_NAME_MAX = 100;

    /*
     * Size Entity
     */
    public static final int SIZE_NAME_MAX = 30;

}
