/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epda.web.control.servlet.assistant.order;

import com.epda.ejb.api.OrderEntityFacadeLocal;
import com.epda.ejb.api.ProfileEntityFacadeLocal;
import com.epda.ejb.entity.ProfileEntity;
import com.epda.web.control.extension.SessionController;
import com.epda.web.control.servlet.exception.PermissionDeniedException;
import com.epda.web.control.servlet.exception.SessionInvalidException;
import com.sdsms.ejb.var.AccountRole;
import com.sdsms.ejb.var.AccountStatus;
import com.sdsms.ejb.var.ServicePermission;
import java.io.IOException;
import java.text.ParseException;
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
public class AssignInstallerServlet extends SessionController {

    @EJB
    private OrderEntityFacadeLocal orderFacade;
    @EJB
    private ProfileEntityFacadeLocal profileFacade;

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
            String orderId = request.getParameter("id");
            List<ProfileEntity> installers = profileFacade.findAll();
            installers.removeIf(user -> !user.getAccount().getAccountRole().equals(AccountRole.TechnicalInstaller) || user.getAccount().getAccountStatus().equals(AccountStatus.InActive));
            request.setAttribute("contextPath", request.getContextPath());
            request.setAttribute("order", orderFacade.find(orderId));
            request.setAttribute("installers", installers);
            request.setAttribute("content", "assignInstaller");
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
            String orderId = request.getParameter("orderId");
            String installerId = request.getParameter("installerId");
            Date installationDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("installationDate"));
            orderFacade.assignInstaller(orderId, installationDate, profileFacade.find(installerId));
            response.sendRedirect(request.getContextPath() + "/AssistantDashboard/ReadOrders");
        } catch (EJBException | ParseException e) {
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
        return Arrays.asList(new ServicePermission[]{ServicePermission.READ_ORDER, ServicePermission.UPDATE_ORDER});
    }
}
