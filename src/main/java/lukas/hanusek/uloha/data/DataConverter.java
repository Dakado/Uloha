package lukas.hanusek.uloha.data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lukas Hanusek
 */
public class DataConverter {
    
    /**
     * Convert String list to Long list
     * @param input
     * @return 
     */
    public List<Long> stringListToLongList(List<String> input) {
        List<Long> output = new ArrayList<Long>();
        int i = 0;
        for (String s : input) {
            try {
                output.add(Long.valueOf(s));
            } catch (NumberFormatException e) {
                System.out.println("Found invalid value at index " + i + ": " + s);
            }
            i++;
        }
        return output;
    }
    
}
