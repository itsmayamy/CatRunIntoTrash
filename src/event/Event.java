/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package event;
import character.*;
/**
 *
 * @author acer
 */
public class Event {
    public static boolean checkHit(Cat cat,Wave wave,int catSize,int waveHight){
        if(cat.x+catSize > wave.x && cat.x < wave.x){
            int waveHeight = 50;
            if(cat.y+catSize >= wave.y-waveHeight){
                return true;
            }
        }
        return false;
    }
    
    public static void gameStop(Wave[] wave,Environment[] env){
        
    }
    
    
}
