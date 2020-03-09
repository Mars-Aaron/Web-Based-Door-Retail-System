<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-header">
    <h3 class="page-title"> Edit Customer </h3>
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Assistant Dashboard</a></li>
            <li class="breadcrumb-item active" aria-current="page">Edit Customer</li>
        </ol>
    </nav>
</div>
<div class="row">
    <div class="col-lg-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Edit Customer</h4>
                <p class="card-description"> Change any customer details and click on Update Customer... </p>
                <form class="forms-sample" action="${contextPath}/AssistantDashboard/EditCustomer?id=${customer.id}" method="post">
                    <div class="form-group">
                        <label for="nameField">Customer Name</label>
                        <input name="name" value="${customer.name}" type="text" class="form-control" id="nameField" placeholder="Customer Name" required="required">
                    </div>
                    <div class="form-group">
                        <label for="addressField">Customer Address</label>
                        <input name="address" value="${customer.address}" type="text" class="form-control" id="addressField" placeholder="Customer Address" required="required">
                    </div>
                    <div class="form-group">
                        <label for="phoneField">Customer Phone Number</label>
                        <input name="phone" value="${customer.phoneNumber}" type="tel" class="form-control" id="phoneField" placeholder="Customer Phone Number" required="required">
                    </div>
                    <button type="submit" class="btn btn-gradient-primary mr-2">Update Customer</button>
                </form>
            </div>
        </div>
    </div>
</div>
