<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Purple Admin</title>
        <!-- plugins:css -->
        <link rel="stylesheet" href="${contextPath}/assets/vendors/mdi/css/materialdesignicons.min.css">
        <link rel="stylesheet" href="${contextPath}/assets/vendors/css/vendor.bundle.base.css">
        <!-- endinject -->
        <!-- Plugin css for this page -->
        <!-- End plugin css for this page -->
        <!-- inject:css -->
        <!-- endinject -->
        <!-- Layout styles -->
        <link rel="stylesheet" href="${contextPath}/assets/css/style.css">
        <!-- End layout styles -->
        <link rel="shortcut icon" href="${contextPath}/assets/images/favicon.png" />
    </head>
    <body>
        <div class="container-scroller">
            <!-- partial:partials/_navbar.html -->
            <jsp:include page="layout/topbar.jsp"/>
            <!-- partial -->
            <jsp:include page="layout/mainPanel.jsp"/>
            <!-- page-body-wrapper ends -->
        </div>
        <!-- container-scroller -->
        <!-- plugins:js -->
        <script src="${contextPath}/assets/vendors/js/vendor.bundle.base.js"></script>
        <!-- endinject -->
        <!-- Plugin js for this page -->
        <script src="${contextPath}/assets/vendors/chart.js/Chart.min.js"></script>
        <!-- End plugin js for this page -->
        <!-- inject:js -->
        <script src="${contextPath}/assets/js/off-canvas.js"></script>
        <script src="${contextPath}/assets/js/hoverable-collapse.js"></script>
        <script src="${contextPath}/assets/js/misc.js"></script>
        <!-- endinject -->
        <!-- Custom js for this page -->
        <script src="${contextPath}/assets/js/dashboard.js"></script>
        <script src="${contextPath}/assets/js/todolist.js"></script>
        <!-- End custom js for this page -->
        <script>
            function test(doorId, categoryName, typeName, cost, sizeId, sizeName) {
                $('#orderItemsContainer').append(`<div class="card bg-inverse-primary mb-1 mr-1 text-left" style="width: 48%; display: inline-block">
                                <div class="card-body">
                                    <input name='doorId' value=` + doorId + ` hidden='hidden'>
                                    <input name='sizeId' value=` + sizeId + ` hidden='hidden'>
                                    <h6><strong>` + categoryName + `</strong></h6>
                                    <p>` + typeName + ` (` + sizeName + `)</p>
                                    <div style="width: 100%">
                                        <h4 class="text-right" style="position: absolute; right: 20px; bottom: 15px"><strong>RM` + cost + `</strong></h4>
                                    </div>
                                </div>
                            </div>`);
            }
            $(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();
            });
        </script>
    </body>
</html>