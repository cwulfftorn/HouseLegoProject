<%-- 
    Document   : customerpage
    Created on : 21-03-2019, 16:49:45
    Author     : christianwulff
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer page</title>
    </head>
    <body>
        <h1>Hello <%=request.getParameter( "email" )%> </h1>
        Welcome to Lego House. In here you can set the length width and height for your Lego House. 
        And if you want to add a windoow and a door.
    </body>
    <table>
         <tr>
            <td>
                <form name="HouseSize" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="HouseSize">
                    house length:<br>
                    <input type="text" name="houselength" value="">
                    <br>
                    house width:<br>
                    <input type="text" name="housewidth" value="">
                    <br>
                    house height (layer count):<br>
                    <input type="text" name="househeight" value="">
                    <br>
                    Your house needs a door and at least one window right?
                    <br>
                    
                    <select name="windowDoor">
                        <option value="true">Yes</option>
                        <option value="false">No</option> 
                    </select>
                    <br>
                    <input type="submit" value="Submit Order">
                </form>
                <br>
                <form name="ShowOrders" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="ShowOrders">
                    <input type="submit" value="Show Previous Orders">
                </form>
                <br>
                <form name="LogOut" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="LogOut">
                    <br>
                    <input type="submit" value="Log Out">
                </form>
            </td>


        </tr>
            
    </table>
    
    <% String error = (String) request.getAttribute("error");
        if (error != null) {
            out.println("<H2>Error!!</h2>");
            out.println(error);
        }
    %>
    
</html>
