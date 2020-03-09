<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-header">
    <h3 class="page-title"> Create Purchase Order </h3>
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Manager Dashboard</a></li>
            <li class="breadcrumb-item active" aria-current="page">Create Purchase Order</li>
        </ol>
    </nav>
</div>
<div class="row">
    <div class="col-lg-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Create Purchase Order</h4>
                <p class="card-description"> Fill in the Order form... </p>
                <form class="forms-sample" action="${contextPath}/ManagerDashboard/CreateOrder" method="post">
                    <div class="form-group">
                        <label for="customerField">Customer</label>
                        <select name="customerId" class="form-control form-control-sm" id="customerField" required="required">
                            <option value="" disabled="disabled" selected="selected">Select an Customer</option>
                            <c:forEach items="${customers}" var="customer">
                                <option value="${customer.id}">${customer.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="container p-5 mb-3 bg-gradient-primary text-center" style="border-radius: 8px; width: 100%">
                        <div class="card mb-1 p-2 bg-gradient-white" style="width: 98%; display: inline-block;">
                            <h2>Door Catalogue</h2>
                        </div>
                        <c:forEach items="${doors}" var="door">
                            <div class="card bg-inverse-primary mb-1 text-left" style="width: 49%; min-height: 200px; display: inline-block">
                                <div class="card-body">
                                    <h6><strong>${door.categoryName}</strong></h6>
                                    <p>${door.typeName}</p>
                                    <div style="width: 100%">
                                        <div class="btn-group" style="position: absolute; left: 20px;bottom: 15px">
                                            <button type="button" class="btn btn-outline-secondary dropdown-toggle" data-toggle="dropdown" aria-expanded="false">Add to Order</button>
                                            <div class="dropdown-menu" x-placement="bottom-start" style="position: absolute; will-change: transform; top: 0px; left: 0px; transform: translate3d(0px, 44px, 0px);">
                                                <c:forEach items="${sizes}" var="size">
                                                    <a class="dropdown-item" onclick="test('${door.id}', '${door.categoryName}', '${door.typeName}', '${door.basicCost * size.costMultiplier}', '${size.id}', '${size.name}')">${size.name}</a>
                                                </c:forEach>
                                            </div>
                                        </div>
                                        <h4 class="text-right" style="position: absolute; right: 20px; bottom: 15px"><strong>RM${door.basicCost}</strong></h4>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <div id="orderItemsContainer" class="container p-5 mt-3 mb-3 bg-gradient-primary text-center" style="border-radius: 8px">
                        <div class="card mb-1 p-2 bg-gradient-white" style="width: 98%; display: inline-block;">
                            <h2>Order Items</h2>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-gradient-primary mr-2">Create Order</button>
                </form>
            </div>
        </div>
    </div>
</div>
