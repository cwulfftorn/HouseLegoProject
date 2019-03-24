/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import function.Brick;
import function.GeneralException;
import function.LegoHouseCalculator;
import function.LogicFacade;
import function.Order;
import function.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author christianwulff
 */
public class HouseSize extends Command {
    
    String execute(HttpServletRequest request, HttpServletResponse response) throws GeneralException {
        int houseLength, houseWidth, houseHeight;

        houseLength = Integer.parseInt(request.getParameter("houselength"));
        houseWidth = Integer.parseInt(request.getParameter("housewidth"));
        houseHeight = Integer.parseInt(request.getParameter("househeight"));
        boolean windowDoor = Boolean.valueOf(request.getParameter("windowDoor"));

        Order houseOrder = new Order(10, houseLength, houseWidth, houseHeight, windowDoor, false);
        
        HttpSession session = request.getSession();
        session.setAttribute("length", houseLength);
        session.setAttribute("width", houseWidth);
        session.setAttribute("height", houseHeight);
        User u = (User) request.getSession().getAttribute("user");
        int userId = Integer.parseInt(u.getId());
        
        if (houseLength > 5 && houseWidth > 5 && houseHeight > 0) {
            Brick bricks = LegoHouseCalculator.calculateLegoHouse(houseLength, houseWidth, houseHeight, windowDoor);
            request.getSession().setAttribute("bricks", bricks);
            LogicFacade.createOrder(userId, houseOrder);
            return "orderpage";
        } 
        else if (windowDoor == true && houseLength > 7 && houseWidth > 7 && houseHeight > 4) {
            Brick x = LegoHouseCalculator.calculateLegoHouse(houseLength, houseWidth, houseHeight, windowDoor);
            request.getSession().setAttribute("bricks", x);
            LogicFacade.createOrder(userId, houseOrder);
            return "orderpage";
        } 
        else {
            throw new GeneralException("This house is too small to be made. Remember to use Integers");
        }
    }
}
