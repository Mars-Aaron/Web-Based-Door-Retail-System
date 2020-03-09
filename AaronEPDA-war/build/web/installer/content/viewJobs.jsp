<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-header">
    <h3 class="page-title"> View Installation Jobs </h3>
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Installer Dashboard</a></li>
            <li class="breadcrumb-item active" aria-current="page">View Installation Jobs</li>
        </ol>
    </nav>
</div>
<div class="row">
    <div class="col-lg-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Installation Jobs Table</h4>
                <form id="assignInstallerForm" action="${contextPath}/AssistantDashboard/AssignInstaller" method="post">

                </form>
                <table class="table " style="width: 100%;">
                    <thead>
                        <tr>
                            <th>Customer Name</th>
                            <th>Order Date</th>
                            <th>Installation Date</th>
                            <th>Installer</th>
                            <th>Status</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${jobs}" var="job">
                            <tr>
                                <td>${job.customer.name}</td>
                                <td>${job.getFormattedOrderTimestamp()}</td>
                                <td>
                                    ${job.getFormattedInstallationDate()}
                                </td>
                                <td>
                                    ${job.installer.fullName}
                                </td>
                                <td>${job.status.toString()}</td>
                                <td>
                                    <div class="btn-group-sm" role="group">
                                        <button type="button" data-toggle="tooltip" data-placement="top" title="Complete Order" class="btn btn-primary" onclick="window.location.href = '${contextPath}/InstallerDashboard/CompleteOrder?id=${job.id}'" ${job.status.ordinal() != 0 ? "disabled" : ""}><i class="mdi mdi-check-circle"></i></button>
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