package lukas.hanusek.uloha.validator;

import java.io.File;
import java.io.FileInputStream;
import lukas.hanusek.uloha.validator.objects.ValidatorResult;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
            //check if string is not empty
            if (s.isEmpty()) {
                vr.reject("Input file cannot be an empty string!");
                return vr;
            }
            //check file extension
            if (!s.endsWith(".xlsx")) {
                vr.reject("Only .xlsx files are supported!");
                return vr;
            }
            //check if file exists
            File f = new File(s);
            if (!f.exists()) {
                vr.reject("File " + f.getAbsolutePath() + " does not exist!");
                return vr;
            }
            //check if the file is in correct format and can be read
            try (FileInputStream fis = new FileInputStream(s); XSSFWorkbook wb = new XSSFWorkbook(fis);) {  
            } catch (Exception e) {
                vr.reject(e.getLocalizedMessage());
            }
        } else {
            vr.reject("Invalid input!");
        }
        return vr;
    }

}
