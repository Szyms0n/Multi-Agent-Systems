import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.core.behaviours.ThreadedBehaviourFactory;

public class klasa_2_3 extends Agent {

    @Override
    protected void setup() {
        System.out.println(getLocalName() + ": Startuje!");


        ThreadedBehaviourFactory tbf = new ThreadedBehaviourFactory();


        ParallelBehaviour pb = new ParallelBehaviour(ParallelBehaviour.WHEN_ALL);


        pb.addSubBehaviour(tbf.wrap(new SimpleBehaviour(this) {
            private int i = 0;

            @Override
            public void action() {
                System.out.println("Zachowanie 1 – krok " + i);
                i++;
                block(500);
            }

            @Override
            public boolean done() {
                return i >= 5;
            }
        }));


        pb.addSubBehaviour(tbf.wrap(new SimpleBehaviour(this) {
            private int j = 0;

            @Override
            public void action() {
                System.out.println("Zachowanie 2 – krok " + j);
                j++;
                block(700);
            }

            @Override
            public boolean done() {
                return j >= 5;
            }
        }));


        pb.addSubBehaviour(tbf.wrap(new SimpleBehaviour(this) {
            private int k = 0;

            @Override
            public void action() {
                System.out.println("Zachowanie 3 – krok " + k);
                k++;
                block(1000);
            }

            @Override
            public boolean done() {
                return k >= 5;
            }
        }));


        addBehaviour(pb);


        addBehaviour(new Behaviour() {
            private int step = 0;

            @Override
            public void action() {
                switch (step) {
                    case 0:
                        System.out.println("Agent -> pierwszy krok");
                        step++;
                        break;
                    case 1:
                        System.out.println("Agent -> drugi krok");
                        step++;
                        break;
                    case 2:
                        System.out.println("Agent -> trzeci krok");
                        step++;
                        break;
                }
                block(800);
            }

            @Override
            public boolean done() {
                return step == 3;
            }
        });
    }
}
