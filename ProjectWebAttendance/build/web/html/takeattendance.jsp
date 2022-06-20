<%-- 
    Document   : takeattendance
    Created on : Jun 20, 2022, 4:57:53 PM
    Author     : minht
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <html lang="en">
        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <title>Created by Tannmhe160735</title>
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <meta name="Description" lang="en" content="open source html and css template">
            <meta name="author" content="mlp design">
            <meta name="robots" content="index, follow">
            <link href="html/css/takeattendance.css" rel="stylesheet" type="text/css"/>

        </head>
        <body>
            <!-- Menu Items -->
            <nav>
                <input type="checkbox" id="show-menu" role="button">
                <label for="show-menu" class="open"><span class="fa fa-bars"></span></label>
                <label for="show-menu" class="close"><span class="fa fa-times"></label>
                <ul id="menu">
                    <li><a class="active" href="home">Home</a></li>
                    <li><a href="#">${sessionScope.account.name}</a></li>
                    <li><a href="login">Sign out</a></li>
                    <!--            <li><a href="#">Archive</a></li>
                                    <li><a href="#">Empty</a></li>
                                    <li><a href="#">Also Empty</a></li>-->
                </ul>
            </nav>
            <!-- // -->
            <!-- Banner -->
            <div id="banner">
                <div id="header">
                    <h1>FPT University Academic Portal</h1>
                </div>
            </div>
            <h2 class="take-attendance-title" style="text-align: center;">View class for ${sessionScope.account.name}</h2>
            <div class="activity">
                <div class="activity-table">
                    <table border="1" style="width: 100%;">
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>Class</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.classes}" var="c"  >
                            <tr>
                                <td>${c.cid}</td>
                                <td><a href="liststu?cid=${c.cid}">${c.cname}</a></td>
                                <td style="color: red;">Not yet</td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                </div>
            </div>
        </body>
        <div id="footer">
            <p>&copy; Power By</p>
            <!--Credits below must be kept under CC-NC 3.0 License-->
            <p><a href="https://fpt.edu.vn/"> TannmHE160735</a></p>
        </div
    </html>
