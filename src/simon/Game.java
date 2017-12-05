/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simon;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author matheus
 */
public class Game {

    private String fita;
    private Yoshi yoshi;
    private final Turtle[] turtles = new Turtle[4];
    private final Color[] color = new Color[4];
    private Fruit fruit;
    private final ArrayList<String> estados = new ArrayList<>();
    private final ArrayList<String> trans = new ArrayList<>();
    private int cont = 0;

    public void statesFruit() {
        estados.clear();
        cont = 0;
        estados.add("vz");
        for (int i = 0; i < 5; i++) {
            estados.add("f" + i);
        }
        trans.clear();
        for (int i = 0; i < 4; i++) {
            trans.add("e");
        }
    }

    public void statesTRed() {
        cont = 0;
        estados.clear();
        estados.add("vz");
        estados.add("r0");
        estados.add("g1");
        estados.add("b2");
        estados.add("y3");
        trans.clear();
        for (int i = 0; i < 3; i++) {
            trans.add("e");
        }
    }

    public void statesTGreen() {
        cont = 0;
        estados.clear();
        estados.add("vz");
        estados.add("g0");
        estados.add("b1");
        estados.add("y2");
        estados.add("r3");
        trans.clear();
        for (int i = 0; i < 3; i++) {
            trans.add("e");
        }
    }

    public void statesTBlue() {
        cont = 0;
        estados.clear();
        estados.add("vz");
        estados.add("b0");
        estados.add("y1");
        estados.add("r2");
        estados.add("g3");
        trans.clear();
        for (int i = 0; i < 3; i++) {
            trans.add("e");
        }
    }

    public void statesTyellow() {
        cont = 0;
        estados.clear();
        estados.add("vz");
        estados.add("y0");
        estados.add("r1");
        estados.add("g2");
        estados.add("b3");
        trans.clear();
        for (int i = 0; i < 3; i++) {
            trans.add("e");
        }
    }

    public void initGame() {
        //Turtle RED
        color[0] = new Color("red");
        turtles[0] = new Turtle(color[0]);
        //Turtle GREEN
        color[1] = new Color("green");
        turtles[1] = new Turtle(color[1]);
        //Turtle BLUE
        color[2] = new Color("blue");
        turtles[2] = new Turtle(color[2]);
        //Turtle YELLOW
        color[3] = new Color("yellow");
        turtles[3] = new Turtle(color[3]);

        //Fruit
        fruit = new Fruit();
        //fita
        fita = new String();

        //Yoshi
        yoshi = new Yoshi();
    }

    public void gameStart() {
        System.out.println("Palavra: " + this.fita);
        int op = 0;
        trans.clear();
        for (int i = 0; i < fita.length(); i++) {
            char atual = fita.charAt(i);
            if (op == 1) {
                if (!trans.isEmpty() && atual != 'e') {
                    if (atual != 'v') {
                        atual = 'x';
                    }
                }
            }
            switch (atual) {
                case 'r':
                    yoshi.eat(turtles[0]);
                    this.statesTRed();
                    break;
                case 'g':
                    yoshi.eat(turtles[1]);
                    this.statesTGreen();
                    break;
                case 'b':
                    yoshi.eat(turtles[2]);
                    this.statesTBlue();
                    break;
                case 'y':
                    yoshi.eat(turtles[3]);
                    this.statesTyellow();
                    break;
                case 'v':
                    yoshi.clear();
                    System.out.println("Estado Atual: " + estados.get(cont)
                            + " Leu: " + atual
                            + " Proximo Estado: vz");
                    System.out.println(estados.get(cont) + " -- " + atual + " --> vz");
                    limpatela();
                    this.trans.clear();
                    cont = 0;
                    break;
                case 'e':
                    if (!yoshi.getInside().isEmpty()) {
                        if (yoshi.getInside().get(0) instanceof Turtle) {
                            Turtle first = (Turtle) yoshi.getInside().get(yoshi.getInside().size() - 1);
                            if (first.getColor().getColor().equalsIgnoreCase("red")) {
                                yoshi.eat(turtles[1]);
                            }
                            if (first.getColor().getColor().equalsIgnoreCase("green")) {
                                yoshi.eat(turtles[2]);
                            }
                            if (first.getColor().getColor().equalsIgnoreCase("blue")) {
                                yoshi.eat(turtles[3]);
                            }
                            if (first.getColor().getColor().equalsIgnoreCase("yellow")) {
                                yoshi.eat(turtles[0]);
                            }
                        } else {
                            yoshi.eat(fruit);
                        }
                    } else {
                        yoshi.eat(fruit);
                        this.statesFruit();
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Erro, você digitou uma letra fora Alfabeto/Fora do Padrão");
                    op = 1;
                    break;
            }
            if (op == 1) {
                trans.clear();
                break;
            }
            if (atual != 'v') {
                System.out.println("Estado Atual: " + estados.get(cont)
                        + " Leu: " + atual
                        + " Proximo Estado: " + estados.get(cont + 1));
                System.out.println(estados.get(cont) + " -- " + atual + " --> " + estados.get(cont + 1));
                cont++;
            }
        }

        if (op != 1 && cont >= this.estados.size() - 1) {
            Victory v = new Victory();
            if (v.isVictory(yoshi)) {
                System.out.println("Venceu, Jogo em seu estado terminal");
                JOptionPane.showMessageDialog(null, "Você venceu!");
                return;
            }
        }
        System.out.println("Perdeu/Erro, Jogo não chegou em seu estado terminal");
        JOptionPane.showMessageDialog(null, "Você perdeu!");
    }

    public void setFita(String fita) {
        this.fita = fita;
    }

    public static void limpatela() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

}
