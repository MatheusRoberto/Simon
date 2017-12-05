/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simon;


/**
 *
 * @author matheus
 */
public class Victory {

    public boolean isVictory(Yoshi y) {
        if(y.getInside().get(0) instanceof Fruit)
            return fruitVictory(y);
        if(y.getInside().get(0) instanceof Turtle)
            return turtleVictory(y);
        return false;
    }

    public boolean fruitVictory(Yoshi y) {
        for (int i = 0; i < y.getInside().size(); i++) {
            if (y.getInside().get(i).equals(y.getInside().get(i + 1))
                    && y.getInside().get(i + 1).equals(y.getInside().get(i + 2))
                    && y.getInside().get(i + 2).equals(y.getInside().get(i + 3))
                    && y.getInside().get(i + 3).equals(y.getInside().get(i + 4))) {
                return true;
            }

        }
        return false;
    }

    public boolean turtleVictory(Yoshi y) {
        for (int i = 0; i < y.getInside().size(); i++) {
            Turtle t1 = (Turtle) y.getInside().get(i);
            switch (t1.getColor().getColor()) {
                case "red":
                    return this.redVictory((Turtle) y.getInside().get(i+1), 
                            (Turtle) y.getInside().get(i+2),
                            (Turtle) y.getInside().get(i+3));
                case "green":
                    return this.greenVictory((Turtle) y.getInside().get(i+1), 
                            (Turtle) y.getInside().get(i+2),
                            (Turtle) y.getInside().get(i+3));
                case "blue":
                    return this.blueVictory((Turtle) y.getInside().get(i+1), 
                            (Turtle) y.getInside().get(i+2),
                            (Turtle) y.getInside().get(i+3));
                case "yellow":
                    return this.yellowVictory((Turtle) y.getInside().get(i+1), 
                            (Turtle) y.getInside().get(i+2),
                            (Turtle) y.getInside().get(i+3));
            }
        }
        return false;
    }

    private boolean redVictory(Turtle t1, Turtle t2, Turtle t3) {
        return t1.getColor().getColor().equalsIgnoreCase("green")
                && t2.getColor().getColor().equalsIgnoreCase("blue")
                && t3.getColor().getColor().equalsIgnoreCase("yellow");
    }

    private boolean greenVictory(Turtle t1, Turtle t2, Turtle t3) {
        return t1.getColor().getColor().equalsIgnoreCase("blue")
                && t2.getColor().getColor().equalsIgnoreCase("yellow")
                && t3.getColor().getColor().equalsIgnoreCase("red");
    }

    private boolean blueVictory(Turtle t1, Turtle t2, Turtle t3) {
        return t1.getColor().getColor().equalsIgnoreCase("yellow")
                && t2.getColor().getColor().equalsIgnoreCase("red")
                && t3.getColor().getColor().equalsIgnoreCase("green");
    }

    private boolean yellowVictory(Turtle t1, Turtle t2, Turtle t3) {
        return t1.getColor().getColor().equalsIgnoreCase("red")
                && t2.getColor().getColor().equalsIgnoreCase("green")
                && t3.getColor().getColor().equalsIgnoreCase("blue");
    }
}
