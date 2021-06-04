package sk.kosickaakademia.spivak.state;

public class GreenState implements State {
    public void doAction(Context context) {
        System.out.println("Green color");
        context.setState(this);
    }

    public String toString(){
        return "Green color";
    }
}
