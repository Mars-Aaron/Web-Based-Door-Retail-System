/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epda.web.control.servlet.manager.report;

import com.epda.ejb.api.OrderEntityFacadeLocal;
import com.epda.web.control.extension.SessionController;
import com.epda.web.control.servlet.exception.PermissionDeniedException;
import com.epda.web.control.servlet.exception.SessionInvalidException;
import com.sdsms.ejb.var.AccountRole;
import com.sdsms.ejb.var.ServicePermission;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aaron@Mars
 */
public class GenerateSalesReportServlet extends SessionController {

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
        try {
            validatePermission(request, response);
            String location = request.getParameter("location");
            String from = request.getParameter("from");
            String to = request.getParameter("to");
            if (!location.isEmpty() && !from.isEmpty() && !to.isEmpty()) {
                request.setAttribute("location", location);
                request.setAttribute("from", from);
                request.setAttribute("to", to);
                request.setAttribute("orders", orderFacade.filter(location, from, to));
            } else if (!location.isEmpty()) {
                request.setAttribute("location", location);
                request.setAttribute("orders", orderFacade.filter(location));
            } else if (!from.isEmpty() && !to.isEmpty()) {
                request.setAttribute("from", from);
                request.setAttribute("to", to);
                request.setAttribute("orders", orderFacade.filter(from, to));
            } else {
                request.setAttribute("orders", orderFacade.findAll());
            }
            request.setAttribute("locations", orderFacade.getLocations().stream().distinct().collect(Collectors.toList()));
//            response.getWriter().print(orderFacade.getLocations().size());
            request.setAttribute("contextPath", request.getContextPath());
            request.setAttribute("revenue", orderFacade.getRevenueForListOfOrders(request.getAttribute("orders")));
            request.getRequestDispatcher("../manager/salesReport.jsp").forward(request, response);
        } catch (EJBException | ParseException e) {
            e.printStackTrace();
            response.sendError(503);
        } catch (SessionInvalidException e) {
            response.sendRedirect(request.getContextPath() + "/Login");
        } catch (PermissionDeniedException e) {
            response.sendError(403);
        }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
        return Arrays.asList(new ServicePermission[]{ServicePermission.UPDATE_ORDER});
    }
}
