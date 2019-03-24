/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import function.GeneralException;
import function.User;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author christianwulff
 */
public abstract class Command {
    
    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login());
        commands.put( "register", new Register());
        commands.put( "backdoorCustomer", new BackDoorCustomer());
        commands.put( "backdoor", new BackDoor());
        commands.put( "HouseSize", new HouseSize());
        commands.put( "BackPage", new BackPage());
        commands.put( "LogOut", new LogOut());
        commands.put( "ShowOrders", new ShowCustomerOrders());
        commands.put( "ShowOrder", new ShowOneOrder());
        commands.put( "IsShipped", new IsShipped());
    
    }

    static Command from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws GeneralException;
    
}
