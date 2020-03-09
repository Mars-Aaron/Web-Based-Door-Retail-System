<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-header">
    <h3 class="page-title"> View Customer Details </h3>
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Assistant Dashboard</a></li>
            <li class="breadcrumb-item active" aria-current="page">View Customer Details</li>
        </ol>
    </nav>
</div>
<div class="row">
    <div class="col-lg-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Customer Details Table</h4>
                <table class="table table-responsive" style="width: 100%;">
                    <thead>
                        <tr>
                            <th>Customer ID</th>
                            <th>Customer Name</th>
                            <th>Customer Address</th>
                            <th>Customer Phone Number</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${customers}" var="customer">
                            <tr>
                                <td>${customer.id}</td>
                                <td>${customer.name}</td>
                                <td>${customer.address}</td>
                                <td>${customer.phoneNumber}</td>
                                <td>
                                    <div class="btn-group-sm" role="group">
                                        <button type="button" data-toggle="tooltip" data-placement="top" title="Remove Customer Details" class="btn btn-primary" onclick="window.location.href = '${contextPath}/AssistantDashboard/DeleteCustomer?id=${customer.id}'" ${customer.orders.isEmpty() ? "" : "hidden"}><i class="mdi mdi-account-remove"></i></button>
                                        <button type="button" data-toggle="tooltip" data-placement="top" title="Edit Customer Details" class="btn btn-primary" onclick="window.location.href = '${contextPath}/AssistantDashboard/EditCustomer?id=${customer.id}'"><i class="mdi mdi-account-edit"></i></button>
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