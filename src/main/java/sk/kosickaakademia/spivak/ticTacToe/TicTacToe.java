package sk.kosickaakademia.spivak.ticTacToe;

import java.util.Scanner;

public class TicTacToe {
    private int[][] pole;
    private int player=1;
    private int count=0;

    /**
     * Determines whether one of the players on the 5-on-5 field has won
     * @param field
     * @return -1   Array not of size 5 by 5
     *          0   No one won
     *          1   The number one player won
     *          2   The number two player won
     */
    private int isWinner5on5(int[][] field){
        if(field.length != 5 || field[0].length != 5){
            return -1;
        }
        for(int i = 0; i < 5; i++){
            if(field[i][0]*field[i][1]*field[i][2]*field[i][3]*field[i][4]==1 || field[0][i]*field[1][i]*field[2][i]*field[3][i]*field[4][i]==1)
                return 1;
            if(field[i][0]*field[i][1]*field[i][2]*field[i][3]*field[i][4]==32 || field[0][i]*field[1][i]*field[2][i]*field[3][i]*field[4][i]==8)
                return 2;
        }
        if(field[0][0]*field[1][1]*field[2][2]*field[3][3]*field[4][4]==1 || field[0][4]*field[1][3]*field[2][2]*field[3][1]*field[4][0]==1)
            return 1;
        if(field[0][0]*field[1][1]*field[2][2]*field[3][3]*field[4][4]==32 || field[0][4]*field[1][3]*field[2][2]*field[3][1]*field[4][0]==32)
            return 2;
        return 0;
    }

    /**
     * Determines whether one of the players on the N-on-N field has won
     * @param field
     * @return -1   Array not of size N by N
     *          0   No one won
     *          1   The number one player won
     *          2   The number two player won
     */
    private int isWinnerNxN(int[][] field){
        if(field.length != field[0].length || field.length < 5){
            return -1;
        }
        int n = field.length;
        for(int i = 0; i < n-4; i++) {
            for (int j = 0; j < n-4; j++) {
                int[][] array = new int[5][5];
                for (int x = 0; x < 5; x++) {
                    for (int y = 0; y < 5; y++) {
                        array[x][y] = field[x + i][y + j];
                    }
                }
                int result = isWinner5on5(array);
                if(result == 1){
                    return 1;
                }
                if(result == 2){
                    return 2;
                }
            }
        }
        return 0;
    }

    /**
     * Filling an array with zeros
     * @param field
     */
    private void initArray(int[][] field) {
        for(int i = 0; i < field.length; i++){
            for(int j = 0; j < field[0].length; j++){
                field[i][j] = 0;
            }
        }
    }

    /**
     * Output an array to the console
     * @param field
     */
    private void printGame(int[][] field) {
        for(int i=0;i< field.length;i++){
            System.out.print("-" + "\t");
        }
        System.out.println();
        for(int i=0;i< field.length;i++){
            for(int j=0;j< field[0].length;j++){
                System.out.print(field[i][j] + "\t");
            }
            System.out.println();
        }
        for(int i=0;i< field.length;i++){
            System.out.print("-" + "\t");
        }
        System.out.println();
    }

    public void play(){
        System.out.println("This is a 5-in-a-row tic-tac-toe game!");
        System.out.println("Enter the size of the field:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] field = new int[n][n];
        initArray(field);
        printGame(field);
    }
}
