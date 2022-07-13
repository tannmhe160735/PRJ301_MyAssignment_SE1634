<%-- 
    Document   : home
    Created on : Jun 6, 2022, 7:55:00 PM
    Author     : minht
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Created by Tannmhe160735</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="Description" lang="en" content="open source html and css template">
        <meta name="author" content="mlp design">
        <meta name="robots" content="index, follow">
        <link rel="stylesheet" href="html/css/home.css">
    </head>
    <body>
        <!-- Menu Items -->
        <nav>
            <input type="checkbox" id="show-menu" role="button">
            <label for="show-menu" class="open"><span class="fa fa-bars"></span></label>
            <label for="show-menu" class="close"><span class="fa fa-times"></label>
            <ul id="menu">
                <li><a class="active" href="home">Home</a></li>
                <li><a href="#">${sessionScope.account.displayName}</a></li>
                <li><a href="login">Sign out</a></li>
<!--                <li><a href="#">Archive</a></li>
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
        
    </body>
        <div class="Order">
            <div class="Order-title">
                <h3 style="color: #56baed;">Reports</h3>
            </div>
            <div class="Order-list">               
                    <a href="timetable?name=${sessionScope.account.username}">Weekly timetable</a><br>
                    <c:if test="${sessionScope.account.isAdmin eq false}">
                        <a href="attendanceview?sid=${sessionScope.account.username}">Attendance report</a>
                    </c:if>
                    <c:if test="${sessionScope.account.isAdmin eq true}">
                        <a href="takea?tid=${sessionScope.account.username}">Take Attendance</a><br>                        
                    </c:if>
                    
            </div>                
        </div>
    
    <div id="footer">
            <p>&copy; Power By</p>
            <!--Credits below must be kept under CC-NC 3.0 License-->
            <p><a href="https://fpt.edu.vn/"> TannmHE160735</a></p>
    </div> 
</html>
