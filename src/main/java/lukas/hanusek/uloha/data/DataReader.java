package lukas.hanusek.uloha.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author Lukas Hanusek
 */
public class DataReader {

    /**
     * Data file
     */
    private File file;

    /**
     * 
     * @param file
     * @throws FileNotFoundException 
     */
    public DataReader(String file) throws FileNotFoundException {
        File f = new File(file);
        if (!f.exists()) {
            throw new FileNotFoundException("Data file " + f.getAbsolutePath() + " not found!");
        }
        this.file = f;
    }

    /**
     * Reads all values in the specified sheet and column as strings
     * @param sheetIndex
     * @param columnIndex
     * @param rowStartIndex
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public List<String> readColumn(int sheetIndex, int columnIndex, int rowStartIndex) throws FileNotFoundException, IOException {
        List<String> result = new ArrayList();
        try (FileInputStream fis = new FileInputStream(file); HSSFWorkbook wb = new HSSFWorkbook(fis);) {
            int currentRow = 0;
            for (Row row : wb.getSheetAt(sheetIndex)) {
                if (currentRow >= rowStartIndex)
                for (Cell cell : row) {
                    if (columnIndex == cell.getColumnIndex()) result.add(cell.getStringCellValue());
                }
                currentRow++;
            }
        }
        return result;
    }

}
