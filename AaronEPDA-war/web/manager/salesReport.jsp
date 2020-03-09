<%-- 
    Document   : salesReport
    Created on : Sep 29, 2019, 11:59:07 AM
    Author     : Aaron@Mars
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Sales Report</title>
        <!-- plugins:css -->
        <link rel="stylesheet" href="${contextPath}/assets/vendors/mdi/css/materialdesignicons.min.css">
        <link rel="stylesheet" href="${contextPath}/assets/vendors/css/vendor.bundle.base.css">
        <!-- endinject -->
        <!-- Plugin css for this page -->
        <!-- End plugin css for this page -->
        <!-- inject:css -->
        <!-- endinject -->
        <!-- Layout styles -->
        <link rel="stylesheet" href="${contextPath}/assets/css/style.css">
        <!-- End layout styles -->
        <link rel="shortcut icon" href="${contextPath}/assets/images/favicon.png" />
        <style>
            @media print {
                .printHide * {
                    display: none;
                }
            }
        </style>
    </head>
    <body>
        <div class="container-fluid page-body-wrapper">
            <div class="content-wrapper">
                <div class="page-header">
                    <h1 class=""> Sales Report </h1>
                    <div class="form-group">
                        <h5 class="" ${from == null && to== null ? "hidden" : ""}> ${from} - ${to} </h5>
                        <h5 class=""> For Location: ${location == null ? "All Location" : location} </h5>
                    </div>
                </div>
                <div class="card mb-3 printHide">
                    <div class="card-header">
                        <h3 style="display: inline-block">Report Settings</h3>
                        <div class="" style="display: inline-block; float: right">
                            <input class="btn btn-primary" type="button" onclick="window.print()" value="Print">
                            <input class="btn btn-primary" type="button" onclick="window.location.href = '${contextPath}/ManagerDashboard'" value="Back">
                        </div>
                    </div>
                    <div class="card-body">
                        <form action="${contextPath}/ManagerDashboard/GenerateSalesReport">
                            <div class="form-group">
                                <label for="locationField">Location</label>
                                <select name="location" class="form-control" id="locationField">
                                    <option value="" selected="selected">No Location Filter</option>
                                    <c:forEach items="${locations}" var="location">
                                        <option>${location}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="fromDateField">From Date</label>
                                <input name="from" type="date" value="${from}" class="form-control" id="fromDateField">
                            </div>
                            <div class="form-group">
                                <label for="toDateField">To Date</label>
                                <input name="to" type="date" value="${to}" class="form-control" id="toDateField">
                            </div>
                            <input type="submit" class="btn btn-primary">
                        </form>
                    </div>
                </div>
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Purchase Orders Table</h4>
                        <table class="" style="width: 100%">
                            <tr>
                                <th>Order ID</th>
                                <th>Order Date</th>
                                <th>Customer ID</th>
                                <th>Customer Name</th>
                                <th>Order Item</th>
                                <th>Order Size</th>
                                <th>Unit Cost</th>
                                <th>Total Cost</th>
                            </tr>
                            <c:forEach items="${orders}" var="order">
                                <tr>
                                    <td rowspan="${order.products.size()}">${order.products.size()} ${order.id}</td>
                                    <td rowspan="${order.products.size()}">${order.orderTimestamp}</td>
                                    <td rowspan="${order.products.size()}">${order.customer.id}</td>
                                    <td rowspan="${order.products.size()}">${order.customer.name}</td>
                                    <td>${order.products.get(0).door.categoryName}: ${order.products.get(0).door.typeName}</td>
                                    <td>${order.products.get(0).size.name}</td>
                                    <td>${order.products.get(0).door.basicCost * order.products.get(0).size.costMultiplier}</td>
                                    <td rowspan="${order.products.size()}">${order.getTotalCost()}</td>
                                </tr>
                                <c:forEach items="${order.products.subList(1,order.products.size())}" var="product">
                                    <td>${product.door.categoryName}: ${product.door.typeName}</td>
                                    <td>${product.size.name}</td>
                                    <td>${product.door.basicCost * product.size.costMultiplier}</td>
                                </c:forEach>
                            </c:forEach>
                            <tr>
                                <td colspan="6"></td>
                                <td><strong>Renevue (RM)</strong></td>
                                <td><strong>${revenue}</strong></td>
                            </tr>
                        </table>
                    </div>
                </div>
                <!-- content-wrapper ends -->
            </div>
            <!-- main-panel ends -->
        </div>
    </body>
    <script src="${contextPath}/assets/vendors/js/vendor.bundle.base.js"></script>
</html>
