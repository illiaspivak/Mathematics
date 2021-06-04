package sk.kosickaakademia.spivak.state;

public class StatePatternDemo {
    public static void main(String[] args) {
        Context context = new Context();

        RedState redState = new RedState();
        redState.doAction(context);



        OrangeState orangeState = new OrangeState();
        orangeState.doAction(context);



        GreenState greenState = new GreenState();
        greenState.doAction(context);


    }
}
