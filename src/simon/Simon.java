/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simon;

import javax.swing.JOptionPane;

/**
 *
 * @author matheus
 */
public class Simon {

    String fita;
    Yoshi yoshi;
    Turtle[] turtles = new Turtle[4];
    Color[] color = new Color[4];
    Fruit fruit;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int op = JOptionPane.NO_OPTION;
        Game game = new Game();
        do{
        game.initGame();
        game.setFita(JOptionPane.showInputDialog(null, "Digite a Palavra na Fita"));
        game.gameStart();
        op = JOptionPane.showConfirmDialog(null, "Deseja jogar Novamente? ", "Jogar novamente:", JOptionPane.YES_NO_OPTION);
        }while(op == JOptionPane.YES_OPTION);
        
        if(op == JOptionPane.NO_OPTION)
            System.err.println("Jogo Terminado");
        
        System.exit(0);

    }
    
    
}
