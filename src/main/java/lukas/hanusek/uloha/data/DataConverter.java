package lukas.hanusek.uloha.data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lukas Hanusek
 */
public class DataConverter {
    
    private String[] keywords;
    
    /**
     * Initialize data converter with list of ignored keywords
     * @param keywords 
     */
    public DataConverter(String[] keywords) {
        this.keywords = keywords;
    }
    
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
                for (String key : keywords) {
                    if (s.contains(key)) continue;
                }
                output.add(Long.valueOf(s));
            } catch (NumberFormatException e) {
                System.out.println("Found invalid value at index " + i + ": " + s);
            }
            i++;
        }
        return output;
    }
    
}
