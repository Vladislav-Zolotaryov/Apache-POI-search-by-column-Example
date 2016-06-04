import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rofgar
 * @since 6/4/16
 */
public class Parser {

    private InputStream stream;

    public Parser(InputStream stream) {
        this.stream = stream;
    }

    public Document parse() {
        try {
            Workbook wb = WorkbookFactory.create(stream);

            //TODO better sheet searching
            Sheet sheet = wb.getSheetAt(0);
            Iterator<Row> rows = sheet.rowIterator();

            List<String> headers = new ArrayList<>();
            if (rows.hasNext()) {
                Row row = rows.next();
                for (Cell cell : row) {
                    headers.add(cell.getStringCellValue());
                }
            }

            List<DataRow> contents = new ArrayList<>();
            while (rows.hasNext()) {
                Row row = rows.next();
                DataRow dataRow = new DataRow();
                dataRow.setIndex(row.getRowNum());
                for (Cell cell : row) {
                    //TODO safeguard for header resolving, cell column index might be out of bound for header array
                    dataRow.put(
                            headers.get(cell.getColumnIndex()),
                            cell.getStringCellValue()
                    );
                }
                contents.add(dataRow);
            }

            return new Document(headers, contents);
        } catch (IOException | InvalidFormatException e) {
            throw new RuntimeException(e);
        }
    }

}
