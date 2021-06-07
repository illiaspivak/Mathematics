package sk.kosickaakademia.spivak.ObserverTASR;

public class EmailServer extends Observer{
    public EmailServer(Tars tars) {
        this.tars = tars;
        this.tars.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Email message: " + tars.getMessage() );
    }
}
