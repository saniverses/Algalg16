package company;

/**
 * Created by Sania on 12.11.2016.
 */
public class WinogradStrassenAlgorithm {


    public Matrix multiplication(Matrix a, Matrix b, int dimension) {
        Matrix result = new Matrix(dimension);
        //DegreesOfTwo deg = new DegreesOfTwo();
        int newDim;
        if (dimension < 64) {
            result = MatrixOperations.multiplication(a, b);
            return result;
        } else {
            if (!DegreesOfTwo.isDegreeOfTwo(dimension)) {
                newDim = DegreesOfTwo.nearest(dimension);
                a = MatrixOperations.resize(a, newDim);
                b = MatrixOperations.resize(b, newDim);
                dimension = newDim;
                result = new Matrix(newDim);
            }


            Matrix a11, a12, a21, a22;
            Matrix b11, b12, b21, b22;
            Matrix c11, c12, c21, c22;
            Matrix p1, p2, p3, p4, p5, p6, p7;
            Matrix s1, s2, s3, s4, s5, s6, s7, s8;
            Matrix t1, t2;

            int h = dimension / 2;
            a11 = new Matrix(h);
            a12 = new Matrix(h);
            a21 = new Matrix(h);
            a22 = new Matrix(h);
            b11 = new Matrix(h);
            b12 = new Matrix(h);
            b21 = new Matrix(h);
            b22 = new Matrix(h);
            c11 = new Matrix(h);
            c12 = new Matrix(h);
            c21 = new Matrix(h);
            c22 = new Matrix(h);

            MatrixOperations.copyAll(a.getSubMatrix(0, h, 0, h), a11);
            MatrixOperations.copyAll(a.getSubMatrix(0, h, h, dimension), a12);
            MatrixOperations.copyAll(a.getSubMatrix(h, dimension, 0, h), a21);
            MatrixOperations.copyAll(a.getSubMatrix(h, dimension, h, dimension), a22);


            MatrixOperations.copyAll(b.getSubMatrix(0, h, 0, h), b11);
            MatrixOperations.copyAll(b.getSubMatrix(0, h, h, dimension), b12);
            MatrixOperations.copyAll(b.getSubMatrix(h, dimension, 0, h), b21);
            MatrixOperations.copyAll(b.getSubMatrix(h, dimension, h, dimension), b22);

            s1 = MatrixOperations.add(a21, a22);
            s2 = MatrixOperations.sub(s1, a11);
            s3 = MatrixOperations.sub(a11, a21);
            s4 = MatrixOperations.sub(a12, s2);
            s5 = MatrixOperations.sub(b12, b11);
            s6 = MatrixOperations.sub(b22, s5);
            s7 = MatrixOperations.sub(b22, b12);
            s8 = MatrixOperations.sub(s6, b21);



            p1 = multiplication(s2, s6, h);
            p2 = multiplication(a11, b11, h);
            p3 = multiplication(a12, b21, h);
            p4 = multiplication(s3, s7, h);
            p5 = multiplication(s1, s5, h);
            p6 = multiplication(s4, b22, h);
            p7 = multiplication(a22, s8, h);

            t1 = MatrixOperations.add(p1, p2);
            t2 = MatrixOperations.add(t1, p4);

            //now a11, a12, ... is used as temporary arrays

            a11 = MatrixOperations.add(p2, p3);
            a12 = MatrixOperations.add(p5, p6);
            a21 = MatrixOperations.add(t1, a12);
            a22 = MatrixOperations.sub(t2, p7);
            b11 = MatrixOperations.add(t2, p5);

            MatrixOperations.copyAll(a11, c11);
            MatrixOperations.copyAll(a21, c12);
            MatrixOperations.copyAll(a22, c21);
            MatrixOperations.copyAll(b11, c22);
            MatrixOperations.copy(c11, result, 0, h, 0, h);
            MatrixOperations.copy(c12, result, 0, h, h, dimension);
            MatrixOperations.copy(c21, result, h, dimension, 0, h);
            MatrixOperations.copy(c22, result, h, dimension, h, dimension);
            return result;
        }

    }






}
