package sk.kosickaakademia.spivak.ObserverTASR;

public class FBServer extends  Observer{
    public FBServer(Tars tars) {
        this.tars = tars;
        this.tars.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "FB message: " + tars.getMessage() );
    }
}
