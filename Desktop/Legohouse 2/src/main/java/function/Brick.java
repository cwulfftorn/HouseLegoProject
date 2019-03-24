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
public class Brick {
    
    private int large;
    private int medium;
    private int small;
    private boolean windowDoor;

    public Brick() {
        this.large = 0;
        this.medium = 0;
        this.small = 0;
        this.windowDoor = false;
    }

    public int getFour() {
        return large;
    }

    public int getTwo() {
        return medium;
    }
    
    public int getOne() {
        return small;
    }
    
    public boolean windowDoor() {
        return windowDoor;
    }

    public void addBrick(int four, int two, int one) {
        
        this.large += four;
        this.medium += two;
        this.small += one;
    }
    
    public void addWindowDoor() {
        this.large -= 15;
        this.medium += 10;
        this.windowDoor = true;
    }

    
}
