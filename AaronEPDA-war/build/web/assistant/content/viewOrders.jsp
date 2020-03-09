<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-header">
    <h3 class="page-title"> View Purchase Orders </h3>
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Assistant Dashboard</a></li>
            <li class="breadcrumb-item active" aria-current="page">View Purchase Orders</li>
        </ol>
    </nav>
</div>
<div class="row">
    <div class="col-lg-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Purchase Orders Table</h4>
                <form id="assignInstallerForm" action="${contextPath}/AssistantDashboard/AssignInstaller" method="post">

                </form>
                <table class="table table-responsive" style="width: 100%;">
                    <thead>
                        <tr>
                            <th>Order ID</th>
                            <th>Customer Name</th>
                            <th>Order Date</th>
                            <th>Installation Date</th>
                            <th>Installer</th>
                            <th>Status</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${orders}" var="order">
                            <tr>
                                <td>${order.id}</td>
                                <td>${order.customer.name}</td>
                                <td>${order.getFormattedOrderTimestamp()}</td>
                                <td>
                                    ${order.installer == null ? "" : order.getFormattedInstallationDate()}
                                </td>
                                <td>
                                    ${order.installer == null ? "" : order.installer.fullName}
                                </td>
                                <td>${order.status.toString()}</td>
                                <td>
                                    <div class="btn-group-sm" role="group">
                                        <button type="button" data-toggle="tooltip" data-placement="top" title="Generate Receipt" class="btn btn-primary" onclick="window.location.href = '${contextPath}/AssistantDashboard/GenerateReceipt?id=${order.id}'" ${order.status.ordinal() == 0  ? "" : "disabled"}><i class="mdi mdi-receipt"></i></button>
                                        <button type="button" data-toggle="tooltip" data-placement="top" title="Assign Installer" class="btn btn-primary" onclick="window.location.href = '${contextPath}/AssistantDashboard/AssignInstaller?id=${order.id}'" ${order.installer == null ? "" : "disabled"}><i class="mdi mdi-calendar-range"></i></button>
                                        <button type="button" data-toggle="tooltip" data-placement="top" title="Unassign Installer" class="btn btn-primary" onclick="window.location.href = '${contextPath}/AssistantDashboard/UnassignInstaller?id=${order.id}'" ${order.installer != null && order.status.ordinal() == 0 ? "" : "disabled"}><i class="mdi mdi-calendar-remove"></i></button>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>