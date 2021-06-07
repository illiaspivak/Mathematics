package sk.kosickaakademia.spivak.ObserverTASR;
import java.util.ArrayList;
import java.util.List;

public class Tars {

    private List<Observer> list = new ArrayList<Observer>();
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        list.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : list) {
            observer.update();
        }
    }
}
