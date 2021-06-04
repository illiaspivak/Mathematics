package sk.kosickaakademia.spivak.state;

public class RedState implements State {
    public void doAction(Context context) {
        System.out.println("Red color");
        context.setState(this);
    }

    public String toString(){
        return "Red color";
    }
}
