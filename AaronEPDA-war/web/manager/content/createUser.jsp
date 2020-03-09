<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-header">
    <h3 class="page-title"> Create Staff Account </h3>
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Manager Dashboard</a></li>
            <li class="breadcrumb-item active" aria-current="page">Create Staff Account</li>
        </ol>
    </nav>
</div>
<div class="row">
    <div class="col-lg-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Create Staff</h4>
                <p class="card-description"> Fill in the staff form... </p>
                <form class="forms-sample" action="${contextPath}/ManagerDashboard/CreateUser" method="post">
                    <div class="form-group">
                        <label for="accountRoleField">Account Role</label>
                        <select name="accountRole" class="form-control form-control-sm" id="accountRoleField" required="required">
                            <option value="" disabled="disabled" selected="selected">Select an Account Role</option>
                            <c:forEach items="${accountRoles}" var="accountRole">
                                <option value="${accountRole.ordinal()}">${accountRole.toString()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="usernameField">Username</label>
                        <input name="username" type="text" class="form-control" id="usernameField" placeholder="Username" required="required">
                    </div>
                    <div class="form-group">
                        <label>Password</label>
                        <div class="input-group col-xs-12">
                            <input name="password" type="password" class="form-control" id="passwordField" placeholder="Password" required="required">
                            <span class="input-group-append">
                                <button class="btn btn-gradient-primary" onclick="$('#passwordField').attr('type', $('#passwordField').attr('type') === 'password' ? 'text' : 'password')" type="button">Toggle</button>
                            </span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="fullNameField">Full Name</label>
                        <input name="fullName" type="text" class="form-control" id="fullNameField" placeholder="Full Name" required="required">
                    </div>
                    <div class="form-group">
                        <label for="dateOfBirthField">Date of Birth</label>
                        <input name="dateOfBirth" type="date" class="form-control" id="dateOfBirthField" placeholder="Date of Birth" required="required">
                    </div>
                    <div class="form-group">
                        <label for="phoneNumberField">Phone Number</label>
                        <input name="phoneNumber" type="tel" class="form-control" id="phoneNumberField" placeholder="Phone Number">
                    </div>
                    <div class="form-group">
                        <label for="addressField">Address</label>
                        <textarea name="address" class="form-control" id="addressField" placeholder="Address" required="required"></textarea>
                    </div>
                    <button type="submit" class="btn btn-gradient-primary mr-2">Create Staff</button>
                </form>
            </div>
        </div>
    </div>
</div>
