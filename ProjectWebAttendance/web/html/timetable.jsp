<%-- 
    Document   : timetable
    Created on : Jun 13, 2022, 8:07:35 PM
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
        <link rel="stylesheet" href="html/css/timetable.css">
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
        
        <c:if test="${requestScope.isAdmin eq true}">
            <div class="campus" style="text-align: center;">
                Campus:<select name="">
                    <option>FU-HL</option>
                </select><br>
            </div>
            <div class="lecture" style="text-align: center;">
                <form action="timetable" method="POST">
                    Lecture:<input type="text" name="teacherId" value="" />
                    <input type="submit" value="View" />
                    <input type="hidden" name="isAdmin" value="${requestScope.isAdmin}">
                </form>
            </div>
        </c:if>

        <div class="activity">

            <div class="activity-table">
                <table style="width:100%" border="1">
                    <thead style="background-color: #39ace7; color: white;">
                        <tr>
                            <th rowspan="2" style="text-align: start;">                               
                                   FROM <select name="from">
                                    <c:forEach items="${requestScope.date}" var="d">
                                        <option>${d.date}</option>
                                    </c:forEach>
                                </select><BR>
                                TO <select name="to">
                                    <c:forEach items="${requestScope.date}" var="d">
                                        <option>${d.date}</option>
                                    </c:forEach>
                            </th>
                            <th>MON</th>           
                            <th>TUE</th>
                            <th>WED</th>
                            <th>THU</th>
                            <th>FRI</th>
                            <th>SAT</th>
                            <th>SUN</th>
                        </tr>
                        <tr>
                            <c:forEach items="${requestScope.date}" var="d">
                                <td>${d.date}</td>
                            </c:forEach>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.slot}" var="s">                           
                            <tr>
                                <td>Slot ${s.slot}</td>
                                <c:forEach items="${requestScope.attenFTs}" var="a">
                                    <c:if test="${s.slot eq a.slot}">
                                        <c:if test="${a.subject eq null}">
                                            <td>-</td>
                                        </c:if>
                                        <c:if test="${a.subject ne null}">
                                            <td>${a.subject}<br>
                                                ${a.group}<br>
                                                <c:if test="${a.taken ne true}">
                                                    <a style="color: red;">(not yet)</a>
                                                </c:if>
                                                <c:if test="${a.taken eq true}">
                                                    <a style="color: green;">(attended)</a>
                                                </c:if>    
                                            </td>                                            
                                        </c:if>
                                    </c:if>
                                </c:forEach>
                            </tr>
                        </c:forEach>                                         
                    </tbody>
                </table>
            </div>
        </div>

        <div id="footer">
            <p>&copy; Power By</p>
            <!--Credits below must be kept under CC-NC 3.0 License-->
            <p><a href="https://fpt.edu.vn/"> TannmHE160735</a></p>
        </div>    
</html>
