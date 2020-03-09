<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-header">
    <h3 class="page-title"> Create Customer </h3>
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Assistant Dashboard</a></li>
            <li class="breadcrumb-item active" aria-current="page">Create Customer</li>
        </ol>
    </nav>
</div>
<div class="row">
    <div class="col-lg-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Create Customer</h4>
                <p class="card-description"> Fill in the Customer Details form... </p>
                <form class="forms-sample" action="${contextPath}/AssistantDashboard/CreateCustomer" method="post">
                    <div class="form-group">
                        <label for="nameField">Customer Name</label>
                        <input name="name" type="text" class="form-control" id="nameField" placeholder="Customer Name" required="required">
                    </div>
                    <div class="form-group">
                        <label for="addressField">Customer Address</label>
                        <input name="address" type="text" class="form-control" id="addressField" placeholder="Customer Address" required="required">
                    </div>
                    <div class="form-group">
                        <label for="phoneField">Customer Phone Number</label>
                        <input name="phone" type="tel" class="form-control" id="phoneField" placeholder="Customer Phone Number" required="required">
                    </div>
                    <button type="submit" class="btn btn-gradient-primary mr-2">Create Customer</button>
                </form>
            </div>
        </div>
    </div>
</div>
