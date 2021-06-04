package sk.kosickaakademia.spivak.state;

public class OrangeState implements State {
    public void doAction(Context context) {
        System.out.println("Orange color");
        context.setState(this);
    }

    public String toString(){
        return "Orange color";
    }
}
