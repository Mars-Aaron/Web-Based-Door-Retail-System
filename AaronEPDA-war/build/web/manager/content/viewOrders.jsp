<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-header">
    <h3 class="page-title"> View Purchase Orders </h3>
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Manager Dashboard</a></li>
            <li class="breadcrumb-item active" aria-current="page">View Purchase Orders</li>
        </ol>
    </nav>
</div>
<div class="row">
    <div class="col-lg-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Purchase Orders Table</h4>
                <table class="table" style="width: 100%;">
                    <thead>
                        <tr>
                            <th>Order ID</th>
                            <th>Customer Name</th>
                            <th>Order Date</th>
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
                                <td>${order.status.toString()}</td>
                                <td>
                                    <div class="btn-group-sm" role="group">
                                        <button type="button" data-toggle="tooltip" data-placement="top" title="Cancel Order" class="btn btn-primary" onclick="window.location.href = '${contextPath}/ManagerDashboard/CancelOrder?id=${order.id}'" ${order.status.ordinal() == 0  ? "" : "disabled"}><i class="mdi mdi-close-circle"></i></button>
                                        <button type="button" data-toggle="tooltip" data-placement="top" title="Restore Order" class="btn btn-primary" onclick="window.location.href = '${contextPath}/ManagerDashboard/RestoreOrder?id=${order.id}'" ${order.status.ordinal() == 2  ? "" : "disabled"}><i class="mdi mdi-restore"></i></button>
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