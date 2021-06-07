package sk.kosickaakademia.spivak.ObserverTASR;

public class FaxServer extends Observer{
    public FaxServer(Tars tars) {
        this.tars = tars;
        this.tars.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Fax message: " + tars.getMessage() );
    }
}
