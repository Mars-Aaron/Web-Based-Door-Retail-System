<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Purple Admin</title>
        <!-- plugins:css -->
        <link rel="stylesheet" href="/AaronEPDA/assets/vendors/mdi/css/materialdesignicons.min.css">
        <link rel="stylesheet" href="/AaronEPDA/assets/vendors/css/vendor.bundle.base.css">
        <!-- endinject -->
        <!-- Plugin css for this page -->
        <!-- End plugin css for this page -->
        <!-- inject:css -->
        <!-- endinject -->
        <!-- Layout styles -->
        <link rel="stylesheet" href="/AaronEPDA/assets/css/style.css">
        <!-- End layout styles -->
        <link rel="shortcut icon" href="/AaronEPDA/assets/images/favicon.png" />
    </head>
    <body>
        <div class="container-scroller">
            <div class="container-fluid page-body-wrapper full-page-wrapper">
                <div class="content-wrapper d-flex align-items-center auth">
                    <div class="row flex-grow">
                        <div class="col-lg-4 mx-auto">
                            <div class="auth-form-light text-left p-5">
                                <div class="brand-logo">
                                    <img src="/AaronEPDA/assets/images/logo.svg">
                                </div>
                                <h6 class="font-weight-light">Sign in to continue.</h6>
                                <form id="loginForm" action="${contextPath}/Login" method="post" class="pt-3">
                                    <div class="form-group">
                                        <input name="username" type="text" class="form-control form-control-lg" id="exampleInputEmail1" placeholder="Username">
                                    </div>
                                    <div class="form-group">
                                        <input name="password" type="password" class="form-control form-control-lg" id="exampleInputPassword1" placeholder="Password">
                                    </div>
                                    <div class="mt-3">
                                        <input type="submit" class="btn btn-block btn-gradient-primary btn-lg font-weight-medium auth-form-btn" value="SIGN IN">
                                    </div>
                                </form>
                            </div>
<!--                            <div>
                                <button onclick="$('#loginForm input[name=username]').val('admin');$('#loginForm input[name=password]').val('123');$('#loginForm').submit()">Manager</button>
                                <button onclick="$('#loginForm input[name=username]').val('assistant');$('#loginForm input[name=password]').val('123');$('#loginForm').submit()">Assistant</button>
                                <button onclick="$('#loginForm input[name=username]').val('installer');$('#loginForm input[name=password]').val('123');$('#loginForm').submit()">Installer</button>
                            </div>-->
                            <div class="card bg-danger text-white mt-3" ${loginFailed != null ? "" : "hidden"}>
                                <div class="card-body p-3">
                                    <h4 class="font-weight-normal"><i class="mdi mdi-alert-box mdi-24px"></i> Username or Password may be incorrect, or your account has been locked. </h4>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- content-wrapper ends -->
            </div>
            <!-- page-body-wrapper ends -->
        </div>
        <!-- container-scroller -->
        <!-- plugins:js -->
        <script src="/AaronEPDA/assets/vendors/js/vendor.bundle.base.js"></script>
        <!-- endinject -->
        <!-- Plugin js for this page -->
        <!-- End plugin js for this page -->
        <!-- inject:js -->
        <script src="/AaronEPDA/assets/js/off-canvas.js"></script>
        <script src="/AaronEPDA/assets/js/hoverable-collapse.js"></script>
        <script src="/AaronEPDA/assets/js/misc.js"></script>
        <!-- endinject -->
    </body>
</html>