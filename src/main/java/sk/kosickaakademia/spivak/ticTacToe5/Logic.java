package sk.kosickaakademia.spivak.ticTacToe5;


public class Logic {

    public void Coordinate (double xPixel, double yPixel){
        int x = (int)Math.round(xPixel);
        int y = (int)Math.round(yPixel);
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 15; j++){
                if(y >= i*40 && y <= 40+i*40  && x >= j*40  && x <= 40+j*40 ){
                    System.out.println(x);
                    System.out.println(y);
                    System.out.println("[" + i +"][" + j + "]");
                }
            }
        }

    }
}
