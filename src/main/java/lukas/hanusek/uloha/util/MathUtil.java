package lukas.hanusek.uloha.util;

/**
 *
 * @author Lukas Hanusek
 */
public class MathUtil {

    public static boolean isPrime(long n) {
        if (n <= 0) return false;
        long m = 0;
        m = n / 2;
        if (n == 0 || n == 1) {
            return false;
        } else {
            for (long i = 2; i <= m; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
