/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import function.GeneralException;
import function.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author christianwulff
 */
public class OrderMapper {
    
    public static void createOrder(int id, Order hOrder) throws GeneralException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "INSERT INTO legohus.order (`idUser`, `length`, `width`, `height`, `windowDoor`)" 
                    + "VALUES (?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ps.setInt(2, hOrder.getLength());
            ps.setInt(3, hOrder.getWidth());
            ps.setInt(4, hOrder.getHeight());
            ps.setBoolean(5, hOrder.hasWindowDoor());

            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();

        } catch (SQLException | ClassNotFoundException ex) {
            throw new GeneralException(ex.getMessage());
        }
    }
    
    public static ArrayList<Order> showCustomerOrders(String userId) throws GeneralException {
        ArrayList<Order> hOrderList = new ArrayList();

        try {
            Connection con = DBConnector.connection();
            String SQL = "SELECT idOrder, length, width, height, windowDoor, isShipped "
                    + "FROM `order`"
                    + "WHERE idUser=?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, Integer.parseInt(userId));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idOrder = rs.getInt("idOrder");
                int hLength = rs.getInt("length");
                int hWidth = rs.getInt("width");
                int hHeight = rs.getInt("height");
                boolean windowDoor = rs.getBoolean("windowDoor");
                boolean isShipped = rs.getBoolean("isShipped");

                hOrderList.add(new Order(idOrder, hLength, hWidth, hHeight, windowDoor, isShipped));
            }
            return hOrderList;

        } catch (ClassNotFoundException | SQLException ex) {
            throw new GeneralException(ex.getMessage());
        }
    }

    public static ArrayList<Order> showAllOrders() throws GeneralException {
        ArrayList<Order> hOrderList = new ArrayList();

        try {
            Connection con = DBConnector.connection();
            String SQL = "SELECT idOrder, length, width, height, windowDoor, isShipped "
                    + "FROM `order`;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idOrder = rs.getInt("idOrder");
                int hLength = rs.getInt("length");
                int hWidth = rs.getInt("width");
                int hHeight = rs.getInt("height");
                boolean windowDoor = rs.getBoolean("windowDoor");
                boolean isShipped = rs.getBoolean("isShipped");
                Order hOrder = new Order(idOrder, hLength, hWidth, hHeight, windowDoor, isShipped);
                hOrderList.add(hOrder);
                
            }
            return hOrderList;
//            } else {
//                throw new GeneralException( "Could not validate user" );
//            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new GeneralException(ex.getMessage());
        }
    }

    public static Order showSingleOrder(int orderId) throws GeneralException {
            
        try {
            Connection con = DBConnector.connection();
            String SQL = "SELECT *"
                    + "FROM `order`"
                    + "WHERE idOrder=?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, (orderId));
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int hLength = rs.getInt("length");
                int hWidth = rs.getInt("width");
                int hHeight = rs.getInt("height");
                boolean windowDoor = rs.getBoolean("windowDoor");
                boolean isShipped = rs.getBoolean("isShipped");
                
                Order singleOrder = new Order(orderId, hLength, hWidth, hHeight, windowDoor, isShipped);
            
                return singleOrder;
            } else {
                throw new GeneralException("Could not validate user");
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new GeneralException(ex.getMessage());
        }

    }

    
    
}
