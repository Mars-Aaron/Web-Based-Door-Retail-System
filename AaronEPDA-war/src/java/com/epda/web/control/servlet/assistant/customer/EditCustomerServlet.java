/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epda.web.control.servlet.assistant.customer;

import com.epda.ejb.api.CustomerDetailEntityFacadeLocal;
import com.epda.web.control.extension.SessionController;
import com.epda.web.control.servlet.exception.PermissionDeniedException;
import com.epda.web.control.servlet.exception.SessionInvalidException;
import com.sdsms.ejb.var.AccountRole;
import com.sdsms.ejb.var.ServicePermission;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aaron@Mars
 */
public class EditCustomerServlet extends SessionController {

    @EJB
    private CustomerDetailEntityFacadeLocal customerFacade;

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
        try {
            validatePermission(request, response);
            request.setAttribute("contextPath", request.getContextPath());
            request.setAttribute("customer", customerFacade.find(request.getParameter("id")));
            request.setAttribute("content", "editCustomer");
            request.getRequestDispatcher("../assistant/dashboard.jsp").forward(request, response);
        } catch (EJBException e) {
            e.printStackTrace();
            response.sendError(503);
        } catch (SessionInvalidException e) {
            response.sendRedirect(request.getContextPath() + "/Login");
        } catch (PermissionDeniedException e) {
            response.sendError(403);
        }
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
            validatePermission(request, response);
            request.setAttribute("contextPath", request.getContextPath());
            customerFacade.edit(request.getParameter("id"), request.getParameter("name"), request.getParameter("address"), request.getParameter("phone"));
            response.sendRedirect(request.getContextPath() + "/AssistantDashboard/ReadCustomers");
        } catch (EJBException e) {
            e.printStackTrace();
            response.sendError(503);
        } catch (SessionInvalidException e) {
            response.sendRedirect(request.getContextPath() + "/Login");
        } catch (PermissionDeniedException e) {
            response.sendError(403);
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
    protected List<AccountRole> getPermittedAccountRole() {
        return Arrays.asList(new AccountRole[]{AccountRole.SalesAssistant});
    }

    @Override
    protected List<ServicePermission> getRequiredPermissions() {
        return Arrays.asList(new ServicePermission[]{ServicePermission.READ_CUSTOMER, ServicePermission.UPDATE_CUSTOMER});
    }

}
