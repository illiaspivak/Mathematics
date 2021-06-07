package sk.kosickaakademia.spivak.ObserverTASR;

public class Main {
    public static void main(String[] args) {
        Tars tars = new Tars();

        new EmailServer(tars);
        new SMSServer(tars);
        new FaxServer(tars);
        new FBServer(tars);

        tars.setMessage("Dneska je Slnko");
    }
}
