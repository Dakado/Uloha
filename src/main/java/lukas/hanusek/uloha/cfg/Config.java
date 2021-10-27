package lukas.hanusek.uloha.cfg;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Lukas Hanusek
 */
public class Config {
    
    private static final String cfgFileName = "config.yaml";

    private static Config config;

    private int sheetIndex, columnIndex, startRowIndex;

    public static Config getInstance() {
        if (config == null) {
            try {
                File cfg = new File(cfgFileName);
                if (cfg.exists()) {
                    ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
                    config = objectMapper.readValue(cfg, Config.class);
                } else {
                    System.out.println("Config file does not exists!");
                    config = new Config();
                    config.save();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return config;
    }
    
    private void save() throws IOException {
        File file = new File(cfgFileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        this.setColumnIndex(1);
        this.setSheetIndex(0);
        this.setStartRowIndex(1);
        config = this;
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER));
        objectMapper.writeValue(file, this);
    }

    public int getSheetIndex() {
        return sheetIndex;
    }

    public void setSheetIndex(int sheetIndex) {
        this.sheetIndex = sheetIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

    public int getStartRowIndex() {
        return startRowIndex;
    }

    public void setStartRowIndex(int startRowIndex) {
        this.startRowIndex = startRowIndex;
    }

}
