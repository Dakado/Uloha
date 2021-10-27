package lukas.hanusek.uloha.validator.objects;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lukas Hanusek
 */
public class ValidatorResult {

    private List<String> messages;

    /**
     * Reject validation 
     * @param reason 
     */
    public void reject(String reason) {
        if (messages == null) {
            messages = new ArrayList();
        }
        messages.add(reason);

    }

    /**
     * Get all errors
     * @return 
     */
    public List<String> getErrors() {
        return messages;
    }

    /**
     * Check whether validated object is valid
     * @return 
     */
    public boolean isValid() {
        return messages == null;
    }
    
    @Override
    public String toString() {
        if (this.isValid()) {
            return "Input is valid";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Input is invalid, following errors occured: " + System.lineSeparator());
        for (String s : this.messages) {
            sb.append(s);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

}
