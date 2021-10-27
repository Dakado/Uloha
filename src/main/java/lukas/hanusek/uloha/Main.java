package lukas.hanusek.uloha;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lukas.hanusek.uloha.cfg.Config;
import lukas.hanusek.uloha.data.DataConverter;
import lukas.hanusek.uloha.data.DataReader;
import lukas.hanusek.uloha.util.MathUtil;
import lukas.hanusek.uloha.validator.InputFileValidator;
import lukas.hanusek.uloha.validator.objects.ValidatorResult;

/**
 *
 * @author Lukas Hanusek
 */
public class Main {
    
    /**
     * Program's entry point
     * @param args
     */
    public static void main(String args[]) {
        if (args.length != 1) {
            System.out.println("Please specify .xlsx file as runtime argument!");
            return;
        }
        process(args[0]);
    }
    
    /**
     * Process input file
     * @param file 
     */
    public static void process(String file) {
        ValidatorResult vr = new InputFileValidator().validate(file);
        if (!vr.isValid()) {
            System.out.println(vr.toString());
            return;
        }
        System.out.println("Input file '" + file + "' is valid.");
        findPrimeNumbers(file);
    }
    
    /**
     * Find and print out all prime numbers found in the given file
     * @param file 
     */
    public static void findPrimeNumbers(String file) {
        Config cfg = Config.getInstance();
        System.out.println("Searching input values at index " + cfg.getSheetIndex() + ":" + cfg.getColumnIndex() + ":" + cfg.getStartRowIndex() + " (sheet:column:row)...");
        try {
            List<String> inputs = new DataReader(file).readColumn(cfg.getSheetIndex(), cfg.getColumnIndex(), cfg.getStartRowIndex());
            List<Long> numbers = new DataConverter().stringListToLongList(inputs);
            List<Long> primeNumbers = MathUtil.filterPrimeNumbers(numbers);
            for (long prime : primeNumbers) {
                System.out.println(prime);
            }
            System.out.println("In total found " + primeNumbers.size() + " prime numbers out of " + numbers.size() + " numbers given as input.");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
