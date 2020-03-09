/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epda.web.control.servlet.manager.order;

import com.epda.ejb.api.CustomerDetailEntityFacadeLocal;
import com.epda.ejb.api.DoorEntityFacadeLocal;
import com.epda.ejb.api.DoorSizeEntityFacadeLocal;
import com.epda.ejb.api.OrderEntityFacadeLocal;
import com.epda.ejb.api.ProductEntityFacadeLocal;
import com.epda.ejb.entity.OrderEntity;
import com.epda.ejb.entity.ProductEntity;
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
public class CreateOrderServlet extends SessionController {

    @EJB
    private DoorEntityFacadeLocal doorFacade;
    @EJB
    private DoorSizeEntityFacadeLocal doorSizeFacade;
    @EJB
    private CustomerDetailEntityFacadeLocal customerDetailFacade;
    @EJB
    private ProductEntityFacadeLocal productFacade;
    @EJB
    private OrderEntityFacadeLocal orderFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

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
            request.setAttribute("doors", doorFacade.findAll());
            request.setAttribute("sizes", doorSizeFacade.findAll());
            request.setAttribute("customers", customerDetailFacade.findAll());
            request.setAttribute("content", "createOrder");
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
            String customerId = request.getParameter("customerId");
            String[] doorIds = request.getParameterValues("doorId");
            String[] sizeIds = request.getParameterValues("sizeId");
            OrderEntity order = orderFacade.create(customerDetailFacade.find(customerId));
            for (int i = 0; i < doorIds.length; ++i) {
                ProductEntity product = new ProductEntity();
                product.setDoor(doorFacade.find(doorIds[i]));
                product.setSize(doorSizeFacade.find(sizeIds[i]));
                product.setOrder(order);
                productFacade.create(product);
            }
            response.sendRedirect(request.getContextPath() + "/ManagerDashboard/ReadOrders");
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
        return Arrays.asList(new AccountRole[]{AccountRole.SalesManager});
    }

    @Override
    protected List<ServicePermission> getRequiredPermissions() {
        return Arrays.asList(new ServicePermission[]{ServicePermission.READ_DOOR, ServicePermission.READ_CUSTOMER, ServicePermission.READ_SIZE});
    }
}
