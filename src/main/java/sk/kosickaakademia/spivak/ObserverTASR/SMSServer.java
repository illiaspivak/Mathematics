package sk.kosickaakademia.spivak.ObserverTASR;

public class SMSServer extends Observer{
    public SMSServer(Tars tars) {
        this.tars = tars;
        this.tars.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "SMS message: " + tars.getMessage() );
    }
}
