package lukas.hanusek.uloha.validator;

import java.io.File;
import lukas.hanusek.uloha.validator.objects.ValidatorResult;

/**
 *
 * @author Lukas Hanusek
 */
public class InputFileValidator implements IValidator {

    @Override
    public ValidatorResult validate(Object object) {
        ValidatorResult vr = new ValidatorResult();
        if (object instanceof String) {
            String s = (String)object;
            if (s.isEmpty()) {
                vr.reject("Input file cannot be an empty string!");
                return vr;
            }
            if (!s.endsWith(".xlsx")) {
                vr.reject("Only .xlsx files are supported!");
                return vr;
            }
            File f = new File(s);
            if (!f.exists()) {
                vr.reject("File " + f.getAbsolutePath() + " does not exist!");
                return vr;
            }
        } else {
            vr.reject("Invalid input!");
        }
        return vr;
    }

}
