/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import function.GeneralException;
import function.LogicFacade;
import function.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author christianwulff
 */

public class BackDoorCustomer extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws GeneralException {
        String email = "Customer@lego.com";
        String password = "lego";
        User user = LogicFacade.login( email, password );
        HttpSession session = request.getSession();
        session.setAttribute( "user", user );
        session.setAttribute( "role", user.getRole() );
        return user.getRole() + "page";
    }
}