<%-- 
    Document   : timetable
    Created on : Jun 13, 2022, 8:07:35 PM
    Author     : minht
--%>

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
        <div class="campus" style="text-align: center;">
            Campus:<select name="">
                <option>FU-HL</option>
            </select><br>
        </div>
        <div class="lecture" style="text-align: center;">
            <form action="viewclass" method="POST">
                Lecture:<input type="text" name="teacher" value="" />
                <input type="submit" value="View" />
            </form>
        </div>
        <div class="activity">
            
            <div class="activity-table">
                <table style="width:100%" border="1">
                    <thead style="background-color: #39ace7; color: white;">
                    <tr>
                        <th rowspan="2" style="text-align: start;">
                            YEAR<select name="year">
                                <option>2022</option>
                                <option>2021</option>
                            </select><br>
                            WEEK<select name="WEEK">
                                <option>03/07 To 09/07</option>
                                <option>10/07 To 16/07</option>
                            </select>
                        </th>
                        <td>MON</td>           
                        <th>TUE</th>
                        <th>WED</th>
                        <th>THU</th>
                        <th>FRI</th>
                        <th>SAT</th>
                        <th>SUN</th>
                    </tr>
                    <tr>
                        <td>03/07</td>
                        <td>03/07</td>
                        <td>03/07</td>
                        <td>03/07</td>
                        <td>03/07</td>
                        <td>03/07</td>
                        <td>03/07</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Slot 1</td>
                        <td>-</td>
                        <td>-</td>
                        <td>-</td>
                        <td>-</td>
                        <td>-</td>
                        <td>-</td>
                        <td>-</td>
                    </tr>
                    <tr>
                        <td>Slot 2</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Slot 3</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Slot 4</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Slot 5</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Slot 6</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Slot 7</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Slot 8</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>               
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
