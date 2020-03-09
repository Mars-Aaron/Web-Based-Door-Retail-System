/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epda.web.control.servlet.manager.user;

import com.epda.ejb.api.ProfileEntityFacadeLocal;
import com.epda.web.control.extension.SessionController;
import com.epda.web.control.servlet.exception.PermissionDeniedException;
import com.epda.web.control.servlet.exception.SessionInvalidException;
import com.sdsms.ejb.var.AccountRole;
import com.sdsms.ejb.var.ServicePermission;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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
public class EditUserServlet extends SessionController {

    @EJB
    private ProfileEntityFacadeLocal profileFacade;

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
            request.setAttribute("profile", profileFacade.find(request.getParameter("id")));
            request.setAttribute("accountRoles", AccountRole.values());
            request.setAttribute("content", "editUser");
            request.getRequestDispatcher("../manager/dashboard.jsp").forward(request, response);
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
            String profileId = request.getParameter("id");
            String password = request.getParameter("password");
            String fullName = request.getParameter("fullName");
            Date dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateOfBirth"));
            String phoneNumber = request.getParameter("phoneNumber");
            String address = request.getParameter("address");
            profileFacade.edit(profileId, password, fullName, dateOfBirth, phoneNumber, address);
            response.sendRedirect(request.getContextPath() + "/ManagerDashboard");
        } catch (EJBException e) {
            e.printStackTrace();
            response.sendError(503);
        } catch (SessionInvalidException e) {
            response.sendRedirect(request.getContextPath() + "/Login");
        } catch (PermissionDeniedException e) {
            response.sendError(403);
        } catch (Exception e) {
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
    }

    @Override
    protected List<AccountRole> getPermittedAccountRole() {
        return Arrays.asList(new AccountRole[]{AccountRole.SalesManager});
    }

    @Override
    protected List<ServicePermission> getRequiredPermissions() {
        return Arrays.asList(new ServicePermission[]{ServicePermission.READ_ACCOUNT, ServicePermission.READ_PROFILE, ServicePermission.UPDATE_ACCOUNT, ServicePermission.UPDATE_PROFILE});
    }
}
