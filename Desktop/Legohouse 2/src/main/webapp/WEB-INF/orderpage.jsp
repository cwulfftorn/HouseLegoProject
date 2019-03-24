<%-- 
    Document   : orderpage
    Created on : 23-03-2019, 16:16:31
    Author     : christianwulff
--%>

<%@page import="function.User"%>
<%@page import="function.Brick"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Order:</h1>
    </body>

    <head>
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 50%;
            }
            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }
            tr:nth-child(even) {
                background-color: #dddddd;
            }
        </style>
    <br>
</head>
<body>

    <h3>Your Order:</h3>

    <table>
        <tr>
            <th>House Length</th>
            <th>Huse Width</th>
            <th>House Height</th>
            <th>Window and Door</th>
        </tr>
        <tr>
            <td>
                <%= session.getAttribute("length")%>
            </td>
            <td>
                <%= session.getAttribute("width")%>
            </td>
            <td>
                <%= session.getAttribute("height")%>
            </td>
            <td>
                <%
                    boolean windowDoor = (boolean) session.getAttribute("windowDoor");
                    out.print(windowDoor ? "yes" : "no");
                %>
            </td>
        </tr>
    </table>
    <br>

    <h3>Your Bricks:</h3>
    <%
        Brick bricks = (Brick) session.getAttribute("bricks");
    %>

    <table>
        <tr>
            <th>Type</th>
            <th>Amount</th>
        </tr>
        <tr>
            <td>4x2</td>
            <td>
                <%= bricks.getFour()%>
            </td>
        </tr>
        <tr>
            <td>2x2</td>
            <td>
                <%= bricks.getTwo()%>
            </td>
        </tr>
        <tr>
            <td>1x2</td>
            <td>
                <%= bricks.getOne()%>
            </td>
        </tr>
    </table>



    <form name="BackPage" action="FrontController" method="POST">
        <input type="hidden" name="command" value="BackPage">
        <br>
        <input type="submit" value="Go Back">
    </form>

    <br>

    <form name="LogOut" action="FrontController" method="POST">
        <input type="hidden" name="command" value="LogOut">
        <br>
        <input type="submit" value="Log Out">
    </form>

</body>
</html>

