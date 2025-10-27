import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.core.behaviours.WakerBehaviour;

public class Zad8 extends Agent {

    private TickerBehaviour malyTick;
    private TickerBehaviour duzyTick;

    @Override
    protected void setup() {
        System.out.println("Agent startuje!");


        malyTick = new TickerBehaviour(this, 2000) {
            @Override
            protected void onTick() {
                System.out.println("mały tick");
            }
        };
        addBehaviour(malyTick);


        duzyTick = new TickerBehaviour(this, 5000) {
            @Override
            protected void onTick() {
                System.out.println("duży tick");
            }
        };
        addBehaviour(duzyTick);


        addBehaviour(new WakerBehaviour(this, 50000) {
            @Override
            protected void onWake() {
                removeBehaviour(duzyTick);
                System.out.println("Zachowanie 'duży tick' usunięte po 50 sekundach");
            }
        });


        addBehaviour(new WakerBehaviour(this, 100000) {
            @Override
            protected void onWake() {
                System.out.println("Agent kończy działanie po 100 sekundach");
                doDelete();
            }
        });
    }

    @Override
    protected void takeDown() {
        System.out.println("Agent został usunięty");
    }
}
