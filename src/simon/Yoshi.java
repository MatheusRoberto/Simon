/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simon;

import java.util.ArrayList;

/**
 *
 * @author matheus
 */
public class Yoshi {

    public Yoshi() {
        inside = new ArrayList<>();
    }
    
    

    private ArrayList<Food> inside;

    public boolean eat(Food a) {
        
        if (a instanceof Fruit) {
            Fruit fru = (Fruit) a;
            return inside.add(fru);
        }else if(a instanceof Turtle){
            Turtle turtle = (Turtle) a;
            return inside.add(turtle);
        }
        
        return false;
    }
    
    public final boolean clear(){
        inside.clear();
        return getInside().isEmpty();
    }
    
    /**
     * @return the inside
     */
    public ArrayList<Food> getInside() {
        return inside;
    }

    /**
     * @param inside the inside to set
     */
    public void setInside(ArrayList<Food> inside) {
        this.inside = inside;
    }

}
