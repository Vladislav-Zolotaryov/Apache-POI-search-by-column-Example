import java.util.ArrayList;
import java.util.List;

/**
 * @author Rofgar
 * @since 6/4/16
 */
public class Document {

    private List<String> headers;

    private List<DataRow> contents;

    public Document(List<String> headers, List<DataRow> contents) {
        this.headers = headers;
        this.contents = contents;
    }

    public List<DataRow> findAllWhere(String column, String value) {
        List<DataRow> result = new ArrayList<>();
        for (DataRow content : contents) {
            if (content.get(column).equals(value)) {
                result.add(content);
            }
        }
        return result;
    }

    public List<DataRow> getContents() {
        return contents;
    }

    public void setContents(List<DataRow> contents) {
        this.contents = contents;
    }

    public List<String> getHeaders() {
        return headers;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    @Override
    public String toString() {
        return "Document{" +
                "headers=" + headers +
                ", contents=" + contents +
                '}';
    }

}
