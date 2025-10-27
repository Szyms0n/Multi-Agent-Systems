import jade.core.Agent;

import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;

public class Zad3 extends Agent {
    @Override
    protected void setup() {
        System.out.println("Startuje!");

        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action()
            {
                System.out.println("Wykonuje");
            }

        });




    }

    public void doDelete(){
        System.out.println("Zaraz sie usune!");

    }
}


