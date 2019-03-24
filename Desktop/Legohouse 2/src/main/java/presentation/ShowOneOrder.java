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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author christianwulff
 */
public class ShowOneOrder extends Command {
    
    public ShowOneOrder() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws GeneralException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));

        Order singleOrder = LogicFacade.showSingleOrder(orderId);

        Brick brick = LegoHouseCalculator.calculateLegoHouse(singleOrder.getLength(), singleOrder.getWidth(), singleOrder.getHeight(), singleOrder.isWindowDoor());
        
        request.getSession().setAttribute("orderId", orderId);
        request.getSession().setAttribute("length", String.valueOf(singleOrder.getLength()));
        request.getSession().setAttribute("width", String.valueOf(singleOrder.getWidth()));
        request.getSession().setAttribute("height", String.valueOf(singleOrder.getHeight()));
        request.getSession().setAttribute("windowDoor", singleOrder.hasWindowDoor());
        request.getSession().setAttribute("blocks", brick);

        return "orderpage";
    }

}
