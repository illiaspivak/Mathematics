package sk.kosickaakademia.spivak.matrix;


public class Main
{
    public static void main( String[] args )
    {
        Matrix matrix = new Matrix();
        int[][] matrixTest = new int[][]{ {2,5,9,8,1},{8,9,-5,2,7},{1,8,7,9,2},{-2,4,0,7,2} };
        int[][] matrix1 = new int[][] {{2},{-3},{1}};
        int[][] matrix2 = new int[][]{ {4,-5},{3,-2} };
        int[][] matrix3 = new int[][]{ {5,8,-4},{6,9,-5},{4,7,-3} };
        int[][] matrix4 = new int[][]{ {2,5,9,8},{8,9,-5,2},{1,8,7,9},{-2,4,0,7} };
        int[][] matrix4_2 = new int[][]{ {2,5,9,8},{8,9,-5,2},{1,8,7,9},{-2,4,0,7} };
        int[][] matrix5 = new int[][]{ {2,5,9,8,1},{8,9,-5,2,7},{1,8,7,9,2},{-2,4,0,7,2},{5,-7,3,1,6} };
        int[][] matrix6 = new int[][]{ {2,5,9,8,1,6},{8,9,-5,2,7,4},{1,8,7,9,2,2},{-2,4,0,7,2,2},{5,-7,3,1,6,1},{4,2,-3,4,6,0} };//-46864

        matrix.printMatrix(matrix1);
        matrix.printMatrix(matrix3);
        matrix.printMatrix(matrix.matrixMultiplication(matrix3,matrix1));
        //System.out.println(matrix.determinantNxNMatrix(matrix6));




    }

}
