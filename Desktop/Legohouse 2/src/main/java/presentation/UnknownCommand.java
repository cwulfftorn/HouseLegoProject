/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import function.GeneralException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author christianwulff
 */
public class UnknownCommand extends Command {

   @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws GeneralException {
        String msg = "Unknown command. Contact IT";
        throw new GeneralException( msg );
    }
    
}
