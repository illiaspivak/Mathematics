package sk.kosickaakademia.spivak.matrix;


public class Main
{
    public static void main( String[] args )
    {
        Matrix matrix = new Matrix();
        int[][] matrixTest = new int[][]{ {2,5,9,8,1},{8,9,-5,2,7},{1,8,7,9,2},{-2,4,0,7,2} };
        int[][] matrix2 = new int[][]{ {4,-5},{3,-2} };
        int[][] matrix3 = new int[][]{ {2,5,9},{8,9,-5},{1,8,7} };
        int[][] matrix4 = new int[][]{ {2,5,9,8},{8,9,-5,2},{1,8,7,9},{-2,4,0,7} };
        int[][] matrix5 = new int[][]{ {2,5,9,8,1},{8,9,-5,2,7},{1,8,7,9,2},{-2,4,0,7,2},{5,-7,3,1,6} };
        int[][] matrix6 = new int[][]{ {2,5,9,8,1,6},{8,9,-5,2,7,4},{1,8,7,9,2,2},{-2,4,0,7,2,2},{5,-7,3,1,6,1},{4,2,-3,4,6,0} };

        matrix.printMatrix(matrix6);
        System.out.println(matrix.determinantNxNMatrix(matrix6));//-46864




    }

}
