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
public class ShowCustomerOrders extends Command {
    
    public ShowCustomerOrders() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws GeneralException {
        User u = (User) request.getSession().getAttribute("user");
        String userId = u.getId();
        ArrayList<Order> orders = LogicFacade.showCustomerOrders(userId);
        
        HttpSession session = request.getSession();
        session.setAttribute("orderList", orders);
        
                
    return "showorders";
    }
}
