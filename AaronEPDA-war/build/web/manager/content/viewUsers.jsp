<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-header">
    <h3 class="page-title"> View Staff Profiles </h3>
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Manager Dashboard</a></li>
            <li class="breadcrumb-item active" aria-current="page">View Staff Profiles</li>
        </ol>
    </nav>
</div>
<div class="row">
    <div class="col-lg-12 grid-margin stretch-card">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Staff Profiles Table</h4>
                <table class="table table-responsive" style="width: 100%;">
                    <thead>
                        <tr>
                            <th>Username</th>
                            <th>Full Name</th>
                            <th>Phone Number</th>
                            <th>Address</th>
                            <th>Account Role</th>
                            <th>Status</th>
                            <th>Last Login Date</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${profiles}" var="profile">
                            <tr>
                                <td>${profile.account.username}</td>
                                <td>${profile.fullName}</td>
                                <td>${profile.phoneNumber}</td>
                                <td>${profile.address}</td>
                                <td>${profile.account.accountRole.toString()}</td>
                                <td>${profile.account.accountStatus.toString()}</td>
                                <td>${profile.account.lastLoggedIn}</td>
                                <td>
                                    <div class="btn-group-sm" role="group">
                                        <button type="button" data-toggle="tooltip" data-placement="top" title="Deactivate" class="btn btn-primary" onclick="window.location.href = '${contextPath}/ManagerDashboard/ToggleActivity?id=${profile.account.id}&accountStatus=1'" ${profile.account.accountStatus.toString().equals("Active") ? "" : "hidden"}><i class="mdi mdi-account-remove"></i></button>
                                        <button type="button" data-toggle="tooltip" data-placement="top" title="Re-Activate" class="btn btn-primary" onclick="window.location.href = '${contextPath}/ManagerDashboard/ToggleActivity?id=${profile.account.id}&accountStatus=0'" ${profile.account.accountStatus.toString().equals("In-Active") ? "" : "hidden"}><i class="mdi mdi-account-check"></i></button>
                                        <button type="button" data-toggle="tooltip" data-placement="top" title="Edit Account" class="btn btn-primary" onclick="window.location.href = '${contextPath}/ManagerDashboard/EditUser?id=${profile.id}'"><i class="mdi mdi-account-edit"></i></button>
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