import jade.core.Agent;
import jade.core.behaviours.Behaviour;

import java.util.Scanner;

public class Zad6 extends Agent {
    @Override
    protected void setup() {

        addBehaviour(new Behaviour() {

            @Override
            public void action() {
                System.out.println("Zachowanie startuje");
                Scanner scanner = new Scanner(System.in);
                int number = scanner.nextInt();

                if(number < 0) {
                    myAgent.doDelete();

                }
            }

            @Override
            public boolean done() {
                System.out.println("Zachowanie zakonczone");
                return true;
            }
        });
    }

    public void doDelete(){
        System.out.println("Zaraz sie usune!");

    }
}



