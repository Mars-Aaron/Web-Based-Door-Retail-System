<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-header">
    <h3 class="page-title"> Assign Installer </h3>
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Assistant Dashboard</a></li>
            <li class="breadcrumb-item active" aria-current="page">Assign Installer</li>
        </ol>
    </nav>
</div>
<div class="row">
    <div class="col-lg-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Assign Installer</h4>
                <p class="card-description"> Fill in the Installation Finalization form... </p>
                <form class="forms-sample" action="${contextPath}/AssistantDashboard/AssignInstaller" method="post">
                    <input name="orderId" value="${order.id}" required="required" hidden="hidden">
                    <div class="form-group">
                        <label for="installerIdField">Installer</label>
                        <select name="installerId" type="text" class="form-control" id="installerIdField" placeholder="Installer" required="required">
                            <option value="" disabled selected>Select an Installer</option>
                            <c:forEach items="${installers}" var="installer">
                                <option value="${installer.id}">${installer.fullName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="installationDateField">Installation Date</label>
                        <input name="installationDate" type="date" class="form-control" id="installationDateField" placeholder="Installation Date" required="required">
                    </div>
                    <button type="submit" class="btn btn-gradient-primary mr-2">Assign Installer</button>
                </form>
            </div>
        </div>
    </div>
</div>
