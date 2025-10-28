import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.core.behaviours.ThreadedBehaviourFactory;

public class klasa_2_5 extends Agent {

    @Override
    protected void setup() {
        System.out.println(getLocalName() + ": setup() - uruchamiam agenta");

        ThreadedBehaviourFactory tbf = new ThreadedBehaviourFactory();


        TickerBehaviour ticker1 = new TickerBehaviour(this, 1000) {
            private int count = 0;
            @Override
            protected void onTick() {
                count++;

                System.out.println(System.currentTimeMillis() + " [" + Thread.currentThread().getName() + "] cyclic 1 (powtórzenie " + count + ")");
                if (count >= 10) {

                    System.out.println(getLocalName() + ": ticker1 zakończony po " + count + " powtórzeniach.");
                    stop();
                }
            }
        };


        TickerBehaviour ticker2 = new TickerBehaviour(this, 2000) {
            private int count = 0;
            @Override
            protected void onTick() {
                count++;
                System.out.println(System.currentTimeMillis() + " [" + Thread.currentThread().getName() + "] cyclic 2 (powtórzenie " + count + ")");
                if (count >= 10) {
                    System.out.println(getLocalName() + ": ticker2 zakończony po " + count + " powtórzeniach.");
                    stop();
                }
            }
        };


        addBehaviour(tbf.wrap(ticker1));
        addBehaviour(tbf.wrap(ticker2));


        addBehaviour(new TickerBehaviour(this, 1000) {
            @Override
            protected void onTick() {

                boolean t1Done = ticker1.done();
                boolean t2Done = ticker2.done();
                if (t1Done && t2Done) {
                    System.out.println(getLocalName() + ": oba tickery zakończone — zamykam agenta.");
                    stop();
                    doDelete();
                }
            }
        });

    }

    @Override
    protected void takeDown() {
        System.out.println(getLocalName() + ": takeDown() - agent zakończony.");
    }
}
