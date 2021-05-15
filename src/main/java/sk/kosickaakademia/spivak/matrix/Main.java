package sk.kosickaakademia.spivak.matrix;


public class Main
{
    public static void main( String[] args )
    {
        Matrix matrix = new Matrix();
        int[][] matrix1 = new int[][]{ {2,5,9,8,1},{8,9,-5,2,7},{1,8,7,9,2},{-2,4,0,7,2} };
        int[][] matrix2 = new int[][]{ {4,-5},{3,-2} };
        int[][] matrix3 = new int[][]{ {2,5,9},{8,9,-5},{1,8,7} };
        int[][] matrix4 = new int[][]{ {2,5,9,8},{8,9,-5,2},{1,8,7,9},{-2,4,0,7} };

        matrix.printMatrix(matrix4);
        matrix.determinant4x4Matrix(matrix4);



    }

}
