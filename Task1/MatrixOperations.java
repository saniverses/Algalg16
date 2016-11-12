
/**
 * Created by Sania on 12.11.2016.
 */
public class MatrixOperations {
    public static Matrix multiplication(Matrix a, Matrix b) {
        int[][] tmp = new int[a.dimension][a.dimension];
        //System.out.println("mul");
        for (int i = 0; i < a.dimension; i++) {
            for (int j = 0; j < a.dimension; j++) {
                tmp[i][j] = 0;
                for (int k = 0; k < a.dimension; k++) {
                    tmp[i][j] += a.indexOf(i, k) * b.indexOf(k, j);
                }

                //System.out.print("tmp[i][j] " + tmp[i][j]);
            }
            //System.out.println();
        }
        Matrix res = new Matrix(tmp);
        //System.out.println("rererer");
        //res.print();
        return res;
    }

    public int[][] multiplication(int[][] a, int[][] b) {
        int w = a[0].length * b[0].length;
        int[][] tmp = new int[w][w];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < w; j++) {
                tmp[i][j] = a[i][j] * b[i][j];
            }
        }
        return tmp;
    }

    public static void copyAll(Matrix source, Matrix destination) {
        int[][] tmp = destination.getMatrix();
        for (int i = 0; i < destination.dimension; i++) {
            for (int j = 0; j < destination.dimension; j++) {
                tmp[i][j] = source.indexOf(i, j);
            }
        }
    }

    public static Matrix add(Matrix a, Matrix b) {
        if (a.dimension != b.dimension) System.out.println("incompatible sizes");
        int[][] ress = new int[a.dimension][a.dimension];
        for (int i = 0; i < a.dimension; i++) {
            for (int j = 0; j < a.dimension; j++) {
                ress[i][j] = a.indexOf(i, j) + b.indexOf(i, j);
            }
        }
        return new Matrix(ress);
    }


    public static Matrix sub(Matrix a, Matrix b) {
        if (a.dimension != b.dimension) System.out.println("incompatible sizes");
        int[][] ress = new int[a.dimension][a.dimension];
        for (int i = 0; i < a.dimension; i++) {
            for (int j = 0; j < a.dimension; j++) {
                ress[i][j] = a.indexOf(i, j) - b.indexOf(i, j);
            }
        }
        return new Matrix(ress);
    }

    //all source matrix will be copied to destination from startI to endI from startJ to endJ
    public static void copy(Matrix source, Matrix destination, int startI, int endI, int startJ, int endJ) {
        int[][] tmp = destination.getMatrix();
        int k = 0;
        int l = 0;
        for (int i = startI; i < endI; i++, k++) {
            for (int j = startJ; j < endJ; j++, l++) {
                tmp[i][j] = source.indexOf(k, l);
            }
            l = 0;
        }

    }

    public static Matrix resize(Matrix a, int newDimention) {
        Matrix tmp = new Matrix(newDimention);
        int[][] tmpM = tmp.getMatrix();
        for (int i = 0; i < a.dimension; i++) {
            for (int j = 0; j < a.dimension; j++) {
                tmpM[i][j] = a.indexOf(i, j);
            }
        }
        return tmp;
    }


}
