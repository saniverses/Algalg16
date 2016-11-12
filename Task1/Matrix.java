
/**
 * Created by Sania on 12.11.2016.
 */
public class Matrix {
    public int[][] matrix;
    public int dimension;

    Matrix(int[][] matrix) {
        this.matrix = matrix;
        dimension = matrix.length;
        //we suggesting that our Marixes are square matrixes
    }

    public Matrix(int dimension) {
        this.matrix = new int[dimension][dimension];
        this.dimension = dimension;
    }


    public int indexOf(int i, int j) {
        return matrix[i][j];
    }

    public int[][] getMatrix() {
        return matrix;
    }


    public Matrix getSubMatrix(int startI, int endI, int startJ, int endJ) {
        int[][] subMatrix = new int[endI - startI][endJ - startJ];
        //if (startI < 0 )
        int k = 0;
        int l = 0;
        for (int i = startI; i < endI; i++, k++) {
            for (int j = startJ; j < endJ; j++, l++) {
                //System.out.print(k);
                //System.out.println("ff" + l +" kfk ");
                subMatrix[k][l] = this.indexOf(i, j);
            }
            l = 0;
        }
        return new Matrix(subMatrix);
    }


    public void print() {
        System.out.println();
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
