/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package function;

/**
 *
 * @author christianwulff
 */
public class Order {
    
    int idOrder;
    int userId;
    int length;
    int width;
    int height;
    boolean windowDoor;
    boolean isShipped = false;

    public Order(int idOrder, int length, int width, int height, boolean windowDoor, boolean isShipped) {
        this.idOrder = idOrder;
        this.length = length;
        this.width = width;
        this.height = height;
        this.windowDoor = windowDoor;
        this.isShipped = isShipped;
    }
    
    public boolean isIsShipped() {
        return isShipped;
    }
    
    public boolean hasWindowDoor() {
        return windowDoor;
    }
    
    public void setIsShipped(boolean isShipped) {
        this.isShipped = isShipped;
    }

    public int getIdCustomer() {
        return userId;
    }
    
    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    public boolean isWindowDoor() {
        return windowDoor;
    }
    
    public void setWindowDoor(boolean windowDoor) {
        this.windowDoor = windowDoor;
    }

    @Override
    public String toString() {
        return "Order nr: " + getIdOrder() + " Shipped: " + (isShipped ? "yes" : "no");
    }
    
    
}
