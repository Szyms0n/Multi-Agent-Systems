import jade.core.Agent;
import jade.core.behaviours.Behaviour;

import java.util.Scanner;

public class Zad5 extends Agent {
    @Override
    protected void setup() {
        System.out.println("Startuje!");
        addBehaviour(new Behaviour() {

            @Override
            public void action() {
                Scanner scanner = new Scanner(System.in);
                int number = scanner.nextInt();

                if(number < 0) {
                    myAgent.doDelete();
                }
            }

            @Override
            public boolean done() {
                return false;
            }
        });
    }

    public void doDelete(){
        System.out.println("Zaraz sie usune!");

    }
}



