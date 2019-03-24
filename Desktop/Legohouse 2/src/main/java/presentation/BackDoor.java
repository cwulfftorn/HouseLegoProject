/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import function.GeneralException;
import function.LogicFacade;
import function.Order;
import function.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author christianwulff
 */
public class BackDoor extends Command {
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws GeneralException {
        String email = "jeger@admin.com";
        String password = "123";
        User user = LogicFacade.login(email, password);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setAttribute("role", user.getRole());
        
        ArrayList<Order> orders = LogicFacade.showAllOrders();

        session.setAttribute("allOrderList", orders);
        return user.getRole() + "page";
    }
    
    /*      indsæt dette
                    <td>
                    <form name="backdoorCustomer" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="backdoorCustomer">
                        <input type="submit" value="Customer Back Door">
                    </form>
                </td>
                <td>
                    <form name="backdoor" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="backdoor">
                        <input type="submit" value="Back Door">
                    </form>
                </td>
    
    */
    
}
