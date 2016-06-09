import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Rofgar
 * @since 6/4/16
 */
public class SolutionTest {

    @Test
    public void test() throws Exception {
        Parser parser = new Parser(getClass().getResourceAsStream("resource.xlsx"));
        List<DataRow> data = parser.parse().findAllWhere("FLAG", "Y");

        List<DataRow> expected = new ArrayList<>();
        expected.add(create("Y", "Test", "Test", 1));
        expected.add(create("Y", "another", "another", 3));
        assertThat(data, equalTo(expected));
    }

    public DataRow create(String flag, String name, String value, Integer index) {
        DataRow dataRow = new DataRow();
        dataRow.put("FLAG", flag);
        dataRow.put("NAME", name);
        dataRow.put("VALUE", value);
        dataRow.setIndex(index);
        return dataRow;
    }

}
