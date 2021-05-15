package sk.kosickaakademia.spivak.matrix;


public class Main
{
    public static void main( String[] args )
    {
        Matrix matrix = new Matrix();
        int[][] matrix1 = new int[][]{ {2,5,9,8,1},{8,9,-5,2,7},{1,8,7,9,2},{-2,4,0,7,2} };
        int[][] matrix2 = new int[][]{ {4,-5},{3,-2} };

        matrix.printMatrix(matrix2);
        System.out.println(matrix.determinant2x2Matrix(matrix2));

    }

}
