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
public class LegoHouseCalculator {
    
    public static Brick calculateLegoHouse(int length, int width, int height, boolean windowDoor) {
        
        Brick bricksCalculated = new Brick();
        int four, two, one;
        int l, w;
        for (int i = 1; i <= height; i++) {
            if (i % 2 == 1) {
                l = length;
                w = width - 4;
            } else {
                l = length - 4;
                w = width;
            }
            four = (l / 4) * 2 + (w / 4) * 2;
            two = ((l % 4) / 2) * 2 + ((w % 4) / 2) * 2;
            one = ((l % 4) % 2) * 2 + ((w % 4) % 2) * 2;
            
            if (windowDoor == true) {
                
            }
            
            bricksCalculated.addBrick(four, two, one);
        }

        return bricksCalculated;

    
    }
   
}
