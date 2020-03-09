<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>HTML to API - Invoice</title>
        <link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,300,700&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
        <!-- <link rel="stylesheet" href="sass/main.css" media="screen" charset="utf-8"/> -->
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta http-equiv="content-type" content="text-html; charset=utf-8">
        <link rel="stylesheet" href="${contextPath}/assets/vendors/mdi/css/materialdesignicons.min.css">
        <link rel="stylesheet" href="${contextPath}/assets/vendors/css/vendor.bundle.base.css">
        <link rel="stylesheet" href="${contextPath}/assets/css/style.css">
        <style type="text/css">
            html, body, div, span, applet, object, iframe,
            h1, h2, h3, h4, h5, h6, p, blockquote, pre,
            a, abbr, acronym, address, big, cite, code,
            del, dfn, em, img, ins, kbd, q, s, samp,
            small, strike, strong, sub, sup, tt, var,
            b, u, i, center,
            dl, dt, dd, ol, ul, li,
            fieldset, form, label, legend,
            table, caption, tbody, tfoot, thead, tr, th, td,
            article, aside, canvas, details, embed,
            figure, figcaption, footer, header, hgroup,
            menu, nav, output, ruby, section, summary,
            time, mark, audio, video {
                margin: 0;
                padding: 0;
                border: 0;
                font: inherit;
                font-size: 100%;
                vertical-align: baseline;
            }

            html {
                line-height: 1;
            }

            ol, ul {
                list-style: none;
            }

            table {
                border-collapse: collapse;
                border-spacing: 0;
            }

            caption, th, td {
                text-align: left;
                font-weight: normal;
                vertical-align: middle;
            }

            q, blockquote {
                quotes: none;
            }
            q:before, q:after, blockquote:before, blockquote:after {
                content: "";
                content: none;
            }

            a img {
                border: none;
            }

            article, aside, details, figcaption, figure, footer, header, hgroup, main, menu, nav, section, summary {
                display: block;
            }

            body {
                font-family: 'Source Sans Pro', sans-serif;
                font-weight: 300;
                font-size: 12px;
                margin: 0;
                padding: 0;
            }
            body a {
                text-decoration: none;
                color: inherit;
            }
            body a:hover {
                color: inherit;
                opacity: 0.7;
            }
            body .container {
                min-width: 500px;
                margin: 0 auto;
                padding: 0 20px;
            }
            body .clearfix:after {
                content: "";
                display: table;
                clear: both;
            }
            body .left {
                float: left;
            }
            body .right {
                float: right;
            }
            body .helper {
                display: inline-block;
                height: 100%;
                vertical-align: middle;
            }
            body .no-break {
                page-break-inside: avoid;
            }

            header {
                margin-top: 20px;
                margin-bottom: 50px;
            }
            header figure {
                float: left;
                width: 60px;
                height: 60px;
                margin-right: 10px;
                background-color: #8BC34A;
                border-radius: 50%;
                text-align: center;
            }
            header figure img {
                margin-top: 13px;
            }
            header .company-address {
                float: left;
                max-width: 150px;
                line-height: 1.7em;
            }
            header .company-address .title {
                color: #8BC34A;
                font-weight: 400;
                font-size: 1.5em;
                text-transform: uppercase;
            }
            header .company-contact {
                float: right;
                height: 60px;
                padding: 0 10px;
                background-color: #8BC34A;
                color: white;
            }
            header .company-contact span {
                display: inline-block;
                vertical-align: middle;
            }
            header .company-contact .circle {
                width: 20px;
                height: 20px;
                background-color: white;
                border-radius: 50%;
                text-align: center;
            }
            header .company-contact .circle img {
                vertical-align: middle;
            }
            header .company-contact .phone {
                height: 100%;
                margin-right: 20px;
            }
            header .company-contact .email {
                height: 100%;
                min-width: 100px;
                text-align: right;
            }

            section .details {
                margin-bottom: 55px;
            }
            section .details .client {
                width: 50%;
                line-height: 20px;
            }
            section .details .client .name {
                color: #8BC34A;
            }
            section .details .data {
                width: 50%;
                text-align: right;
            }
            section .details .title {
                margin-bottom: 15px;
                color: #8BC34A;
                font-size: 3em;
                font-weight: 400;
                text-transform: uppercase;
            }
            section table {
                width: 100%;
                border-collapse: collapse;
                border-spacing: 0;
                font-size: 0.9166em;
            }
            section table .qty, section table .unit, section table .total {
                width: 15%;
            }
            section table .desc {
                width: 55%;
            }
            section table thead {
                display: table-header-group;
                vertical-align: middle;
                border-color: inherit;
            }
            section table thead th {
                padding: 5px 10px;
                background: #8BC34A;
                border-bottom: 5px solid #FFFFFF;
                border-right: 4px solid #FFFFFF;
                text-align: right;
                color: white;
                font-weight: 400;
                text-transform: uppercase;
            }
            section table thead th:last-child {
                border-right: none;
            }
            section table thead .desc {
                text-align: left;
            }
            section table thead .qty {
                text-align: center;
            }
            section table tbody td {
                padding: 10px;
                background: #E8F3DB;
                color: #777777;
                text-align: right;
                border-bottom: 5px solid #FFFFFF;
                border-right: 4px solid #E8F3DB;
            }
            section table tbody td:last-child {
                border-right: none;
            }
            section table tbody h3 {
                margin-bottom: 5px;
                color: #8BC34A;
                font-weight: 600;
            }
            section table tbody .desc {
                text-align: left;
            }
            section table tbody .qty {
                text-align: center;
            }
            section table.grand-total {
                margin-bottom: 45px;
            }
            section table.grand-total td {
                padding: 5px 10px;
                border: none;
                color: #777777;
                text-align: right;
            }
            section table.grand-total .desc {
                background-color: transparent;
            }
            section table.grand-total tr:last-child td {
                font-weight: 600;
                color: #8BC34A;
                font-size: 1.18181818181818em;
            }

            footer {
                margin-bottom: 20px;
            }
            footer .thanks {
                margin-bottom: 40px;
                color: #8BC34A;
                font-size: 1.16666666666667em;
                font-weight: 600;
            }
            footer .notice {
                margin-bottom: 25px;
            }
            footer .end {
                padding-top: 5px;
                border-top: 2px solid #8BC34A;
                text-align: center;
            }
            @media print {
                .hideButton {
                    display: none;
                }
            }
        </style>
    </head>

    <body>

        <section>
            <div class="container">
                <button class="hideButton" class="btn btn-gradient-primary" onclick="window.location.href = '/AaronEPDA/AssistantDashboard'">Back to Home</button>
                <button class="hideButton" class="btn btn-gradient-primary" onclick="window.print()">Print</button>
                <div class="details clearfix">
                    <div class="client left">
                        <p>INVOICE TO:</p>
                        <p class="name">${order.customer.name}</p>
                        <p>${order.customer.address}</p>
                        <a>${order.customer.phoneNumber}</a>
                    </div>
                    <div class="data right">
                        <div class="title">Order: ${order.id}</div>
                        <div class="date">
                            Date of Invoice: ${dateNow}<br>
                            Order Date: ${order.getSimpleOrderTimestamp()}
                        </div>
                    </div>
                </div>

                <table border="0" cellspacing="0" cellpadding="0">
                    <thead>
                        <tr>
                            <th class="desc">Items</th>
                            <th class="qty">Size</th>
                            <th class="unit">basic Cost</th>
                            <th class="total">Total Cost</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${order.products}" var="product">
                            <tr>
                                <td class="desc"><h3>${product.door.categoryName}</h3>${product.door.typeName}</td>
                                <td class="qty">${product.size.name}</td>
                                <td class="unit">${product.door.basicCost}</td>
                                <td class="total">${product.getCost()}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="no-break">
                    <table class="grand-total">
                        <tbody>
                            <tr>
                                <td class="desc"></td>
                                <td class="unit" colspan="2">GRAND TOTAL:</td>
                                <td class="total">${order.getTotalCost()}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </section>

    </body>

</html>
