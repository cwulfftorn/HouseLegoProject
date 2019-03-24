<%-- 
    Document   : index
    Created on : 21-03-2019, 16:58:47
    Author     : christianwulff
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome page</title>
    </head>
    <body>
        <h1>Welcome to Lego House</h1>
        
        <table>
            <tr>
                <td>
                    <h3>Login<h3>
                    <form name="login" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="login">
                        Email:<br>
                        <input type="text" name="email">
                        <br>
                        Password:<br>
                        <input type="password" name="password">
                        <br>
                        <input type="submit" value="Login">
                    </form>
                </td>
                <td>
                    <h3>Register<h3>
                    <form name="register" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="register">
                        Email:<br>
                        <input type="text" name="email">
                        <br>
                        Password:<br>
                        <input type="password" name="password1">
                        <br>
                        Retype Password:<br>
                        <input type="password" name="password2">
                        <br>
                        <input type="submit" value="Create account">
                    </form>
                </td>
            </tr>
        </table>
        <% String error = (String) request.getAttribute( "error");
           if ( error != null) { 
               out.println("<H2>Error!!</h2>");
               out.println(error);
           }
        %>
    </body>
</html>
