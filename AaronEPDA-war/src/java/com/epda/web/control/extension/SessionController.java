/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epda.web.control.extension;

import com.epda.ejb.entity.AccountEntity;
import com.epda.web.control.servlet.exception.PermissionDeniedException;
import com.epda.web.control.servlet.exception.SessionInvalidException;
import com.sdsms.ejb.var.AccountRole;
import com.sdsms.ejb.var.ServicePermission;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Aaron@Mars
 */
public abstract class SessionController extends HttpServlet {

    private String accountTokenIdentifier = "accountToken";
    private String accountRoleIdentifier = "accountRole";

    abstract protected List<ServicePermission> getRequiredPermissions();

    abstract protected List<AccountRole> getPermittedAccountRole();

    protected void validatePermission(HttpServletRequest request, HttpServletResponse response) throws IOException, PermissionDeniedException, SessionInvalidException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute(accountRoleIdentifier) == null || session.getAttribute(accountTokenIdentifier) == null) {
            throw new SessionInvalidException();
        } else {
            if (!isPermissionGranted(Arrays.asList(getAccountRole(request).getPermissions()))
                    && !isRoleMatch(request)) {
                throw new PermissionDeniedException();
            }
        }
    }

    protected boolean hasSession(HttpServletRequest request) {
        return request.getSession(false) != null;
    }

    protected void createUserSession(HttpServletRequest request, AccountEntity account) {
        HttpSession session;
        if ((session = request.getSession(false)) != null) {
            session.invalidate();
        }
        session = request.getSession(true);
        session.setAttribute(accountTokenIdentifier, account.getProfile().getId());
        session.setAttribute(accountRoleIdentifier, account.getAccountRole());

    }

    protected String getAccountToken(HttpServletRequest request) {
        return (String) request.getSession(false).getAttribute(accountTokenIdentifier);
    }

    protected AccountRole getAccountRole(HttpServletRequest request) {
        return (AccountRole) request.getSession(false).getAttribute(accountRoleIdentifier);
    }

    private boolean isPermissionGranted(List<ServicePermission> permissionsOwned) {
        return getRequiredPermissions()
                .stream()
                .noneMatch((requiredPermission) -> (!permissionsOwned.contains(requiredPermission)));
    }

    private boolean isRoleMatch(HttpServletRequest request) {
        return getPermittedAccountRole().contains(getAccountRole(request));
    }
}
