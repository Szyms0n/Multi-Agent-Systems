import jade.core.Agent;

import jade.core.behaviours.OneShotBehaviour;

public class Zad2 extends Agent {
    @Override
    protected void setup() {
        System.out.println("Startuje!");

        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                System.out.println("wykonuje");
            }
        });


    }

    public void doDelete(){
        System.out.println("Zaraz sie usune!");

    }
}


