<nav class="sidebar sidebar-offcanvas" id="sidebar">
    <ul class="nav">
        <li class="nav-item">
            <a class="nav-link" href="${contextPath}/ManagerDashboard">
                <span class="menu-title">Dashboard</span>
                <i class="mdi mdi-home menu-icon"></i>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
                <span class="menu-title">Staff Accounts</span>
                <i class="menu-arrow"></i>
                <i class="mdi mdi-account-circle menu-icon"></i>
            </a>
            <div class="collapse" id="ui-basic">
                <ul class="nav flex-column sub-menu">
                    <li class="nav-item"> <a class="nav-link" href="${contextPath}/ManagerDashboard/CreateUser">Create Staff Profile</a></li>
                    <li class="nav-item"> <a class="nav-link" href="${contextPath}/ManagerDashboard/ReadUsers">View Staff Profiles</a></li>
                </ul>
            </div>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#general-pages" aria-expanded="false" aria-controls="general-pages">
                <span class="menu-title">Purchase Orders</span>
                <i class="menu-arrow"></i>
                <i class="mdi mdi-cart menu-icon"></i>
            </a>
            <div class="collapse" id="general-pages">
                <ul class="nav flex-column sub-menu">
                    <li class="nav-item"> <a class="nav-link" href="${contextPath}/ManagerDashboard/CreateOrder">Create Purchase Order</a></li>
                    <li class="nav-item"> <a class="nav-link" href="${contextPath}/ManagerDashboard/ReadOrders">View Purchase Orders</a></li>
                </ul>
            </div>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${contextPath}/ManagerDashboard/GenerateSalesReport?location=&from=&to=">
                <span class="menu-title">Generate Sales Report</span>
                <i class="mdi mdi-clipboard-outline menu-icon"></i>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${contextPath}/ManagerDashboard/EditProfile">
                <span class="menu-title">Edit Profile</span>
                <i class="mdi mdi-account-card-details menu-icon"></i>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${contextPath}/Logout">
                <span class="menu-title">Logout</span>
                <i class="mdi mdi-logout menu-icon"></i>
            </a>
        </li>
    </ul>
</nav>