package sk.kosickaakademia.spivak.ticTacToe;

public class TicTacToe {

    /**
     * Determines whether one of the players on the 5-on-5 field has won
     * @param pole
     * @return -1   Array not of size 5 by 5
     *          0   No one won
     *          1   The number one player won
     *          2   The number two player won
     */
    public int isWinner5on5(int[][] pole){
        if(pole.length != 5 || pole[0].length != 5){
            return -1;
        }
        for(int i = 0; i < 5; i++){
            if(pole[i][0]*pole[i][1]*pole[i][2]*pole[i][3]*pole[i][4]==1 || pole[0][i]*pole[1][i]*pole[2][i]*pole[3][i]*pole[4][i]==1)
                return 1;
            if(pole[i][0]*pole[i][1]*pole[i][2]*pole[i][3]*pole[i][4]==32 || pole[0][i]*pole[1][i]*pole[2][i]*pole[3][i]*pole[4][i]==8)
                return 2;
        }
        if(pole[0][0]*pole[1][1]*pole[2][2]*pole[3][3]*pole[4][4]==1 || pole[0][4]*pole[1][3]*pole[2][2]*pole[3][1]*pole[4][0]==1)
            return 1;
        if(pole[0][0]*pole[1][1]*pole[2][2]*pole[3][3]*pole[4][4]==32 || pole[0][4]*pole[1][3]*pole[2][2]*pole[3][1]*pole[4][0]==32)
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
    public int isWinnerNxN(int[][] field){
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
     * @param array
     */
    public void initArray(int[][] array) {
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                array[i][j] = 0;
            }
        }
    }
}
