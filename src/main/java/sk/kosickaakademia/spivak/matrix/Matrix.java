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
    public int mainDiagonal (int matrix[][]){
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

    /**
     * Multiplying the numbers of the secondary diagonal
     * @param matrix
     * @return int
     */
    public int secondaryDiagonal (int matrix[][]){
        int result = 1;
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix.length-i-1 == j){
                    result = result * matrix[i][j];
                }
            }
        }
        return result;
    }

    /**
     * Determinant of 2x2 Matrix
     * @param matrix
     * @return int
     */
    public int determinant2x2Matrix (int matrix[][]){
        if(matrix.length == 2 && matrix[0].length == 2){
            int main = mainDiagonal(matrix);
            int secondary = secondaryDiagonal(matrix);
            return main - secondary;
        }
        return 0;
    }

    /**
     * Determinant of 3x3 Matrix
     * @param matrix
     * @return int
     */
    public int determinant3x3Matrix (int matrix[][]){
        if(matrix.length == 3 && matrix[0].length == 3){
            return mainDiagonal(matrix) + matrix[2][0]*matrix[0][1]*matrix[1][2]
            + matrix[1][0]*matrix[2][1]*matrix[0][2] - secondaryDiagonal(matrix)
            - matrix[0][0]*matrix[2][1]*matrix[1][2] - matrix[1][0]*matrix[0][1]*matrix[2][2];
        }
        return 0;
    }

    public int determinant4x4Matrix (int matrix[][]){
        if(matrix.length == 4 && matrix[0].length == 4){
            int a = matrix.length;
            int partOfMatrix[][] = new int[a-1][a-1];
            for(int i = 1, x = 0; i < a; i++,x++){
                for (int j = 1, y = 0; j < a; j++,y++){
                    partOfMatrix[x][y] = matrix[i][j];
                }

            }
            printMatrix(partOfMatrix);
            return 0;
        }

        return 0;
    }
}
