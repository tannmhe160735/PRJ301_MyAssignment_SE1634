<%-- 
    Document   : liststudent
    Created on : Jun 20, 2022, 8:30:43 PM
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
        <link href="html/css/liststudent.css" rel="stylesheet" type="text/css"/>
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
    <h2 class="take-attendance-title" style="text-align: center;">View student in class of ${sessionScope.account.name}</h2>
    <div class="list-table">
        <form action="liststu" method="POST">

            <table class="table" border="1">
                    <thead style="background-color: #39ace7; ">
                        <th>ID</th>
                        <th>Image</th>
                        <th>Name</th>
                        <th>Attendance</th>
                    </thead>
                    <c:forEach items="${requestScope.stus}" var="s">
                        <tr class="a-class">
                            <td>${s.sid}<input type="hidden" name="sid" value="${s.sid}"></td>
                            <td><img src="${s.simage}" style="width: 120px; height: 150px"/></td>
                            <td>${s.sname}</td>
                            <td><input type="checkbox" name="attendence" value="false" /> <a style="color: red">absent</a>
                                <input type="checkbox" name="attendence" value="true" /> <a style="color: green">attend</a></td>
                        </tr> 
                    </c:forEach>               
            </table><br>
            <div class="button">
                <input type="submit" value="Submit" style="padding-left: 20px; padding-right: 20px;" />
            </div>
        </form>
    </div>

    <div id="footer">
        <p>&copy; Power By</p>
        <!--Credits below must be kept under CC-NC 3.0 License-->
        <p><a href="https://fpt.edu.vn/"> TannmHE160735</a></p>
    </div> 
</html>
