import java.util.HashMap;
import java.util.Map;

/**
 * @author Rofgar
 * @since 6/4/16
 */
public class DataRow {

    private Map<String, String> values = new HashMap<>();
    private Integer index;

    public String put(String columnName, String value) {
        return values.put(columnName, value);
    }

    public String get(String columnName) {
        return values.get(columnName);
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }


    @Override
    public String toString() {
        return "DataRow{" +
                "values=" + values +
                ", index=" + index +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataRow dataRow = (DataRow) o;

        if (values != null ? !values.equals(dataRow.values) : dataRow.values != null) return false;
        return !(index != null ? !index.equals(dataRow.index) : dataRow.index != null);

    }

    @Override
    public int hashCode() {
        int result = values != null ? values.hashCode() : 0;
        result = 31 * result + (index != null ? index.hashCode() : 0);
        return result;
    }

}
