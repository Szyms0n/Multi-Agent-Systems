import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class Zad4 extends Agent {
    private int step = 0;
    @Override
    protected void setup() {
        System.out.println("Startuje!");
        addBehaviour(new Behaviour() {
            @Override
            public void action() {
                switch(step){

                    case 0:
                        System.out.println("pierwszy krok");
                        step++;
                        break;
                    case 1:
                        System.out.println("drugi krok");
                        step++;
                        break;
                    case 2:
                        System.out.println("trzeci krok");
                        step++;
                        break;


                }

            }

            @Override
            public boolean done() {
                return step ==3;
            }
        });


    }


}



