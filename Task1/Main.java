
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        WinogradStrassenAlgorithm test = new WinogradStrassenAlgorithm();
        int[][] a;
        int[][] b;
        int n = new Integer(scanner.next());
        a = new int[n][n];
        b = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scanner.nextInt();
            }

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = scanner.nextInt();
            }

        }

        Matrix aa = new Matrix(a);
        Matrix bb = new Matrix(b);

        //aa.print();
        //bb.print();
        //System.out.println("result");
        Matrix result;
        result = test.multiplication(aa, bb, n);
        //result.print();
    }

}
