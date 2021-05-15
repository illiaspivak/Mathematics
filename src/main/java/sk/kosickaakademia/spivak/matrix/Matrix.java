package sk.kosickaakademia.spivak.matrix;

public class Matrix {

    /**
     * Output of the matrix to the console
     * @param matrix
     */
    public void printMatrix (int matrix[][]){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Multiplying the numbers of the main diagonal
     * @param matrix
     * @return int
     */
    public static int mainDiagonal (int matrix[][]){
        int result = 1;
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(i == j){
                    result = result * matrix[i][j];
                }
            }
        }
        return result;
    }
}
