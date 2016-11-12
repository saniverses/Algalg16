
/**
 * Created by Sania on 12.11.2016.
 */
public class DegreesOfTwo {
    public static int[] degrees;

    static {
        int k = 1;
        degrees = new int[10];
        degrees[0] = 2;
        for (int i = 0; i < 9; i++) {
            degrees[k] = 2 * degrees[k - 1];
            k++;
        }
    }

    public static int nearest(int n) {
        for (int i = 0; i < degrees.length; i++) {
            if (n < degrees[i]) return degrees[i];
        }
        return -1;
    }

    public static boolean isDegreeOfTwo(int n) {
        for (int degree:
             degrees) {
            if (n == degree) return true;

        }
        return false;
    }
}
