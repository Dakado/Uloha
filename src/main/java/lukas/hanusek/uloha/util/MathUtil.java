package lukas.hanusek.uloha.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lukas Hanusek
 */
public class MathUtil {

    /**
     * Check if the given number is a prime number
     * @param n
     * @return 
     */
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
    
    /**
     * Filters out all non-prime numbers from the given list of numbers
     * @param input
     * @return 
     */
    public static List<Long> filterPrimeNumbers(List<Long> input) {
        List<Long> output = new ArrayList();
        for (long i : input) {
            if (isPrime(i)) output.add(i);
        }
        return output;
    }

}
