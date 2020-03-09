/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epda.web.control.servlet.authentication;

import com.epda.ejb.api.AccountEntityFacadeLocal;
import com.epda.ejb.entity.AccountEntity;
import com.epda.web.control.extension.SessionController;
import com.sdsms.ejb.var.AccountRole;
import com.sdsms.ejb.var.ServicePermission;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author Aaron@Mars
 */
public class LoginServlet extends SessionController {

    @EJB
    private AccountEntityFacadeLocal accountFacade;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("contextPath", request.getContextPath());
        request.getRequestDispatcher("auth/login.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String username = request.getParameter("username"),
                    password = request.getParameter("password");
            AccountEntity account = accountFacade.login(username, password);
            if (account != null) {
                createUserSession(request, account);
                if (account.getAccountRole() == AccountRole.SalesManager) {
                    response.sendRedirect(request.getContextPath() + "/ManagerDashboard");
                } else if (account.getAccountRole() == AccountRole.SalesAssistant) {
                    response.sendRedirect(request.getContextPath() + "/AssistantDashboard");
                } else if (account.getAccountRole() == AccountRole.TechnicalInstaller) {
                    response.sendRedirect(request.getContextPath() + "/InstallerDashboard");
                }
            } else {
                request.setAttribute("contextPath", request.getContextPath());
                request.setAttribute("loginFailed", "");
                request.getRequestDispatcher("auth/login.jsp").forward(request, response);
            }
        } catch (EJBException e) {
            @SuppressWarnings("ThrowableResultIgnored")
            Exception cause = e.getCausedByException();
            if (cause instanceof ConstraintViolationException) {
                @SuppressWarnings("ThrowableResultIgnored")
                ConstraintViolationException cve = (ConstraintViolationException) e.getCausedByException();
                for (Iterator<ConstraintViolation<?>> it = cve.getConstraintViolations().iterator(); it.hasNext();) {
                    ConstraintViolation<? extends Object> v = it.next();
                    System.err.println(v);
                    System.err.println("==>>" + v.getMessage());
                }
            }
            response.sendError(503);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    protected List<ServicePermission> getRequiredPermissions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<AccountRole> getPermittedAccountRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
