package lukas.hanusek.uloha;

import lukas.hanusek.uloha.validator.InputFileValidator;
import lukas.hanusek.uloha.validator.objects.ValidatorResult;

/**
 *
 * @author Lukas Hanusek
 */
public class Main {
    
    public static void main(String args[]) {
        if (args.length != 1) {
            System.out.println("Please specify .xlsx file as runtime argument!");
            return;
        }
        process(args[0]);
    }
    
    public static void process(String file) {
        ValidatorResult vr = new InputFileValidator().validate(file);
        if (!vr.isValid()) {
            System.out.println(vr.toString());
            return;
        }
        
    }
    
}
