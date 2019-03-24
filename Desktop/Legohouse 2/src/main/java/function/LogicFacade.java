/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package function;

import data.OrderMapper;
import data.UserMapper;
import java.util.ArrayList;

/**
 *
 * @author christianwulff
 */
public class LogicFacade {
    
    public static User login( String email, String password ) throws GeneralException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws GeneralException {
        User user = new User(email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }
    
     public static void createOrder(int userId, Order hOrder) throws GeneralException {
        OrderMapper.createOrder(userId, hOrder);
    }

    public static ArrayList<Order> showCustomerOrders(String userId) throws GeneralException {
        return OrderMapper.showCustomerOrders(userId);
    }

    public static ArrayList<Order> showAllOrders() throws GeneralException {
        return OrderMapper.showAllOrders();
    }
    
    public static Order showSingleOrder(int orderId) throws GeneralException {
        return OrderMapper.showSingleOrder(orderId);
        
    }
    
}
