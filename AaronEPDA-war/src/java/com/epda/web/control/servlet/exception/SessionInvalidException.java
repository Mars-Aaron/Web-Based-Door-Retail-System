/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epda.web.control.servlet.exception;

/**
 *
 * @author Aaron@Mars
 */
public class SessionInvalidException extends Exception {

    /**
     * Creates a new instance of <code>SessionInvalidException</code> without
     * detail message.
     */
    public SessionInvalidException() {
    }

    /**
     * Constructs an instance of <code>SessionInvalidException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public SessionInvalidException(String msg) {
        super(msg);
    }
}
