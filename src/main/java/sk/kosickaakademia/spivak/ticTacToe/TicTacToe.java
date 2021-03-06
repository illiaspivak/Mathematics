package sk.kosickaakademia.spivak.ticTacToe;

import java.util.Scanner;

public class TicTacToe {

    private int playerInt = 1;
    private String playerString = "X";
    private int count = 0;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_PURPLE = "\u001B[35m";


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
            if(field[i][0]*field[i][1]*field[i][2]*field[i][3]*field[i][4]==32 || field[0][i]*field[1][i]*field[2][i]*field[3][i]*field[4][i]==32)
                return 2;
            if(field[i][0]*field[i][1]*field[i][2]*field[i][3]*field[i][4]==243 || field[0][i]*field[1][i]*field[2][i]*field[3][i]*field[4][i]==243)
                return 3;
            if(field[i][0]*field[i][1]*field[i][2]*field[i][3]*field[i][4]==3125 || field[0][i]*field[1][i]*field[2][i]*field[3][i]*field[4][i]==3125)
                return 4;
        }
        if(field[0][0]*field[1][1]*field[2][2]*field[3][3]*field[4][4]==1 || field[0][4]*field[1][3]*field[2][2]*field[3][1]*field[4][0]==1)
            return 1;
        if(field[0][0]*field[1][1]*field[2][2]*field[3][3]*field[4][4]==32 || field[0][4]*field[1][3]*field[2][2]*field[3][1]*field[4][0]==32)
            return 2;
        if(field[0][0]*field[1][1]*field[2][2]*field[3][3]*field[4][4]==243 || field[0][4]*field[1][3]*field[2][2]*field[3][1]*field[4][0]==243)
            return 3;
        if(field[0][0]*field[1][1]*field[2][2]*field[3][3]*field[4][4]==3125 || field[0][4]*field[1][3]*field[2][2]*field[3][1]*field[4][0]==3125)
            return 4;
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
                if(result == 3){
                    return 3;
                }
                if(result == 4){
                    return 4;
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
     * Filling the array with values from 1 to NxN
     * @param field
     */
    private void initArrayString(String[][] field) {
        int n = 1;
        for(int i = 0; i < field.length; i++){
            for(int j = 0; j < field[0].length; j++){
                field[i][j] = String.valueOf(n);
                n++;
            }
        }
    }

    /**
     * Output an array to the console
     * @param field
     */
    private void printGame(String[][] field) {
        for(int i=0;i< field.length;i++){
            System.out.print("-" + "\t");
        }
        System.out.println();
        for(int i=0;i< field.length;i++){
            for(int j=0;j< field[0].length;j++){
                if(field[i][j].equals("X")){
                    System.out.print(ANSI_YELLOW + field[i][j] + ANSI_RESET + "\t");
                }else
                if(field[i][j].equals("???")){
                    System.out.print(ANSI_CYAN + field[i][j] + ANSI_RESET + "\t");
                }else if(field[i][j].equals("???")){
                    System.out.print(ANSI_RED + field[i][j] + ANSI_RESET + "\t");
                }else if(field[i][j].equals("???")){
                    System.out.print(ANSI_PURPLE + field[i][j] + ANSI_RESET + "\t");
                }else{
                    System.out.print(field[i][j] + "\t");
                }


            }
            System.out.println();
        }
        for(int i=0;i< field.length;i++){
            System.out.print("-" + "\t");
        }
        System.out.println();
    }



    /**
     * Move to the next player (game logic)
     */
    private void nextPlayerInt(int players) {
        if(players == 2){
            if(playerInt == 1)
                playerInt = 2;
            else
                playerInt = 1;
        }
        if(players == 3){
            if(playerInt==1)
                playerInt=2;
            else
            if(playerInt==2)
                playerInt=3;
            else
                playerInt=1;
        }
        if(players == 4){
            if(playerInt==1)
                playerInt=2;
            else
            if(playerInt==2)
                playerInt=3;
            else
            if(playerInt==3)
                playerInt=5;
            else
                playerInt=1;
        }
    }

    /**
     * Move to the next player (visually)
     */
    private void nextPlayerString(int players) {
        if(players == 2){
            if(playerString.equals("X"))
                playerString="???";
            else
                playerString="X";
        }
        if(players == 3){
            if(playerString.equals("X"))
                playerString="???";
            else
            if(playerString.equals("???"))
                playerString="???";
            else
                playerString="X";
        }
        if(players == 4){
            if(playerString.equals("X"))
                playerString="???";
            else
            if(playerString.equals("???"))
                playerString="???";
            else
            if(playerString.equals("???"))
                playerString="???";
            else
                playerString="X";
        }
    }

    /**
     * The main method. Game Logic
     */
    public void play(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("This is a 5-in-a-row tic-tac-toe game!");
        int players = 0;
        while(players < 2 || players > 4) {
            System.out.println("Enter the number of players from 2 to 4:");
            players = scanner.nextInt();
        }
        int n = 0;
        while(n < 5) {
            System.out.println("Enter the size of the field:");
            n = scanner.nextInt(); //field size
        }
        int[][] fieldInt = new int[n][n]; //array for game logic
        String[][] fieldString = new String[n][n]; //array to display on the screen
        initArray(fieldInt); //filling in the array
        initArrayString(fieldString); //filling in the array
        int input; //the cell selected by the player
        while(isWinnerNxN(fieldInt)==0) {
            if(playerInt == 5){
                System.out.println("Player's turn 4");
            }else{
                System.out.println("Player's turn " + playerInt);
            }
            printGame(fieldString);
            System.out.println("Enter a number from 1 to " + n*n);
            input = scanner.nextInt();
            if (input < 1 || input > n*n) {
                System.out.println("Input must be between 1 and " + n*n);
                continue;
            }
            int r=(input-1)/n;
            int c=(input-1)%n;
            if(fieldInt[r][c]!=0) {
                System.out.println("Tile you chosed is not empty");
                continue;
            }
            fieldInt[r][c]=playerInt;
            fieldString[r][c]=playerString;
            count++;
            if(count == n*n){
                break;
            }
            nextPlayerInt(players);
            nextPlayerString(players);
        }
        if(isWinnerNxN(fieldInt)==1){
            printGame(fieldString);
            System.out.println("Player 1 is winner");
        }
        else if(isWinnerNxN(fieldInt)==2){
            printGame(fieldString);
            System.out.println("Player 2 is winner");
        }else if(isWinnerNxN(fieldInt)==3){
            printGame(fieldString);
            System.out.println("Player 3 is winner");
        }else if(isWinnerNxN(fieldInt)==4){
            printGame(fieldString);
            System.out.println("Player 4 is winner");
        }else{
            printGame(fieldString);
            System.out.println("Standoff");
        }
    }
}
